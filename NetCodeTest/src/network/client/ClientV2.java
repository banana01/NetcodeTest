package network.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class ClientV2 
{
	Socket soc;
	public ClientV2(String host, int port)
	{
		try 
		{
			connect(host, port);
			initThreads();
			
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	public void connect(String host, int port) throws UnknownHostException, IOException
	{
		soc = new Socket(host, port);
	}
	public void initThreads()
	{
		ClientRead CR = new ClientRead(soc);
		ClientWrite CW = new ClientWrite(soc);
		CR.start();
		CW.start();
	}

}
