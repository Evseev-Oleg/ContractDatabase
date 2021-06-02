package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * класс определяющий работу сервера
 */
public class ServerLoader {
    ServerSocket serverSocket;

    public static void main(String[] args) {
        ServerLoader serverLoader = new ServerLoader();
        serverLoader.start();
        serverLoader.handle();
    }

    /**
     * метод создающий сервер
     */
    public void start() {
        try {
            serverSocket = new ServerSocket(8808);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод ждет запрос от клиента, когда клиент
     * прислал запрос, перенаправляет в класс ClientHandler
     * для выделения ему потока и дальнейшей логики
     */
    public void handle() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new sample.serverAndClient.ClientHandler(client);
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

    /**
     * метод закрывающий поток
     */
    public void end() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
