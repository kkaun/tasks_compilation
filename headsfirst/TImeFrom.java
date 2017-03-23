package HeadsFirst;

import java.util.Date;

/**
 * Created by Кира on 08.04.2016.
 */
public class TImeFrom {
    public static void main(String[] args) throws Exception
    {
        Date currentTime = new Date();
        int hours = currentTime.getHours();
        int mins = currentTime.getMinutes();
        int secs = currentTime.getSeconds();

        System.out.println("Time from midnight " + hours + ":" + mins + ":" + secs);
    }
}
