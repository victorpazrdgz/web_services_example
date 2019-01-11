package es.uned.scc.grados.appdist.trabajos.ws.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;


import javax.xml.ws.Endpoint;

import es.uned.scc.grados.appdist.trabajos.ws.SignalGeneratorWSImpl;
// Clase que implementa servidor SOAP
public class WSServer {
	private static Endpoint endpoint=null; 
	public static void waitForKey() { //Metodo que  mantiene el servidor funcionando hasta que el usuario pulsa "yes" para salir
		boolean waiting = true;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 'yes' to exit...aqui");
		String c;
		while (waiting) {
			try {
				c = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				c = "yes";
			}
			if (c.equalsIgnoreCase("yes")) {
				waiting = false;
				endpoint.stop(); //Detiene el servidor
			} else {
				System.out.println("Entered '" + c + "' string (wrong!!!)\nPress 'yes' to exit...");
			}
		}
	}
	public static void main(String[] args) throws RemoteException{
	double sampleTime=0.01;
	
	SignalGeneratorWSImpl implementor = new SignalGeneratorWSImpl(sampleTime);
	
	String address = "http://localhost:9000/SignalGenerator";
	
	endpoint=Endpoint.publish(address, implementor); //Publica el servicio
	
	System.out.println("Servidor SOAP Funcionando");
	waitForKey();
	System.exit(0);
	}
}
