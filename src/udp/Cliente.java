package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		
		
		final int PUERTO_SERVIDOR = 5000;
		byte[] buffer = new byte[1024];
		
			try {
				InetAddress direccionServidor  = InetAddress.getByName("192.168.2.1");
				
				DatagramSocket SocketUDP = new DatagramSocket();
				
				String mensaje = "Hola mundo desde el cliente";
				
				buffer = mensaje.getBytes();
				
				DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor,PUERTO_SERVIDOR);

					SocketUDP.send(pregunta);
					DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
					
					SocketUDP.receive(peticion);
					
					System.out.println("Recibo peticion");
					mensaje = new String (peticion.getData());
					System.out.println(mensaje);
					
					
					SocketUDP.close();
				
				
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
				
				
		

	}

}
