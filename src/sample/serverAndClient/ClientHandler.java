package sample.serverAndClient;

import sample.DatabaseHandler;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * класс выделяющий отдельный поток соединению с сервером
 */
public class ClientHandler extends Thread {
    private final Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
        start();
    }

    /**
     * переопределенный метод run()
     * в этом методе сервер соединяется с БД
     * и вносит измения в зависимости от полученных параметров
     */
    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dis = new DataInputStream(client.getInputStream());
                if (dis.available() <= 0) return;
                String var = dis.readUTF();
                String[] res = var.split(" ");

                DatabaseHandler databaseHandler = new DatabaseHandler();
                databaseHandler.chekContract(res[0], res[1]);

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}