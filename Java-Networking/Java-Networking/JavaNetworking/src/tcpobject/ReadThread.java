package tcpobject;

import javafx.scene.image.Image;

import java.io.File;

public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public ReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			while(true) {
				Object o=nc.read();
				if(o!= null) {
					if(o instanceof byte[]) {
						byte[] read = (byte[])  o;

						//System.out.println(obj.getElement());
					}
				}	
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



