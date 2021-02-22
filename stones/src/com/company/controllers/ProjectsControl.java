package com.company.controllers;

import com.company.enteties.Projects;
import com.company.repositories.interfaces.IProjectsRepository;

import java.util.List;

public class ProjectsControl {

    private final IProjectsRepository repos;
    public ProjectsControl( IProjectsRepository repos) {

        this.repos = repos;
    }
    public String createProjects(String name,int price){
        Projects projects = new Projects(name, price);
        boolean created=repos.createProjects(projects);
        return (    created?"Project creation was failed!":"Project has been successfully created!"   );
    }

    public List<Projects> getAllProjects() {
        List<Projects> projects = repos.getAllProjects();
        return projects;
    }

    public String getProjects(Projects projects) {
        Projects project=repos.getProjects(projects);
        return (projects==null?"Project not found!":projects.toString());
    }

    public String getProjectPrice(Projects price){
        Projects projects=repos.getProjectSum(price);
        return (projects==null?"Budget does not exist!":projects.toString());
    }
    public String calculatePrice(List<Projects> projects){
         int price =0;
        for(int i=0;i<projects.size();i++){
            price = price + projects.get(i).getPrice();
        }

        return "total price: " + price;
    }

}
