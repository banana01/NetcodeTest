package network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import network.client.Client;
import network.protocol.MessageProtocol;

public class ClientHandler extends Thread
{

	private Socket soc = null;
	
	public ClientHandler(Socket soc)
	{
		super("ClientHandler");
        this.soc = soc;
	}
	public void run()
	{
		String INline,OUTline,MESSAGE;
		StringBuilder SB = null;
		try {
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			MessageProtocol MP = new MessageProtocol();
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			System.out.println("Connected To::"+soc.getRemoteSocketAddress().toString());
			out.println(MP.genMessage("THIS IS A MESSAGE AND MY IP IS ::"+InetAddress.getLocalHost().getHostAddress()));
			while(true)
			{
				while((INline = in.readLine())!= null)
			    {
					if(MP.parseMessage(INline) == MessageProtocol.MESSAGE_START)
					{
						SB = new StringBuilder();
					}
					else if(MP.parseMessage(INline) == MessageProtocol.MESSAGE_END)
					{
						SB.delete(0, SB.length());
						break;
					}
					else if(INline.contains(MessageProtocol.DISCONNECTING))
					{
						System.out.println("Client Disconnecting"+soc.getRemoteSocketAddress().toString());
						soc.close();
						return;
					}
					else
					{
						SB.append(INline);
					}
					System.out.println(SB.toString());
					
			    }
				
			}
			
		} catch (IOException e) 
		{
			if(e.getMessage().equals("Connection reset"))
			{
				System.out.println("client reset connection");
			}
		}
		
	}
}
