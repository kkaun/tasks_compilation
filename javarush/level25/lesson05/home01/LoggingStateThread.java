package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Кира on 04.11.2016.
 */
public class LoggingStateThread extends Thread {

        private Thread target;
        private State state;

        public LoggingStateThread(Thread target) {
            this.target = target;
            setDaemon(true);
        }

    /**
     * currentState = runnable
     вывели на экран runnable
     state = null (т.к. еще не чем не инициализировали) и соотв. не равно State.TERMINATED
     currentState = runnable (допустим еще не произошло изменение состояния)
     currentState != state - условие выпоняется т.к. state = null
     печатаем второй раз runnable
     */

    @Override
    public void run() {

        State currentState = target.getState();
        System.out.println(currentState);

        while (state != State.TERMINATED) {
            currentState = target.getState();
            if (currentState != state) {
                state = currentState;
                System.out.println(state);
            }
        }
    }


}
