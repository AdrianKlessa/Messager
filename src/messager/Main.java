package messager;


import java.util.Scanner;

public class Main {
	static final int port = 9025;
	
	public static void main(String[] args) throws Exception{
		greet();
		
		
		
		
	}
	
	static void greet() throws Exception {
		int mode=-1;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the messanger! Choose one of the following options:");
		
		System.out.println("1 - Start server");
		System.out.println("2 - Connect to a server");
		System.out.println("3 - Exit");
		
		while(mode==-1) {
			mode=scanner.nextInt();
		}
		
		switch(mode) {
		case 1:
			serverStart();
			break;
		case 2:
			connect();
			break;
		}
		
		scanner.close();
	}
	
	static void serverStart() throws Exception{
		Server server = new Server();
		server.start(port);
	}
	
	static void connect() throws Exception{
		Client client = new Client();
		client.start(port);
		

	}
}
