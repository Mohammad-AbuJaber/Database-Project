package group.finalproject;

import Connection.Execute;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Entities.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class departmentsController implements Initializable {

    @FXML
    private TableView<Departments> depTable;
    @FXML
    private TableView<Departments> depSearchTable;

    @FXML
    private TableColumn<Departments, Integer> ID;
    @FXML
    private TableColumn<Departments, Integer> ID1;

    @FXML
    private TableColumn<Departments, String> DName;
    @FXML
    private TableColumn<Departments, String> DName1;

    @FXML
    private TableColumn<Departments, Integer> empID;
    @FXML
    private TableColumn<Departments, Integer> empID1;

    @FXML
    private TextField txt_deleteField;

    @FXML
    private TextField txt_filterField;

    @FXML
    private TextField txt_newValueDep;

    @FXML
    public TextField txt_Dname;

    @FXML
    public Button insertButton;

    private ArrayList<Departments> list;
    private ObservableList<Departments> oblist;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list = Queries.getDepInfo();
        oblist = FXCollections.observableList(list); //create an observable list from array

        ID.setCellValueFactory(new PropertyValueFactory<Departments, Integer>("Department_ID"));
        DName.setCellValueFactory(new PropertyValueFactory<Departments, String>("Department_Name"));
        empID.setCellValueFactory(new PropertyValueFactory<Departments, Integer>("numOfEmployeesInDepartment"));
        System.out.println(oblist);
        depTable.setItems(oblist);
    }


    @FXML
    void insertDep(ActionEvent event) {

        boolean isError = checkEmpty();

        if (!isError) {
            try {
                Queries.addDep(txt_Dname.getText());
                JOptionPane.showMessageDialog(null, "Dep Added Successfully");
                oblist.add(new Departments(Queries.maxDepID(),txt_Dname.getText(),Queries.numOfEmployeesInDep(Queries.maxDepID())));

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Check Your Input Data ==> A mismatch occurred");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private boolean checkEmpty() {
        if (txt_Dname.getText().isEmpty())
            return true;
        return false;
    }

    @FXML
    void searchDep(ActionEvent event) {
        System.out.println(Queries.getDepartmentNameFromID(15));
        ArrayList<Departments> searchList = Queries.searchDep(txt_filterField.getText());
        ObservableList<Departments> searchObList = FXCollections.observableList(searchList);

        ID1.setCellValueFactory(new PropertyValueFactory<Departments, Integer>("Department_ID"));
        DName1.setCellValueFactory(new PropertyValueFactory<Departments, String>("Department_Name"));
        empID1.setCellValueFactory(new PropertyValueFactory<Departments, Integer>("numOfEmployeesInDepartment"));
        System.out.println(searchObList);
        depSearchTable.setItems(searchObList);
    }

    @FXML
    void deleteDep(ActionEvent event) {
        Queries.deleteDep(txt_deleteField.getText());

        list = Queries.getDepInfo();
        oblist = FXCollections.observableList(list); //create an observable list from array

        ID.setCellValueFactory(new PropertyValueFactory<Departments, Integer>("Department_ID"));
        DName.setCellValueFactory(new PropertyValueFactory<Departments, String>("Department_Name"));
        empID.setCellValueFactory(new PropertyValueFactory<Departments, Integer>("numOfEmployeesInDepartment"));
        System.out.println(oblist);
        depTable.setItems(oblist);
    }

    @FXML
    void updateDep(ActionEvent event) throws IOException{
        boolean isError = false;
        if (txt_newValueDep.getText().isEmpty() || txt_filterField.getText().isEmpty()){
            isError = true;
        }
        if (!isError){
            Queries.updateDep(txt_filterField.getText(),txt_newValueDep.getText());
            list = Queries.getDepInfo();
            oblist = FXCollections.observableList(list); //create an observable list from array

            ID.setCellValueFactory(new PropertyValueFactory<Departments, Integer>("Department_ID"));
            DName.setCellValueFactory(new PropertyValueFactory<Departments, String>("Department_Name"));
            empID.setCellValueFactory(new PropertyValueFactory<Departments, Integer>("numOfEmployeesInDepartment"));
            System.out.println(oblist);
            depTable.setItems(oblist);
        }
    System.out.println("\n\n\n\n\n"+isError);
    }
}