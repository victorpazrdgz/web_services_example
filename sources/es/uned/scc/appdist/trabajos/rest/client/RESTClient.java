package es.uned.scc.appdist.trabajos.rest.client;

import org.apache.cxf.jaxrs.client.WebClient;

//Clase que implementa el main del cliente REST
public class RESTClient {
	public static void main(String [] args) {
		String REST_SERVICE = "http://localhost:9002/SignalGenerator/"; //Punto ubicacion del servicio
		WebClient client = WebClient.create(REST_SERVICE);  // Creamos objeto de la clase webclient
		PlottingFrame  window= new PlottingFrame(client);
		window.show();
	}
}
