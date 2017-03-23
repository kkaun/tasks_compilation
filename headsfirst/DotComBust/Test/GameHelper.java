package HeadsFirst.DotComBust.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Кира on 17.05.2016.
 */
public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridlength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length() == 0){
                return null;
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells = new ArrayList<>();
        String[] alphacoords = new String[comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = 1;
        if(comCount % 2 == 1){
            incr = gridlength;
        }

    while(!success && attempts++ < 200){
        location = (int)(Math.random()*gridSize);
        //System.out.println("Пробуем" + location);
        int x = 0;
        success = true;
        while(success && x < comSize){
            if(grid[location] == 0) {
                coords[x++] = location;
                location += incr;
                if (location >= gridSize) {
                    success = false;
                }
                if (x > 0 && (location % gridlength == 0)) {
                    success = false;
                } else {
                    //System.out.println("Используется" + location);
                    success = false;
                }
            }
        }
    }
        int x = 0;
        int row = 0;
        int column = 0;
        //System.out.println("\n");

        while(x < comSize){
            grid[coords[x]] = 1;
            row = (int)(coords[x] / gridlength);
            column = coords[x] % gridlength;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.println(" coord" + x + " = " + alphaCells.get(x-1));
        }

        //System.out.println("\n");

        return alphaCells;

    }
}