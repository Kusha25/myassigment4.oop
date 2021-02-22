package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.enteties.Employees;
import com.company.enteties.Projects;
import com.company.repositories.interfaces.IProjectsRepository;

import java.sql.Connection;
import java.util.ArrayList;

public class ProjectsRepository implements IProjectsRepository {

        private final IDB db;
        private ArrayList<Employees> employeeList;
        private ArrayList<Projects> projectList;

    public ProjectsRepository(IDB db) {
            this.db = db;
        }
    public ProjectsRepository(IDB db, IDB db1) {
        this.db = db1;
    }

          public void createProjects(EmployeesRepository project) {
            projectList = new ArrayList<Projects>();
            employeeList = (ArrayList<Employees>) project.getAllEmployees();
            projectList.add(project);
        }


    @Override
    public boolean createProjects(Projects projects) {
        return false;
    }

    @Override
        public void addEmployees(Employees employee) {
            Connection con = null;
            employeeList.add(employee);
        }


        @Override
        public Projects getProjects(Projects project) {
            if(projectList.contains(project)){
                return project;
            }
            return null;
        }

        @Override
        public ArrayList<Projects> getAllProjects() {
            return projectList;
        }


    public Projects getProjectSum(Projects price) {
        return price;
    }


}
