package Entities;

public class Employee {


    private int Employee_ID;
    private String Employee_Fname;
    private String Employee_Lname;
    private int Employee_SSN;
    private String Department_Name;
    private String city;

    public Employee(int employee_ID, String employee_Fname, String employee_Lname, int employee_SSN, String department_Name, String city) {
        this.Employee_ID = employee_ID;
        this.Employee_Fname = employee_Fname;
        this.Employee_Lname = employee_Lname;
        this.Employee_SSN = employee_SSN;
        this.Department_Name = department_Name;
        this.city = city;
    }

    public Employee() {

    }


    @Override
    public String toString() {
        return "Employee{" +
                "Employee_ID=" + Employee_ID +
                ", Employee_Fname='" + Employee_Fname + '\'' +
                ", Employee_Lname='" + Employee_Lname + '\'' +
                ", Employee_SSN=" + Employee_SSN +
                ", Department_Name='" + Department_Name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }



    public int getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        Employee_ID = employee_ID;
    }

    public String getEmployee_Fname() {
        return Employee_Fname;
    }

    public void setEmployee_Fname(String employee_Fname) {
        Employee_Fname = employee_Fname;
    }

    public String getEmployee_Lname() {
        return Employee_Lname;
    }

    public void setEmployee_Lname(String employee_Lname) {
        Employee_Lname = employee_Lname;
    }

    public int getEmployee_SSN() {
        return Employee_SSN;
    }

    public void setEmployee_SSN(int employee_SSN) {
        Employee_SSN = employee_SSN;
    }

    public String getDepartment_Name() {
        return Department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        Department_Name = department_Name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}



