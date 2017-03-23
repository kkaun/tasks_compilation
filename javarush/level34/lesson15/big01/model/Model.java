package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

/**
 * Created by Кира on 05.12.2016.
 */
public class Model {

    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("E:\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));


    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){

        return gameObjects;
    }

    public void restartLevel(int level){

        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart(){

        restartLevel(currentLevel);
    }

    public void startNextLevel(){

        currentLevel = currentLevel + 1;
        restartLevel(currentLevel);
    }


    public void move(Direction direction) {

        Player player = gameObjects.getPlayer();

        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollision(direction)){
            return;
        }

        int sellSize = FIELD_SELL_SIZE;
        switch (direction) {
            case LEFT:
                player.move(-sellSize, 0);
                break;
            case RIGHT:
                player.move(sellSize, 0);
                break;
            case UP:
                player.move(0, -sellSize);
                break;
            case DOWN:
                player.move(0, sellSize);
        }

        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){

        for (Wall wall : gameObjects.getWalls()){
            if(gameObject.isCollision(wall, direction)){
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction){

        Player player = gameObjects.getPlayer();

        // найдем во что уперся игрок
        GameObject  stopped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)){
                stopped = gameObject;
            }
        }

        //свободное место или дом
        if ((stopped == null)){
            return false;
        }

        if (stopped instanceof Box){
            Box stoppedBox = (Box)stopped;

            if (checkWallCollision(stoppedBox, direction)){
                return true;
            }

            for (Box box : gameObjects.getBoxes()){
                if(stoppedBox.isCollision(box, direction)){
                    return true;
                }
            }

            switch (direction)
            {
                case LEFT:
                    stoppedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stoppedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stoppedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stoppedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;

    }

    public void checkCompletion(){

        boolean yes = true;
        for(Home home : gameObjects.getHomes()){
            boolean currentyes = false;
            for (Box box: gameObjects.getBoxes()){
                if ((box.getX() == home.getX()) && (box.getY() == home.getY()))
                    currentyes = true;
            }
            if (!currentyes)
                yes = false;
        }
        if (yes)
            eventListener.levelCompleted(currentLevel);
    }




}
