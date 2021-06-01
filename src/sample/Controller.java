package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addContractButton;

    @FXML
    private TextField numberContract;

    @FXML
    private TextField dataContract;

    @FXML
    void initialize() {
        addContractButton.setOnAction(event -> {
            String newNumberContract = numberContract.getText().trim();
            String newDataContract = dataContract.getText().trim();

            if (!newNumberContract.equals("") && !newDataContract.equals(""))
                makeContract(newNumberContract, newDataContract);
            else
                System.out.println("Fields is empty");
        });
    }

    private void makeContract(String newNumberContract, String newDataContract) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.chekContract(newNumberContract, newDataContract);
        numberContract.clear();
        dataContract.clear();
    }
}


