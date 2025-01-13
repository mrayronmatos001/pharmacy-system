package br.edu.ufrn.services;

import java.util.List;

import br.edu.ufrn.models.Employee;
import br.edu.ufrn.repository.EmployeeDao;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService() {
        this.employeeDao = new EmployeeDao();
    }

    public Employee getEmployeeById(Long id) {
        return employeeDao.findById(id);
    }

    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    public boolean save(Employee employee) {
        return employeeDao.save(employee);
    }

    public boolean update(Employee employee, String[] params) {
        return employeeDao.update(employee, params);
    }

    public boolean delete(Long id) {
        return employeeDao.delete(id);
    }
}

