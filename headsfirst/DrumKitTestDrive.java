package HeadsFirst;

/**
 * Created by Кира on 23.03.2016.
 */
class DrumKit {
        boolean TopHat = true;
        boolean snare = true;

            void playTopHat() {
                System.out.println("dindin");
            }

            void playSnare() {
                System.out.println("bahabh");

            }
        }
        class DrumKitTestDrive {
            public static void main(String[] args) {
                DrumKit d = new DrumKit();

                if(d.snare == true){
                    d.playSnare();
                    d.snare = false;
                }
                d.playTopHat();
                d.TopHat = false;
                if(d.TopHat == false){
                    d.playTopHat();
                }

    }
}
