package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{

	private static final String ver = "0.0.1";
	ServerSocket SS = null;
	public void acceptConnection(int port) throws IOException
	{
		boolean listeningSocket = true;
		SS = new ServerSocket(port);
		while(listeningSocket)
		{
			Socket clientSoc = SS.accept();
			ServerThread ch = new ServerThread(clientSoc);
			ch.start();
		}
	}
}
