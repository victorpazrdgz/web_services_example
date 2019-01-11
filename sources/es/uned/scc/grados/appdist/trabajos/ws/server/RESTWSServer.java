package es.uned.scc.grados.appdist.trabajos.ws.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import es.uned.scc.grados.appdist.trabajos.ws.RESTSignalGeneratorWSImpl;

//Clase que implementa servidor REST
public class RESTWSServer {
	
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
			} else {
				System.out.println("Entered '" + c + "' string (wrong!!!)\nPress 'yes' to exit...");
			}
		}
	}
	//Metodo main del servidor
	public static void main(String[] args) throws RemoteException{
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean(); // Crea el JAX-RS Server con CXF	
		sf.setResourceClasses(RESTSignalGeneratorWSImpl.class); // Establece la clase de implementacion REST 
		sf.setAddress("http://localhost:9002/");// Crea la ruta absoluta
		sf.create(); // Arranca el JAX-RS Server
		System.out.println("Servidor REST Funcionando");
		waitForKey();
		System.exit(0);
	}
}
