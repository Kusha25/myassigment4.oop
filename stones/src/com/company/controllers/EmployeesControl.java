package com.company.controllers;

import com.company.enteties.Employees;
import com.company.repositories.interfaces.IEmployeesRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeesControl {
    private final IEmployeesRepository repo;
    public EmployeesControl(IEmployeesRepository repo) {
        this.repo=repo;
    }


    public String createEmployees(String firstname, String secondname,String gender, String position) {
        Employees employees = new Employees(firstname,secondname,gender,position);
        boolean created = repo.createEmployees(employees);
        return (    created?"Worker adding was failed!":"Worker has been successfully created!"   );
    }

    public String getEmployee(int id) {
        Employees employee = repo.getEmployees(id);

        return (employee == null ? "Employee wasn't found!" : employee.toString());
    }

    public ArrayList<Employees> getAllEmployees() {
        List<Employees> employees = repo.getAllEmployees();
        return (ArrayList<Employees>) employees;
    }

}
