function Employee({ values }) {
    return (
        <div class = "employee">
            <span>{values["name"]}, </span>
            <span>{values["email"]}, </span>
            <span>{values["phoneNumber"]} </span>
        </div>
    )
}

export default Employee;