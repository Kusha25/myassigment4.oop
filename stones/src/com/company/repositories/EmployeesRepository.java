package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.enteties.Employees;
import com.company.enteties.Projects;
import com.company.repositories.interfaces.IEmployeesRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class EmployeesRepository extends Projects implements IEmployeesRepository {

    private final IDB db;
    public EmployeesRepository(IDB db) {
        this.db = db;
    }

    public boolean createEmployees(Employees emp) {
        Connection con = null;
        try {

            con = db.getConnection();
            String sql = "INSERT INTO employee(name,surname,gender,position ) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, emp.getName());
            st.setString(2, emp.getSecondname());
            st.setString(3, emp.getGender());
            st.setString(4, emp.getPosition());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    public Employees getEmployees(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,position FROM employee WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employees employee = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getString("position"));

                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    public List<Employees> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender, position FROM employee";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employees> employees = new ArrayList<>();
            while (rs.next()) {
                Employees emp = new Employees(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("gender"),
                        rs.getString("position"));


                employees.add(emp);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

}
