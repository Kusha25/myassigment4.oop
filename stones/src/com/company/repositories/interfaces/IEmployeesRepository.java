package com.company.repositories.interfaces;

import com.company.enteties.Employees;


import java.util.List;

public interface IEmployeesRepository
{

        boolean createEmployees(Employees employee);
        Employees getEmployees(int id);
        List<Employees> getAllEmployees();



}
