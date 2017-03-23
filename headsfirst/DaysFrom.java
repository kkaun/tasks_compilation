package HeadsFirst;

import java.util.Date;

/**
 * Created by Кира on 08.04.2016.
 */
public class DaysFrom {
    public static void main(String[] args) throws Exception
    {

        Date currentTime = new Date();
        long msTimeDistance = currentTime.getTime();

        System.out.println("Days from start of year: " + currentTime);
    }
}
