package es.uned.scc.grados.appdist.trabajos.ws.soap;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import es.uned.scc.grados.appdist.trabajos.ws.SignalGeneratorLocator;
import es.uned.scc.grados.appdist.trabajos.ws.SignalGeneratorWS;

// Clase que implementa el main del cliente SOAP
public class WSClient {
  
	public static void main(String [] args) throws ServiceException, RemoteException{
		SignalGeneratorLocator service = new SignalGeneratorLocator();
		SignalGeneratorWS port= service.getSignalGeneratorWSImplPort();	// Obtiene la referencia del servicio
		if (port!=null){
		PlottingFrame  window= new PlottingFrame(port);
		window.show();
		}
	}

}
