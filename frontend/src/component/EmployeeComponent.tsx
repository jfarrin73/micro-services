import {useEffect, useState} from "react";
import employeeService from "../service/employee-service.ts";

type Employee = { firstName: string }
type Department = { departmentName: string }
type Organization = { organizationName: string }

const EmployeeComponent = () => {
  const [employee, setEmployee] = useState<Employee>()
  const [department, setDepartment] = useState<Department>()
  const [organization, setOrganization] = useState<Organization>()

  useEffect(() => {
    employeeService.getEmployee().then(r => {
      setEmployee(r.data.employeeDto)
      setDepartment(r.data.departmentDto)
      setOrganization(r.data.organizationDto)
    })
  }, []);

  return (
    <div className='bg-black text-white h-screen w-screen'>
      Details
      <p>{employee?.firstName}</p>
      <p>{department?.departmentName}</p>
      <p>{organization?.organizationName}</p>
    </div>
  );
};

export default EmployeeComponent;