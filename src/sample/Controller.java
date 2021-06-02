package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.serverAndClient.ClientLoader;

/**
 * класс контрольер fxml окна
 */
public class Controller {
    ClientLoader clientLoader;

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

    /**
     * метод определящий введенное значение
     * и проверяющий на пустое значение
     */
    @FXML
    void initialize() {
        addContractButton.setOnAction(event -> {
            String newNumberContract = numberContract.getText().trim();
            String newDataContract = dataContract.getText().trim();

            if (!newNumberContract.equals("") && !newDataContract.equals("")) {
                makeClient(newNumberContract, newDataContract);
            }

        });
    }

    /**
     * метод создающий, запускающий, закрыващий клиента
     * чистит окна после ввода данных
     *
     * @param newNumberContract
     * @param newDataContract
     */
    private void makeClient(String newNumberContract, String newDataContract) {
        clientLoader = new ClientLoader();
        clientLoader.connect();
        clientLoader.handle(newNumberContract, newDataContract);
        clientLoader.end();
        numberContract.clear();
        dataContract.clear();
    }
}


