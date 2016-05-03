package network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.activation.DataContentHandler;

import org.omg.CORBA.VersionSpecHelper;

import network.protocol.MessageProtocol;

public class Client 
{
	private static final String ver = "0.0.1";
	public void connect(int portNumber, String hostName) throws UnknownHostException, IOException
	{
			/*String INline,OUTline,MESSAGE;
			Boolean DC = false;
			StringBuilder SB = null;
			Scanner stdIn = new Scanner(System.in);
		    Socket kkSocket = new Socket(hostName, portNumber);
		    MessageProtocol MP = new MessageProtocol();
		    PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
		    BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		    System.out.println("Connected");
		    while(true)
		    {
		    	while((INline = in.readLine())!= null)
			    {
					if(MP.parseMessage(INline) == MessageProtocol.MESSAGE_START)
					{
						if(SB!=null)
						{
							SB.delete(0, SB.length());
						}
						
						SB = new StringBuilder();
					}
					else if(MP.parseMessage(INline) == MessageProtocol.MESSAGE_END)
					{
						break;
					}
					else
					{
						SB.append(INline);
					}
					System.out.println(SB.toString());
					
			    }
		    	if(DC)
		    	{
		    		break;
		    	}
		    	OUTline = stdIn.nextLine();
		    	if(OUTline.equals("DC_ME_PLZ"))
		    	{
		    		DC = true;
		    	}
		    	out.println(MP.genMessage(stdIn.nextLine()));
		    	
		    }
		    out.println(MP.genMessage(MessageProtocol.DISCONNECTING));
		    kkSocket.close();
		    stdIn.close();
		    */
		    
		    
		    
		    
		    
	}
	

	
}
