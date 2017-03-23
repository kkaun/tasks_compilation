package HeadsFirst;

/**
 * Created by Кира on 16.05.2016.
 */
class Output1 {

    public static void main(String[] args) {

        Output1 o = new Output1();

        o.go();
    }

    void go() {
        int y = 7;
        for (int x = 1; x < 8; x++) {

            y++;
            if (x > 4) {
                System.out.println(++y + " ");
            }

            if (y > 14) {
                System.out.println(" x = " + x);

                break;
            }

        }
    }
}
