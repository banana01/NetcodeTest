package network.server;

import java.net.Socket;

public class ServerThread extends Thread
{
private Socket soc = null;
	
	public ServerThread(Socket soc)
	{
		
		super("ClientHandler");
        this.soc = soc;
	}
	public void run()
	{
	
	}
}
