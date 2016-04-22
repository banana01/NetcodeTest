package network.protocol;

import javax.print.attribute.standard.RequestingUserName;

public class MessageProtocol 
{
	public static final String START = "_S_T", END = "_E_N", DISCONNECTING = "45671_FF";
	public static final int MESSAGE_START=2, MESSAGE_END=3, INVALID_INPUT=1;
	public int parseMessage(String in)
	{
		switch(in)
		{
			case"_S_T":
				return MESSAGE_START;
			case"_E_N":
				return MESSAGE_END;
		}
		return INVALID_INPUT;
	}
	public String genMessage(String in) 
	{
		StringBuilder SB = new StringBuilder(in);
		SB.append("\n"+END);
		SB.insert(0, START+"\n");
		return SB.toString();
	}
	
}
