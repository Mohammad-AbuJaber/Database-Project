package group.finalproject;

import Entities.*;
import Connection.Execute;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Queries {
    public static void addEmp(String Fname, String Lname, int SSN, int depID,int empAddress) throws SQLException, ClassNotFoundException {


        String query = "insert into Employee (Employee_Fname,Employee_Lname,Employee_SSN,Department_ID,Employee_Address_ID)" +
                "values(\"" + Fname + "\",\"" +Lname + "\"," + SSN + "," + depID + "," + empAddress + ")";

        Execute.executeQuery(query);
    }

    public static void addDep(String Dname) throws SQLException, ClassNotFoundException {


        String query = "insert into Department (Department_Name)" +
                "values(\"" + Dname + "\");";

        Execute.executeQuery(query);

    }
    public static int numOfEmployees (){
        String query = "select count(Employee_ID) from Employee;";
        int numEmp =0;
        try {
            Execute.setResultSELECTQuery(query);
            Execute.resultSet.next();
            numEmp = Execute.resultSet.getInt(1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numEmp;
    }

    public static int numOfDepartments (){
        String query = "select count(Department_ID) from Department;";
        int numDep =0;
        try {
            Execute.setResultSELECTQuery(query);
            Execute.resultSet.next();
            numDep = Execute.resultSet.getInt(1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numDep;
    }


    public static int maxEmpID (){
        String query = "select max(Employee_ID) from Employee;";
        int maxEmpID =0;
        try {
            Execute.setResultSELECTQuery(query);
            Execute.resultSet.next();
            maxEmpID = Execute.resultSet.getInt(1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxEmpID;
    }

    public static int maxDepID (){
        String query = "select max(Department_ID) from Department;";
        int maxDepID =0;
        try {
            Execute.setResultSELECTQuery(query);
            Execute.resultSet.next();
            maxDepID = Execute.resultSet.getInt(1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxDepID;
    }

    public static int getCityIDFromCityName(String name){
        int id = 0;
        String query = "select id from Employee_Address where City = \"" + name + "\";";
        try {
            Execute.setResultSELECTQuery(query);
            Execute.resultSet.next();
            id = Execute.resultSet.getInt(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int getDepartmentIDFromDepName(String name){
        int id = 0;
        String query = "select Department_ID from Department where Department_Name = \"" + name + "\";";
        try {
            Execute.setResultSELECTQuery(query);
            Execute.resultSet.next();
            id = Execute.resultSet.getInt(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static String getDepartmentNameFromID(int ID){
        String name = "";
        String query = "select Department_Name from Department where Department_ID = \"" + ID + "\";";
        try {
            Execute.setResultSELECTQuery(query);
            Execute.resultSet.next();
            name = Execute.resultSet.getString(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public static ArrayList<Departments> getDepInfo(){

        String query = "SELECT D.Department_ID, D.Department_Name,\n" +
                "       (SELECT COUNT(*) \n" +
                "        FROM Employee E\n" +
                "        WHERE E.Department_ID = D.Department_ID\n" +
                "       ) as NumberOfEmployeesPerDepatment \n" +
                "FROM Department D;";

        ArrayList<Departments> dep = new ArrayList<Departments>();
//        String query ="SELECT * FROM Employee";

        try {
            Execute.setResultSELECTQuery(query);

            while(Execute.resultSet.next()){
//                Employee emp = new Employee();
//                System.out.println(Execute.resultSet.getString(1));
                int id = Execute.resultSet.getInt(1);
                String DN = Execute.resultSet.getString(2);
                int EID = Execute.resultSet.getInt(3);
                System.out.println(id+"  "+DN +"  "+EID);
                dep.add(new Departments(id,DN,EID));
//employees.add(new Employee(Integer.parseInt(Execute.resultSet.getString(1)), Execute.resultSet.getString(2), Execute.resultSet.getString(3), Integer.parseInt(Execute.resultSet.getString(4)), Execute.resultSet.getString(5), Execute.resultSet.getString(6) ) );


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dep;
    }

    public static int numOfEmployeesInDep(int depID){
        int num = 0;
        String query = "SELECT COUNT(E.Employee_ID) \n" +
                "        FROM Employee E , Department D\n" +
                "        WHERE E.Department_ID = D.Department_ID AND E.Department_ID =" + depID + ";";
        try {
            Execute.setResultSELECTQuery(query);
            Execute.resultSet.next();
            num = Execute.resultSet.getInt(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public static ArrayList<Employee> getEmployeesInfo(){

        String query = "select E.Employee_ID, E.Employee_Fname, E.Employee_Lname, E.Employee_SSN, D.Department_Name, EA.City \n" +
                "from Employee E, Department D, Employee_Address EA\n" +
                "WHERE EA.id = E.Employee_Address_ID \n" +
                "AND   E.Department_ID = D.Department_ID; ";

        ArrayList<Employee> employees = new ArrayList<Employee>();
//        String query ="SELECT * FROM Employee";
        System.out.println(query);

        try {
            Execute.setResultSELECTQuery(query);

            while(Execute.resultSet.next()){
//                Employee emp = new Employee();
//                System.out.println(Execute.resultSet.getString(1));
                int id = Execute.resultSet.getInt(1);
                String FN = Execute.resultSet.getString(2);
                String LN = Execute.resultSet.getString(3);
                int ssn = Execute.resultSet.getInt(4);
                String DN = Execute.resultSet.getString(5);
                String city = Execute.resultSet.getString(6);
                System.out.println(id+"  "+FN+"  "+LN+"  "+ssn+"  "+DN+"  "+city);
                employees.add(new Employee(id,FN,LN,ssn,DN,city));
//employees.add(new Employee(Integer.parseInt(Execute.resultSet.getString(1)), Execute.resultSet.getString(2), Execute.resultSet.getString(3), Integer.parseInt(Execute.resultSet.getString(4)), Execute.resultSet.getString(5), Execute.resultSet.getString(6) ) );


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static ArrayList<Departments> searchDep(String searchDep){
        String query;
        if (isInt(searchDep)){
            query = "  select *\n" +
                    "  from Department D\n" +
                    "  where D.Department_ID =" + Integer.parseInt(searchDep) + ";";
        }
        else {
            query = "select *\n" +
                    "  from Department D\n" +
                    "  where D.Department_Name =\"" + searchDep + "\";";
        }

        System.out.println(query);

        ArrayList<Departments> dep = new ArrayList<Departments>();

        try {
            Execute.setResultSELECTQuery(query);

            while(Execute.resultSet.next()){

                int id = Execute.resultSet.getInt(1);
                String DN = Execute.resultSet.getString(2);
//                int EID = Execute.resultSet.getInt(3);
                int EID = numOfEmployeesInDep(Execute.resultSet.getInt(1));
                System.out.println(id+"  "+DN +"  "+EID);
                dep.add(new Departments(id,DN,EID));
                System.out.println(dep);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dep;
    }

    public static void deleteDep(String dep) throws IllegalArgumentException {
        String query;
        if (isInt(dep)){
            query = "delete from Department where Department_ID =" + dep + ";";
        }
        else {
            query = "delete from Department where Department_ID =" + getDepartmentIDFromDepName(dep) + ";";
        }

        try {
            Execute.executeQuery(query);
            JOptionPane.showMessageDialog(null, "Department" + dep +" was deleted Successfully!");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Check Your Input Data ==> You Should insert the ID Of the Department");
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Check Your Input Data ==> You Should insert the ID Of the Department");
            e.printStackTrace();
        }
    }
    public static void updateDep(String dep,String newValueDep) throws IllegalArgumentException {
        String query;

        if (isInt(dep)){
            query = "update Department set Department_Name = \"" + newValueDep + "\"where Department_ID =" + dep + ";";
        }
        else {
            query = "update Department set Department_Name = \"" + newValueDep + "\"where Department_ID =" + getDepartmentIDFromDepName(dep) + ";";
        }

        try {
            Execute.executeQuery(query);
            JOptionPane.showMessageDialog(null, "Department " + dep +" was updated Successfully!");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Check Your Input Data ===> You Should insert the Name Of the Department");
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Check Your Input Data ==> You Should insert the Name Of the Department");
            e.printStackTrace();
        }
    }


    private static boolean isInt(String test){
        try{
            int x = Integer.parseInt(test);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
