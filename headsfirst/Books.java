package HeadsFirst;

/**
 * Created by Кира on 23.03.2016.
 */
public class Books {
    String title;
    String author;
}

class BooTestDrive{
    public static void main(String[] args){
        Books [] myBooks = new Books[3];
        int x = 0;

        myBooks[0] = new Books();
        myBooks[1] = new Books();
        myBooks[2] = new Books();

        myBooks[0].title = "plodi";
        myBooks[1].title = "gtsby";
        myBooks[2].title = "recepti";

        myBooks[0].author = "bob";
        myBooks[1].author = "sue";
        myBooks[2].author = "jan";

        while(x < 3){
            System.out.print(myBooks[x].title);
            System.out.print(", автор ");
            System.out.println(myBooks[x].author);
            x = x + 1;
            }
        }

    }
