package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by Кира on 17.11.2016.
 */
public class ClientGuiController extends Client {

    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

    @Override
    public void run() {
        getSocketThread().run();
        //Разберись, почему нет необходимости вызывать
        //метод run в отдельном потоке, как мы это делали для консольного клиента.
    }


    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    public ClientGuiModel getModel(){

        return model;
    }



    public class GuiSocketThread extends SocketThread {

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);

            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);

            view.refreshUsers();
        }

        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);

            view.refreshMessages();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
            super.notifyConnectionStatusChanged(clientConnected);
        }
    }
}
