
import java.util.Currency;
import java.util.Scanner;

/**
 * Created by Kir on 10.04.2017.
 */
public class DayOfWeek {

    Currency c  = Currency.getInstance("EUR");

        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        //LocalDate date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        //DayOfWeek dayOfWeek = date.getDayOfWeek();

        //System.out.println(dayOfWeek);
        }
}
