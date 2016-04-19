package network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client 
{
	public void connect(int portNumber, String hostName) throws UnknownHostException, IOException
	{
			String fromServer, fromUser;
			Scanner stdIn = new Scanner(System.in);
		    Socket kkSocket = new Socket(hostName, portNumber);
		    PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		   System.out.println("connected");
		    while ((fromServer = in.readLine()) != null) {
		        System.out.println("Server: " + fromServer);
		        if (fromServer.equals("Bye."))
		            break;
		        
		        fromUser = stdIn.nextLine();
		        if (fromUser != null) {
		            System.out.println("Client: " + fromUser);
		            out.println(fromUser);
		        }
		    }
		
	}
}
