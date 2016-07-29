package tcpstring;

import java.util.*;

public class WriteThread implements Runnable {
	
	private Thread thr;
	private NetworkUtil nc;
	String name;
	String byDefault;

	public WriteThread(NetworkUtil nc,String name,String byDefault) {
		this.byDefault = byDefault;
		this.nc = nc;
		this.name=name;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			Scanner input=new Scanner(System.in);
			while(true) {
				String s=input.nextLine();
				nc.write(name+":"+ byDefault + s);
			}
		} catch(Exception e) {
			System.out.println (e);
		}			
		nc.closeConnection();
	}
}



