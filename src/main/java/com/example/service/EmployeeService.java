package com.example.service;

import com.example.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee();

    void save(Employee employee);

    Employee getById(Long id);

    void deleteViaId(long id);
}

