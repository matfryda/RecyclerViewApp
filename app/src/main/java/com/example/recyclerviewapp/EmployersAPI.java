package com.example.recyclerviewapp;

public class EmployersAPI {

    private int userId;
    private int id;
    private String employee_name;
    private double salary;
    private int employee_age;
    private String profile_image;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public double getSalary() {
        return salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public EmployersAPI(int userId, int id, String employee_name, double salary, int employee_age, String profile_image) {
        this.userId = userId;
        this.id = id;
        this.employee_name = employee_name;
        this.salary = salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }
}
