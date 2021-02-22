package com.company.enteties;

public class Employees  {

    private int id;
    private String firstname;
    private String secondname;
    private String gender;
    private String position;



    public Employees(int id, String firstname, String gender, String position) {
        setName(firstname);
        setSecondname(secondname);
        setGender(this.gender);
        setPosition(this.position);
    }

    public Employees(int id, String firstname, String secondname, String gender,String position) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.gender = gender;
        this.position = position;
    }

    public Employees(String name) {
    }

    public Employees(String firstname, String secondname, String gender, String position) {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return firstname;
    }

    public void setName(String name) {
        this.firstname = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String surname) {
        this.secondname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition(){return position;}

    public void setPosition(String position){this.position = position;}


    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + firstname + '\'' +
                ", surname='" + secondname + '\'' +
                ", gender=" + gender + '\'' +
                ",position=" + position +
                '}';
    }
}

