import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

public class Implementation extends UnicastRemoteObject implements Interface 
{
    Scanner in = new Scanner(System.in);
    static int yesCount;
    static int noCount;
    static int dontCareCount;

    static final String welcomeLine1 = "\n" + "*****************************************************" + "\n";
    static final String welcomeLine2 = "I Want To Vote" + "\n" ;
    static final String welcomeLine3 = "How Many Yes?" + "\n";
    static final String welcomeLine4 = "How Many No?" + "\n";
    static final String welcomeLine5 = "How Many Don't Care?" + "\n";
    static final String welcomeLine6 = "Use '.' to Quit" + "\n";
    static final String welcomeLine7 = "*****************************************************" + "\n";
    static final String welcomeLine8 = "Please Enter between the Following Choices Above: ";
    static final String welcomeLines = welcomeLine1 + welcomeLine2 + welcomeLine3 + welcomeLine4 + welcomeLine5 + welcomeLine6 + welcomeLine7 + welcomeLine8;

    static final String chose1 = "1";
    static final String chose2 = "2";
    static final String chose3 = "3";

    static final String checkYes = "How Many Yes?";
    static final String checkNo = "How Many No?";
    static final String checkDontCare = "How Many Don't Care?";

    public Implementation() throws RemoteException 
    {
        super();
    }

    public String welcome() 
    {
        return welcomeLines; 
    }

    public void vote(String choice) 
    {
        if((choice.trim()).equals(chose1))
        {
            yesCount++;
        }
        else if((choice.trim()).equals(chose2))
        {
            noCount++;
        }
        else if((choice.trim()).equals(chose3))
        {
            dontCareCount++;
        }
    }

    public int checkStatus(String check) 
    {
        if((check.trim()).equals(checkYes))
        {
            return yesCount;
        }
        else if((check.trim()).equals(checkNo))
        {
            return noCount;
        }
        else
        {
            return dontCareCount;
        }
    }

}