package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Кира on 16.11.2016.
 */
public class Server {

    private static final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    public static void main(String[] args) throws IOException {

        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int serverPort = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {

            ConsoleHelper.writeMessage("Сервер запущен! Вы можете начать обмен сообщениями");

            while (true) {
                //Слушаем
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                //запускаем handler
                handler.start();
            }
        }
    }


    public static void sendBroadcastMessage(Message message) {

        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try{
                entry.getValue().send(message);

            }catch(IOException e){
                ConsoleHelper.writeMessage("Произошла ошибка! В данный момент сообщение не может ыть отправлено.");
            }
        }
    }

    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }


        public void run() {

            String errorMessage = null;
            String userName = null;

            SocketAddress socketAddress = null;

            try (Connection connection = new Connection(socket)) {
                socketAddress = connection.getRemoteSocketAddress();

                errorMessage = "Произошла ошибка обмена данных с удаленным адресом: " + socketAddress;

                ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом: " + socketAddress);

                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);

            } catch (IOException e) {
                ConsoleHelper.writeMessage(errorMessage);
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage(errorMessage);
            } finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
            ConsoleHelper.writeMessage("Закрыто соединение с удаленным адресом: " + socketAddress);


        }


        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            while (true) {

                try {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                    Message message = connection.receive();
                    if (message.getType() == MessageType.USER_NAME) {
                        String userName = message.getData();
                        if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName)) {
                            connectionMap.put(userName, connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return userName;
                        }
                    }
                } catch (Exception e) {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {

            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {

                if (!userName.equals(entry.getKey())) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }

            }

        }


        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {

                Message message = connection.receive();
                // Если принятое сообщение – это текст (тип TEXT)
                if (message.getType() == MessageType.TEXT) {

                    String s = userName + ": " + message.getData();

                    Message formattedMessage = new Message(MessageType.TEXT, s);
                    sendBroadcastMessage(formattedMessage);

                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }


    }
}
