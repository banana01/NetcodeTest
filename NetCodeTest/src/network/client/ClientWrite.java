package network.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWrite extends Thread
{
	Socket soc;
	boolean connected = true;
	public ClientWrite(Socket Soc)
	{
		super("ClientReader");
		this.soc = Soc;
	}
	public void run()
	{
		Scanner keyb = new Scanner(System.in);
		try {
			PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
			while(connected)
			{
				out.println(keyb.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
