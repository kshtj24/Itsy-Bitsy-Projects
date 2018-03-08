import java.io.*;
import java.net.*;
import com.pi4j.io.gpio.*;

public class LEDBlinkerServer_RPi{
	
	
	public static void main(String[] args){
		try{
			ServerSocket socket = new ServerSocket(5000);
			
			 // create gpio controller
			final GpioController gpio = GpioFactory.getInstance();
			// provision gpio pin #01 as an output pin and turn on
			final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
			// set shutdown state for this pin
			pin.setShutdownOptions(true, PinState.LOW);
			
			while(true){
				Socket sock = socket.accept();
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				String data = reader.readLine();
				if(data.equals("On"))
					pin.toggle();
				else if(data.equals("Off"))
					pin.low();
				else
				{
					System.out.println("Incorrect data received");
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}
}
