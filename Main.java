import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static ArrayList<String> myArrList  = new ArrayList<String>();
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        final String menu  = "A - Add D - Delete V - View Q - Quit O - Open S - Save C - Clear";
        boolean done = false;
        String cmd = "";
        int delete = 0;

        do {
            displayList ();

            cmd = SafeInput.getRegExString (in, menu, "[AaDdVvQqOoSsCc]");
            cmd = cmd.toUpperCase ();

            switch (cmd) {
                case "A":
                    String add = SafeInput.getNonZeroLenString (in, "What would you like to add to your list?");
                    myArrList.add (add);
                    done = false;
                    break;
                case "D":
                    delete = SafeInput.getRangedInt (in, "What would you like to delete? Please enter the number of the item.", 1, myArrList.size());
                    System.out.println (myArrList.size());
                    delete = delete - 1;
                    String var = myArrList.get(delete);
                    myArrList.set(delete, "");
                    done = false;
                    break;
                case "V":
                    done = false;
                    break;
                case "Q":
                    boolean response = SafeInput.getYNConfirm (in, "Are you sure you want to quit?");
                    if (response){
                        System.exit (0);
                        done = true;
                    }
                    else
                    {
                        done = false;
                    }
                    break;
                case "O":
                    
                    break;
                case "S":
                    needsToBeSaved();
                    break;
                case "C":

            }
        }while(!done);
    }

    private static void displayList()
    {
        System.out.println ("------------------------------------------------------");
        if (myArrList .size() != 0) {
            for (int i = 0; i < myArrList .size (); i++) {
                System.out.printf ("%3d%8s", i + 1, myArrList.get(i));
            }
        }
        else
        {
            System.out.println ("The List is empty");
        }
        System.out.println ();
        System.out.println ("------------------------------------------------------");

    }
    private static void needsToBeSaved()
    {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : myArrList)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}