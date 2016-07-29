package tcpstring;

import java.net.Socket;

public class Client
{
	public static void main(String args[]) {
		try {
			ClientThread client = new ClientThread("127.0.0.1",33333);
          /*  String serverAddress="127.0.0.1";
            int serverPort=33333;
			NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
			System.out.println("Client is connecting to.. "+ serverAddress);
			new ReadThread(nc);
			new WriteThread(nc,"Client");	*/
		} catch(Exception e) {
			System.out.println (e);
		}
	}
	static class ClientThread implements Runnable {
		private String serverAddress;
		private int serverPort;
		private Thread thr;
		private NetworkUtil nc;

		ClientThread(String serverAddress,int serverPort) {
			this.serverAddress = serverAddress;
			this.serverPort = serverPort;
			this.thr = new Thread(this);
			thr.start();
		}

		public void run() {
			this.nc=new NetworkUtil(serverAddress,serverPort);
			new ReadThread(this.nc);
			new WriteThread(this.nc,"Client","Hi");
		}
	}
}

