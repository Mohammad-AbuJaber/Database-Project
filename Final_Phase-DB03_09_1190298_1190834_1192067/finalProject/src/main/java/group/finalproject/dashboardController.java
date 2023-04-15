package group.finalproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {
    @FXML
    private Label NOD;

    @FXML
    private Label NOE;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NOE.setText("Number of Employees: " + Queries.numOfEmployees());
        NOD.setText("Number of Departments: " + Queries.numOfDepartments());
    }
}
