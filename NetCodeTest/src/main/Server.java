package main;

import java.beans.PropertyEditorManager;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Server 
{
	private ServerConnectionAcceptor conAcp = null;
	private ServerProcessor serPro = null;
	private int port = 8453;
	
	private IMessageProcessor messageProcessor = null;
	private IMessageReaderFactory messageReaderFactory = null;
	public Server(int tcpPort, IMessageProcessor iMessageProcessor, IMessageReaderFactory iMessageReaderFactory)
	{
		this.port = tcpPort;
		this.messageProcessor = iMessageProcessor;
		this.messageReaderFactory = iMessageReaderFactory;
	}
	public void Start()
	{
		Queue socketQueue = new ArrayBlockingQueue(1024);
		
		this.conAcp = new ServerConnectionAcceptor(port, socketQueue);
		
		MessageBuffer readBuffer = new MessageBuffer();
		MessageBuffer writeBuffer = new MessageBuffer();
		
		//need the queue, buffers, proccesor and factory
		this.serPro = new ServerProcessor();
	}
}
