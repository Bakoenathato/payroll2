package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.ContactRepository;
import za.ac.cput.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    public EmployeeRepository employeeRepository;
    public ContactRepository contactRepository;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository, ContactRepository contactRepository) {
        this.employeeRepository = employeeRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Employee create(Employee employee) {
        contactRepository.save(employee.getContact());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee read(Long email){
        return employeeRepository.findById(email).orElse(null);
    }

    @Override
    public Employee update(Employee employee){
        contactRepository.save(employee.getContact());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
}
