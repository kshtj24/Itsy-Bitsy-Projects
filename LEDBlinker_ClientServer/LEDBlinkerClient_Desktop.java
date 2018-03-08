import java.net.*;
import java.io.*;
//import javax.swing.*;
//import javax.awt.*;
//import javax.awt.event.*;

public class LEDBlinkerClient_Desktop{
	public static void main(String[] args){
		try{
			Socket socket = new Socket("192.168.1.6", 5000);
		
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));	
			
			while(true){
				String data = consoleReader.readLine();
				if(data.equals("stop"))
					break;
				else
					writer.println(data);
			}
			System.out.println("Client exiting");
			writer.close();
			
		}catch(Exception ex){ex.printStackTrace();}
	}
}