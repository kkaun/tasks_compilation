package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Кира on 06.12.2016.
 */
public class LevelLoader {


    private Path levels = Paths.get("E:\\JavaRush\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt");

    public LevelLoader(Path levels) {
        this.levels = levels;
    }


    public GameObjects getLevel(int level) {

        int levelN = level % 60;

        if (levelN == 60) {
            levelN = 0;
        }

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();

        Player player = null;

        int cellSize = Model.FIELD_SELL_SIZE;

        int x0 = cellSize / 2;
        int y0 = cellSize / 2;

        try(BufferedReader fileReader = new BufferedReader(new FileReader(levels.toFile()))){

        while (!fileReader.readLine().contains("Maze: " + levelN)) ;

        fileReader.readLine();
        fileReader.readLine();

        double y = Double.parseDouble(fileReader.readLine().split(" ")[2]);
        fileReader.readLine();
        fileReader.readLine();
        fileReader.readLine();

        for (int i = 0; i < y; i++) {

            String read = fileReader.readLine();

            for (int j = 0; j < read.length(); j++) {

                switch (read.charAt(j)) {
                    case 'X':
                        walls.add(new Wall(x0 + j * cellSize, y0 + i * cellSize));
                        break;
                    case '&':
                        boxes.add(new Box(x0 + j * cellSize, y0 + i * cellSize));
                        homes.add(new Home(x0 + j * cellSize, y0 + i * cellSize));
                        break;
                    case '@':
                        player = new Player(x0 + j * cellSize, y0 + i * cellSize);
                        break;
                    case '*':
                        boxes.add(new Box(x0 + j * cellSize, y0 + i * cellSize));
                        break;
                    case '.':
                        homes.add(new Home(x0 + j * cellSize, y0 + i * cellSize));
                        break;
                }
            }
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GameObjects(walls, boxes, homes, player);
    }

}
