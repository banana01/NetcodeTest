package network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	private static final String ver = "0.0.1";
	ServerSocket SS;
	public void createServer(int port) throws IOException
	{
		String line;
		StringBuilder sb = null;
		String clientVer = "";
		SS = new ServerSocket(port);
		System.out.println("Waiting for connection!");
		Socket clientSoc = SS.accept();
		PrintWriter out = new PrintWriter(clientSoc.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSoc.getInputStream()));
		System.out.println("Connected");
		out.println("_S_");
		out.println("This server is running version"+ver+"of test");
		out.println("_E_");
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
