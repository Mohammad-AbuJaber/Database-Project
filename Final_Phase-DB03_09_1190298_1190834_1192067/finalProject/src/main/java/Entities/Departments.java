package Entities;

public class Departments {


    private int Department_ID;
    private String Department_Name;
    private int numOfEmployeesInDepartment;

    public Departments(int Department_ID, String Department_Name, int Employee_ID) {
        this.Department_ID = Department_ID;
        this.Department_Name = Department_Name;
        this.numOfEmployeesInDepartment = Employee_ID;
    }

    public Departments() {

    }

    @Override
    public String toString() {
        return "Departments{" +
                "Department_ID=" + Department_ID +
                ", Department_Name='" + Department_Name + '\'' +
                ", Employee_ID=" + numOfEmployeesInDepartment +
                '}';
    }

    public int getDepartment_ID() {
        return Department_ID;
    }

    public void setDepartment_ID(int department_ID) {
        Department_ID = department_ID;
    }

    public String getDepartment_Name() {
        return Department_Name;
    }

    public void setDepartment_Name(String department_Name) {
        Department_Name = department_Name;
    }

    public int getNumOfEmployeesInDepartment() {
        return numOfEmployeesInDepartment;
    }

    public void setNumOfEmployeesInDepartment(int numOfEmployeesInDepartment) {
        this.numOfEmployeesInDepartment = numOfEmployeesInDepartment;
    }
}