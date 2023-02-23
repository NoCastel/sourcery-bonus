package com.nocastel.task.employee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

@RestController
@RequestMapping("/employees")
public class EmployeesControler {
    private final EmployeeRepository employeeRepository;

    public EmployeesControler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @CrossOrigin
    @PostMapping
    public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
        // validate file
        if (file.isEmpty()) {
            System.out.println("empty");
        } else {
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                try (CSVReader csvReader = new CSVReader(reader)) {
                    List<String[]> val = csvReader.readAll();
                    //The first three characters of the first column are not part of the dataset
                    employeeRepository.save(new Employee(val.get(0)[0].substring(3), val.get(0)[1], Long.parseLong(val.get(0)[2])));
                    for (int i = 1; i < val.size(); i++) {
                        String name = val.get(i)[0];
                        String email = val.get(i)[1];
                        Long phoneNumber = Long.parseLong(val.get(i)[2]);
                        employeeRepository.save(new Employee(name, email, phoneNumber));
                    }
                }
            } catch (Exception ex) {
                System.out.println("Exeption post csv -> " + ex);
            }
        }
        return "OK";
    }
}
