package group.finalproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Entities.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.JOptionPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class employeesController implements Initializable {
    @FXML
    private TableView<Employee> empTable;

    @FXML
    private TableColumn<Employee, String> FName;

    @FXML
    private TableColumn<Employee, Integer> ID;

    @FXML
    private TableColumn<Employee, String> LName;

    @FXML
    private TableColumn<Employee, Integer> SSN;

    @FXML
    private TableColumn<Employee, String> depID;

    @FXML
    private TableColumn<Employee, String> empAddress;

    @FXML
    public TextField filterField;

    @FXML
    public TextField txt_DepID;

    @FXML
    public TextField txt_Fname;

    @FXML
    private TextField txt_Address;

    @FXML
    public TextField txt_Lname;

    @FXML
    public TextField txt_SSN;

    @FXML
    public Button insertButton;

    private ArrayList<Employee> list;
    private ObservableList<Employee> oblist;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        list = Queries.getEmployeesInfo();
        oblist = FXCollections.observableList(list); //create an observable list from array

//
//
//        TableColumn ID = new TableColumn<>("Employee_ID");
//        TableColumn FName = new TableColumn<>("FName");
//        TableColumn LName = new TableColumn<>("LName");
//        TableColumn SSN = new TableColumn<>("SSN");
//        TableColumn depID = new TableColumn<>("depID");
//        TableColumn empAddress = new TableColumn<>("empAddress");
        ID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Employee_ID"));
        FName.setCellValueFactory(new PropertyValueFactory<Employee, String>("Employee_Fname"));
        LName.setCellValueFactory(new PropertyValueFactory<Employee, String>("Employee_Lname"));
        SSN.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Employee_SSN"));
        depID.setCellValueFactory(new PropertyValueFactory<Employee, String>("Department_Name"));
        empAddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("city"));
        System.out.println(oblist);
        empTable.setItems(oblist);
    }



    @FXML
    void insertEmp(ActionEvent event) {

        boolean isError = checkEmpty();

        if (!isError) {
            try {
                Queries.addEmp(txt_Fname.getText(), txt_Lname.getText(), Integer.parseInt(txt_SSN.getText()), Queries.getDepartmentIDFromDepName(txt_DepID.getText()), Queries.getCityIDFromCityName(txt_Address.getText()));
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                oblist.add(new Employee(Queries.maxEmpID(),txt_Fname.getText(), txt_Lname.getText(), Integer.parseInt(txt_SSN.getText()), txt_DepID.getText(), txt_Address.getText()));

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Check Your Input Data ==> A mismatch occurred");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private boolean checkEmpty() {
        if (txt_Fname.getText().isEmpty())
            return true;
        else if (txt_Lname.getText().isEmpty())
            return true;
        else if (txt_SSN.getText().isEmpty())
            return true;
        else if (txt_DepID.getText().isEmpty())
            return true;
        else if (txt_Address.getText().isEmpty())
            return true;
        return false;
    }

}
