package tcpobject;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class WriteThread implements Runnable {
	
	private Thread thr;
	private NetworkUtil nc;
	String name;

	public WriteThread(NetworkUtil nc,String name) {
		this.nc = nc;
		this.name=name;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			//Scanner input = new Scanner(System.in);
			while(true) {
				FileInputStream fileInputStream = new FileInputStream("D:\\file.txt");
				byte buffer[] = new byte[fileInputStream.available()];
				fileInputStream.read(buffer);
				//String s=input.nextLine();
				//Data d =new Data(name+":"+s);
				nc.write(buffer);
			}
		} catch(Exception e) {
			System.out.println (e);
		}			
		nc.closeConnection();
	}
}



