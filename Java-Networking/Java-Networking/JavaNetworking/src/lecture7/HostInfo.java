package lecture7;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInfo
{
  	public static void main(String args[] )  {
  		try {
      		InetAddress ipAddress = InetAddress.getLocalHost();
			String s=ipAddress.toString();
      		System.out.println(s);
    	}
    	catch ( UnknownHostException ex ) {
      		System.out.println(ex);
    	}
  	}
} 