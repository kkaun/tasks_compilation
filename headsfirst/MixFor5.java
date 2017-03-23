package HeadsFirst;

/**
 * Created by Кира on 16.05.2016.
 */
public class MixFor5 {

    public static void main(String [] args){

        int x = 0;
        int y = 30;

        for(int outer = 0; outer < 3; outer++){
            for(int inner = 4; inner > 1; inner--){
                x = x + 2;
                y = y - 2;
                if(x == 6){
                    break;
                }
            }
            y = y - 2;
        }
        System.out.println(x + " " + y);
    }
}
