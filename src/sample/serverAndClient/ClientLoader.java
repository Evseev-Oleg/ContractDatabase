package sample.serverAndClient;

import java.io.*;
import java.net.*;

/**
 * класс создающий клиента
 */
public class ClientLoader {
    private Socket socket;
    Contract contract;

    /**
     * метод создающий соединение с сервером
     */
    public void connect() {
        try {
            socket = new Socket("localhost", 8808);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод отправляющий запрос к серверу
     *
     * @param numberContract
     * @param dateContract
     */
    public void handle(String numberContract, String dateContract) {
        try {
            contract = new Contract(numberContract, dateContract);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(contract.getNumberContract() + " " + contract.getDateContract());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод закрывает соединение
     */
    public void end() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}