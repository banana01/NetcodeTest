package network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
		String line;
		StringBuilder sb = null;
		try {
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			out.println("THIS IS A SERVER");
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
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
