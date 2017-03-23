package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Кира on 17.11.2016.
 */
public class Client {

    volatile boolean clientConnected = false;
    protected Connection connection;

    public static void main(String[] args) {

        Client client = new Client();
        client.run();
    }

    public void run(){

        SocketThread socketThread = getSocketThread();

        socketThread.setDaemon(true);

        socketThread.start();

        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Во время ожидания ответа возникло исключение. Программаа будет закрыта.");
                return;
            }
            if(clientConnected == true){
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");

                    while (true) {
                        String mes = ConsoleHelper.readString();
                        if (mes.equals("exit")) {
                            break;
                        }else {
                            boolean shouldR = shouldSentTextFromConsole();
                            if(shouldR == true){
                                sendTextMessage(mes);
                            }
                        }
                    }

            }else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
        }
    }

    protected String getServerAddress(){

        String serverAddress;

        ConsoleHelper.writeMessage("Введите адрес сервера:");
        serverAddress = ConsoleHelper.readString();

        return serverAddress;

    }

    protected int getServerPort(){

        int port;

        try {

            ConsoleHelper.writeMessage("Введите порт:");
            port = ConsoleHelper.readInt();

        }catch (Exception e){
            ConsoleHelper.writeMessage("Неверное значение! Введите порт еще раз:");
            port = ConsoleHelper.readInt();
        }

        return port;
    }

    protected String getUserName(){

        String userName;

        ConsoleHelper.writeMessage("Введите Ваше имя:");
        userName = ConsoleHelper.readString();

        return userName;
    }

    protected boolean shouldSentTextFromConsole(){

        return true;
    }

    protected SocketThread getSocketThread(){

        return new SocketThread();
    }

    protected void sendTextMessage(String text){

        Message newTextMes;
        try {
            newTextMes = new Message(MessageType.TEXT, text);
            connection.send(newTextMes);

        }catch (IOException e){
            ConsoleHelper.writeMessage("Во время отправки сообщения произошла ошибка!");
            clientConnected = false;
        }
    }


    public class SocketThread extends Thread {

        public void run(){

            try {
                // Создай новый объект класса java.net.Socket c запросом сервера и порта
                Socket socket = new Socket(getServerAddress(), getServerPort());

                // Создай объект класса Connection, используя сокет
                Client.this.connection = new Connection(socket);


                clientHandshake();
                clientMainLoop();


            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }


        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            while (true) {

                // В цикле получать сообщения, используя соединение connection
                Message message = connection.receive();

                switch (message.getType()) {

                    // Если это текстовое сообщение (тип TEXT), обработай его с помощью метода processIncomingMessage()
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;

                    // Если это сообщение с типом USER_ADDED, обработай его с помощью метода informAboutAddingNewUser()
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;

                    // Если это сообщение с типом USER_REMOVED, обработай его с помощью метода informAboutDeletingNewUser()
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;

                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }


        protected void clientHandshake() throws IOException, ClassNotFoundException {

            while (true) {

                // В цикле получать сообщения, используя соединение connection
                Message message = connection.receive();

                switch (message.getType()) {

                    // 	Если тип полученного сообщения NAME_REQUEST (сервер запросил имя)
                    case NAME_REQUEST: {

                        // запросить ввод имени пользователя с помощью метода getUserName()
                        // создать новое сообщение с типом USER_NAME и введенным именем, отправить сообщение серверу.
                        String userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                        break;
                    }

                    // Если тип полученного сообщения NAME_ACCEPTED (сервер принял имя)
                    case NAME_ACCEPTED: {

                        // значит сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет.
                        // Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true. После этого выйди из метода.
                        notifyConnectionStatusChanged(true);
                        return;
                    }

                    default: {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }


        protected void processIncomingMessage(String message){

            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){

            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName){

            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){

            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }



    }
}
