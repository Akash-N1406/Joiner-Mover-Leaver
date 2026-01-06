package com.iga.model;

import com.opencsv.bean.CsvBindByName;

public class Identity {
    @CsvBindByName(column = "employeeId")
    private String employeeId;

    @CsvBindByName(column = "firstName")
    private String firstName;

    @CsvBindByName(column = "department")
    private String department;

    @CsvBindByName(column = "status")
    private String status;

    // Standard Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }
}