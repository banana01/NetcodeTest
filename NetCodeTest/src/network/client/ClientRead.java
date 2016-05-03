package network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientRead extends Thread
{
	Socket soc;
	boolean connected = true;
	public ClientRead(Socket Soc)
	{
		super("ClientReader");
		this.soc = Soc;
	}
	public void run()
	{
		try 
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			while(connected)
			{
				System.out.println(in.readLine());
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
