import java.io.*;
import java.rmi.*;

public class Client {

    static final String endMessage = ".";
    public static void main(String args[]) 
    {
        try 
        {
            int RMIPort;         
            String hostName;
            String wantToVote = "I Want to Vote";
            String yesAmount = "How Many Yes?";
            String noAmount = "How Many No?";
            String dontCareAmount = "How Many Don't Care?";

            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);

            System.out.println("Enter the RMIRegistry host namer:");
            hostName = br.readLine();
            System.out.println("Enter the RMIregistry port number:");
            String portNum = br.readLine();
            RMIPort = Integer.parseInt(portNum);
            String registryURL = "rmi://" + hostName+ ":" + portNum + "/hello";
            Interface h = (Interface)Naming.lookup(registryURL);
            System.out.println("Lookup completed");
            while(true)
            {
                String welcomeMessage = h.welcome();
                System.out.println(welcomeMessage);
                String welcomeResponse = br.readLine();
                if((welcomeResponse.trim()).equals(endMessage))
                {
                    break;
                }
                else if((welcomeResponse.trim()).equals(wantToVote)) 
                {
                    System.out.println("Please Choose one of the Following" + "\n");
                    System.out.println("Press 1 for Yes" + "\n");
                    System.out.println("Press 2 for No" + "\n");
                    System.out.println("Press 3 for Don't Care" + "\n");
                    System.out.println("Your Chose is: ");
                    String chose = br.readLine();
                    h.vote(chose);
                }
                else if((welcomeResponse.trim()).equals(yesAmount) || (welcomeResponse.trim()).equals(noAmount) || (welcomeResponse.trim()).equals(dontCareAmount))
                {
                    int status = h.checkStatus(welcomeResponse);
                    System.out.println(status);
                }
            }
        }
        catch (Exception e) 
        {
            System.out.println("Exception in HelloClient: " + e);
        }
    }
}
