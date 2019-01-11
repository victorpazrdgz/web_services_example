package es.uned.scc.appdist.trabajos.rest.client;


import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import es.uned.scc.grados.appdist.trabajos.plot.ClientGUI;
import es.uned.scc.grados.appdist.trabajos.plot.ClientPlot;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.OperationInfo;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalData;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalParameters;

//Clase que implementa la interfaz client plot REST
public class PlottingFrame implements ClientPlot {
	
	WebClient restClient = null;
	ClientGUI frame = null;
	
	public PlottingFrame(WebClient restClient) {
		this.restClient = restClient;
		frame = new ClientGUI(this);
	}

	@Override
	public boolean start(){  // Metodo para arrancar el generdor
		// Set relative path to REST method
		restClient.replacePath("start");
		// Set type of data received
		restClient.type("application/xml");
		// Call the REST method
		Response r = restClient.get();
		// Get the XML entity in response and cast to class
		OperationInfo i = r.readEntity(OperationInfo.class);
		System.out.println("Response: " + i.getMessage());
		return i.isOk();
		}

	public boolean stop(){  //Metodo para parar el generdor
		
		restClient.replacePath("stop");// Set relative path to REST method	
		restClient.type("application/xml"); // Set type of data received
		Response r = restClient.get();// Call the REST method
        OperationInfo i = r.readEntity(OperationInfo.class);// Get the XML entity in response and cast to class
		System.out.println("Response: " + i.getMessage());
		return i.isOk();
	}

	public SignalData getSignalValue() { // Metodo para obtener valores de señal del generador
		SignalData sd=null;
	// Set relative path to REST method
	restClient.replacePath("get");
	// Set type of data received
	restClient.type("application/xml");
	// Call the REST method
	Response r = restClient.get();
	// Get the XML entity in response and cast to class
	  sd = r.readEntity(SignalData.class);
	return sd;
	}
		
	public SignalParameters getSignalParameters() {// Metodo para obtener parametros de señal del generador
		SignalParameters sp = null;
		// Set relative path to REST method
		restClient.replacePath("getParams");
		// Set type of data received
		restClient.type("application/xml");
		// Call the REST method
		Response r = restClient.get();
		// Get the XML entity in response and cast to class
		  sp = r.readEntity(SignalParameters.class);
		return sp;
	}

	public void setSignalParameters(SignalParameters sp) {// Metodo para modificar parametros de señal del generador
		// Set relative path to REST method
		restClient.replacePath("setParams");
		// Set type of data received
		restClient.type("text/xml");
		// Call the REST method
		 restClient.post(sp);	
	}

	public void show() {
		frame.getFrame().setVisible(true);

	}
	
}