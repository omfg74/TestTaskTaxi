
package com.omfgdevelop.maximtesttask.model.Emplee;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.omfgdevelop.maximtesttask.model.Employee;
//import com.omfgdevelop.maximtesttask.model.Emplee.

public class Department {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Employees")
    @Expose
    private List<Employee> employees = null;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<SubDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(List<SubDepartment> departments) {
        this.departments = departments;
    }

}
