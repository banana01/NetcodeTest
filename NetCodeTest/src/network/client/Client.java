package network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.omg.CORBA.VersionSpecHelper;

public class Client 
{
	private static final String ver = "0.0.1";
	public void connect(int portNumber, String hostName) throws UnknownHostException, IOException
	{
			String line;
			StringBuilder sb = null;
			Scanner stdIn = new Scanner(System.in);
		    Socket kkSocket = new Socket(hostName, portNumber);
		    PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		    System.out.println("connected");
		    while((line = in.readLine())!= null)
		    {
		    	if(line.equals("_S_"))
		    	{
		    		sb = new StringBuilder();
		    	}
		    	else if(line.equals("_E_"))
		    	{
		    		System.out.println(sb.toString());
		    		sb.delete(0, sb.length());
		    	}
		    	else 
		    	{
		    		sb.append(line);
				}
		    }
		    
		    
		    
		    
		    
		    
	}
	

	
}
