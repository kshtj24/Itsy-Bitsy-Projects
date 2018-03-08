import java.io.*;
import java.net.*;
import com.pi4j.io.gpio.*;

public class LEDBlinkerServer_RPi{

	Socket serverSocket;

	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		public ClientHandler(Socket clientSocket){
			try{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		public void run(){
			try{
				String action = reader.readLine();
				System.out.println(action);
				if(action == "On")
					turnLEDOn();
				else
					turnLEDOff();
			}catch(Exception ex){}
		}
	}

	public static void main(String[] args){
		new LEDBlinkerServer_RPi().go();
	}

	public void go(){
		try{
			ServerSocket serverSock = new ServerSocket(5000);

			while(true){
				Socket clientSocket = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connection");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void turnLEDOn(){
		System.out.println("LED turned On");
	}
	
	public void turnLEDOff(){
		System.out.println("LED turned Off");
	}
}
