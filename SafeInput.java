import java.util.Scanner;

public class SafeInput
{
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" +prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    // -------------------------------------------------------------------------------------

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return value
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        boolean done = false;
        int value = 0;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer: " + trash);
            }
        } while (!done);

        return value;
    }

    // -------------------------------------------------------------------------------------

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return value
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        boolean done = false;
        double value = 0;
        String trash = "";

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer: " + trash);
            }
        } while (!done);

        return value;
    }

    // -------------------------------------------------------------------------------------

    /**
     * @param pipe - a Scanner opened to read from System.in
     * @param prompt - prompt for the user
     * @param low - lowest end of inclusive range
     * @param high - highest end of inclusiv range
     * @return value
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int value = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine();
                if(value >= low && value <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nThe entered input is not in range [" + low + " - " + high + "]: " + value);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer: " + trash);
            }
        } while (!done);

        return value;
    }

    // -------------------------------------------------------------------------------------

    /**
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low lowest end of inclusive range
     * @param high highest end of inclusiv range
     * @return value
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double value = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.println("\n" + prompt + "[" + low + " - " + high + "]: ");
            if(pipe.hasNextDouble())
            {
                value = pipe.nextDouble();
                pipe.nextLine();
                if(value >= low && value <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nThe entered input is not in range [" + low + " - " + high + "]" + value);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer: " + trash);
            }
        } while (!done);

        return value;
    }

    // -------------------------------------------------------------------------------------

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return true for yes, false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean value = true;
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.println("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                value = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                value = false;
            }
            else
            {
                System.out.println("You have entered an invalid answer: " + response + ". Please enter a valid answer [Y/N].");
            }

        } while(!gotAVal);

        return value;
    }

    // -------------------------------------------------------------------------------------

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx pattern for the input
     * @return true for yes, false for no
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.println("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx))
            {
                gotAVal = true;
            }
            else
            {
                System.out.println("\nYour response: " + response + ", doesn't match the required pattern: " + regEx + "Please try again and enter a valid input");
            }
        } while (!gotAVal);

        return response;
    }

//    -------------------------------------------------------------------------------------

    /**
     *
     * @return true for yes, false for no
     */
    public static double getAverage(int[] values)
    {
        double sum = 0;
        double average;

        for (int r = 0; r < values.length; r++){
            sum = sum + values[r];
        }
        average = sum / values.length;
        System.out.println ("The average of the values is:" + sum);

        return average;
    }

//    -------------------------------------------------------------------------------------

    /**
     *
     *
     * @return true for yes, false for no
     */
}
