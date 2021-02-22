package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.enteties.Employees;
import com.company.repositories.EmployeesRepository;
import com.company.repositories.interfaces.IEmployeesRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEmployeesRepository employeeRepository = new EmployeesRepository(db) {
            @Override
            public boolean createEmployees(Employees employee) {
                return false;
            }

            @Override
            public List<Employees> getAllEmployees() {
                return null;
            }
        };


        ;
    }
}