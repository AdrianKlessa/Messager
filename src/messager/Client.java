package messager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	DataInputStream dis;
	DataOutputStream dos;
	Socket socket;
	Scanner scanner;
	public void start(int port) throws Exception{
		String address;
		scanner = new Scanner(System.in);
		System.out.println("Please provide the server IP");
		address = scanner.nextLine();
		
		socket = new Socket(address,port);
		
		
		dis =new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		
		talk();
	}
	
	public void talk() throws Exception {
		Chatter chatter = new Chatter(socket);
		chatter.talk();
	}
}
