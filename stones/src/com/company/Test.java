package com.company;

import com.company.controllers.EmployeesControl;
import com.company.controllers.ProjectsControl;
import com.company.enteties.Employees;
import com.company.enteties.Projects;
import com.company.repositories.interfaces.IEmployeesRepository;
import com.company.repositories.interfaces.IProjectsRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private final EmployeesControl controller;
    private final ProjectsControl projectController;
    private final Scanner scanner;

    public Test(IEmployeesRepository repo, ProjectsControl projectController) {
        controller = new EmployeesControl(repo);
        this.projectController = projectController;
        scanner = new Scanner(System.in);
    }
        public Test(EmployeesControl controller, IProjectsRepository repos){
            this.controller = controller;
            projectController = new ProjectsControl(repos);
            scanner = new Scanner(System.in);
        }


    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to IT Company");
            System.out.println("Select option:");
            System.out.println("1. Get all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Add employee");
            System.out.println("4. Create project");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllEmployeesMenu();
                } else if (option == 2) {
                    getEmployeeByIdMenu();
                } else if (option == 3) {
                    createEmployeeMenu();
                } else if (option == 4) {
                    createProjectMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }

            System.out.println("***************");

        }
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() {
        System.out.println("Please enter firstname");
        String name = scanner.next();
        System.out.println("Please enter secondname");
        String surname = scanner.next();
        System.out.println("Please enter position in company:");
        scanner.nextLine();
        String position = scanner.nextLine();

    }

    public void createProjectMenu() {
        System.out.println("Write project name, how many employee in project, and employers' id");
        String name = scanner.next();
        int n = scanner.nextInt();
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = scanner.nextInt();
        }
        ArrayList<Employees> employeeList = new ArrayList<Employees>();
        ArrayList<Employees> projectEmployeeList = new ArrayList<Employees>();
        employeeList = controller.getAllEmployees();
        System.out.println("Employee list:");
        for (int i = 0; i < employeeList.size(); i++) {
            for (int j = 0; j < n; j++) {
                if (employeeList.get(i).getId() == id[j]) {
                    projectEmployeeList.add(employeeList.get(i));
                    System.out.println(employeeList.get(i).toString());

                }
            }
        }
    }
}