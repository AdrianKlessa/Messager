package messager;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Chatter {
	Socket socket;
	
	public Chatter(Socket socket) {
		this.socket=socket;
	}
	
	
	public void talk() throws Exception{
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		Scanner scanner = new Scanner(System.in);
		String inputString="";
		ThreadIn listener = new ThreadIn(socket);
		listener.start();
		boolean quit = false;
		System.out.println("You are now connected. Write 'quit' to exit the application.");
		while(!quit) {
			if(scanner.hasNextLine()) {
				inputString=scanner.nextLine();
				if(inputString.equals("quit")) {
					quit=true;
					dos.writeUTF(inputString);
					dos.flush();
				}else {
					if(!socket.isClosed()) {
						dos.writeUTF(inputString);
						dos.flush();
						System.out.println("You: "+inputString);
					}
				}
			}
		}
		socket.close();
		scanner.close();
	}
}
