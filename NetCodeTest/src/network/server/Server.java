package network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	ServerSocket SS;
	public void createServer(int port) throws IOException
	{
		SS = new ServerSocket(port);
		Socket clientSoc = SS.accept();
		PrintWriter out = new PrintWriter(clientSoc.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSoc.getInputStream()));
	}
}
