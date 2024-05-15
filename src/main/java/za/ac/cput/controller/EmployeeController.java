package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }
    @PostMapping("/read/employeenumber")
    public Employee read(@PathVariable Long employeeNumber){
        return employeeService.read(employeeNumber);
    }
    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
    @PostMapping("/getall")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

}
