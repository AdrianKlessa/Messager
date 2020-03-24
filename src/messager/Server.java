package messager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	DataInputStream dis;
	DataOutputStream dos;
	ServerSocket serverSocket;
	Socket socket;
	public void start(int port) throws Exception{
		serverSocket = new ServerSocket(port);
		System.out.println("Server created. Waiting for connection.");
		System.out.println("Local IP (probably): " + InetAddress.getLocalHost().getHostAddress());
		socket = serverSocket.accept();
		
		dos = new DataOutputStream(socket.getOutputStream());
		
		talk();
	}
	
	public void talk() throws Exception{
		Chatter chatter = new Chatter(socket);
		chatter.talk();
	}
}
