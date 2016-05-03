package network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import network.client.Client;

public class Server 
{
	private static final String ver = "0.0.1";
	ServerSocket SS = null;
	
	public void createServer(int port) throws IOException
	{
		boolean listeningSocket = true;
		SS = new ServerSocket(port);
		while(listeningSocket)
		{
			Socket clientSoc = SS.accept();
			ClientHandler ch = new ClientHandler(clientSoc);
			ch.start();
		}
	 }
	
}
