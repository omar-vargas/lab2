package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
	
	public static void main(String  [] args){
		
		final int Puerto = 5000;
		byte[] buffer = new byte[1024];
		
		
		try {
			System.out.println("Iniciando Servidor UDP");
			DatagramSocket SocketUDP = new DatagramSocket(Puerto);
			
			
			
			while(true){
			DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
			
			SocketUDP.receive(peticion);
			System.out.println("recibiendo peticion del cliente");
			String mensaje = new String(peticion.getData());
			
			System.out.println(mensaje );
			
			int puertoCliente = peticion.getPort();
			InetAddress direccion = peticion.getAddress();
			
			mensaje = "Hola al mundo desde servidor";
			buffer = mensaje.getBytes();
			
			DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length,direccion,puertoCliente);
			System.out.println("Envio informacion Cliente");
			SocketUDP.send(respuesta);
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
