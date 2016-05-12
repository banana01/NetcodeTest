package main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;

import network.client.Client;
import network.client.ClientV2;
import network.server.Server;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		getIps();
	    Scanner key = new Scanner(System.in);
	    if(key.nextLine().contains("server"))
	    {
	    	Server s = new Server();
	    	s.acceptConnection(4444);
	    }
	    else
	    {
	    	
	    	System.out.println("Input the IP of the server::");
	    	ClientV2 c = new ClientV2(key.nextLine() ,4444);
	    }
	}
	public static void getIps() throws UnknownHostException, SocketException
	{
		System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostAddress());  // often returns "127.0.0.1"
	    Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
	    for (; n.hasMoreElements();)
	    {
	        NetworkInterface e = n.nextElement();

	        Enumeration<InetAddress> a = e.getInetAddresses();
	        for (; a.hasMoreElements();)
	        {
	            InetAddress addr = a.nextElement();
	            System.out.println("  " + addr.getHostAddress());
	        }
	    }
	}
}
