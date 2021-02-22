package com.company.repositories.interfaces;

import com.company.enteties.Employees;
import com.company.enteties.Projects;

import java.util.ArrayList;

public interface IProjectsRepository {
    boolean createProjects(Projects projects);


    void addEmployees(Employees employee);
    Projects getProjects(Projects projects);
    ArrayList<Projects> getAllProjects();
    Projects getProjectSum(Projects price);


}
