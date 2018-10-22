
package com.omfgdevelop.maximtesttask.model.Employee;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Department {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Employees")
    @Expose
    private List<Employee_> employees = null;
    @SerializedName("Departments")
    @Expose
    private List<SubDepartment> departments = null;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee_> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee_> employees) {
        this.employees = employees;
    }

    public List<SubDepartment> getSubDepartments() {
        return departments;
    }

    public void setSubDepartments(List<SubDepartment> departments) {
        this.departments = departments;
    }

}
