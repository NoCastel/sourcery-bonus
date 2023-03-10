import { useState, useEffect } from 'react';
import axios from 'axios';
import { v4 as uuidv4 } from 'uuid';

import './App.css';
import Employee from './Employee/Employee';

function App() {
  const [file, setFile] = useState({});
  const [sendCsv, setSendCsv] = useState(false);
  const [employees, setEmployees] = useState([]);

  const handleFileChange = (e: ChangeEvent<HTMLInputElement>) => {
    if (e.target.files)
      setFile(e.target.files[0]);
  };

  const handleUploadClick = () => {
    if (!file)
      return;

    const formData = new FormData();
    formData.append('file', file);
    axios.post('http://localhost:8080/employees', formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      },
    })
      .then(res => console.log(res))
      .catch(err => console.log(err));
    setFile({});
    setSendCsv(sendCsv ? false : true);
  }

  useEffect(() => {
    axios.get('http://localhost:8080/employees')
      .then(res => {
        setEmployees(res.data);
      }
      )
  }, [sendCsv]);


  return (
    <div className="App" >
      <header className="App-header">
        <div class="csv-form">
          <input type="file" onChange={handleFileChange} />
          <div>{file && `${file.name} - ${file.type}`}</div>
          <button onClick={handleUploadClick}>Upload</button>
        </div>
      </header>
        <main class ="mainFrame" >
          {employees.map(e => <Employee key={uuidv4()} values={e} />)}
      </main >
    </div >
  );
}

export default App;
