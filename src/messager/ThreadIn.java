package messager;

import java.io.DataInputStream;
import java.net.Socket;

public class ThreadIn extends Thread{
	Socket socket;
	String incomingString;
	public ThreadIn(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		DataInputStream din;
		try {
			din = new DataInputStream(socket.getInputStream());
			String otherIP=socket.getInetAddress().getHostAddress();
			incomingString="";
			while(!incomingString.contentEquals("quit")&&!socket.isClosed()) {		
				if(din.available()>0) {
					incomingString = din.readUTF();
					System.out.println(otherIP+": "+incomingString);
				}

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		
		System.out.println("Connection closed.");
		try{
			socket.close();
		}catch(Exception e) {
			
		}
	}
}
