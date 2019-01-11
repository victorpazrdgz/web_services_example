package es.uned.scc.grados.appdist.trabajos.ws.soap;

import java.rmi.RemoteException;

import es.uned.scc.grados.appdist.trabajos.plot.ClientGUI;
import es.uned.scc.grados.appdist.trabajos.plot.ClientPlot;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalData;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalParameters;
import es.uned.scc.grados.appdist.trabajos.ws.SignalGeneratorWS;

// Clase que implementa la interfaz client plot SOAP

public class PlottingFrame implements ClientPlot {
	SignalGeneratorWS soapClient = null;
	ClientGUI frame = null;
	
	
	public PlottingFrame(SignalGeneratorWS soapClient) {
		this.soapClient = soapClient;
		frame = new ClientGUI(this);
	}

	@Override
	public boolean start() { // Metodo para arrancar el generdor
		try {
			soapClient.start();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return true;
	}

	@Override
	public boolean stop(){ //Metodo para parar el generdor
		try {
			soapClient.stop();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}


	public SignalData getSignalValue() { // Metodo para obtener valores de señal del generador
		es.uned.scc.grados.appdist.trabajos.ws.SignalData sd=null;
			 try {
				sd = this.soapClient.getSignalValue();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ConvertData.tosenalDataOriginal(sd); //LLamamos a la clase ConvertData para pasar los datos obtenidos al formanto original
	}
	


	public SignalParameters getSignalParameters() {// Metodo para obtener parametros de señal del generador
		es.uned.scc.grados.appdist.trabajos.ws.SignalParameters sp=null;
		try {
			sp = this.soapClient.getSignalParameters();	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ConvertData.tosenalParametersOriginal(sp); // LLamamos a la clase ConvertData para pasar los parametros obtenidos al formanto original
	}
	

	
	@Override
	public void setSignalParameters(SignalParameters sp) {// Metodo para modificar parametros de señal del generador
		es.uned.scc.grados.appdist.trabajos.ws.SignalParameters sp1=null;
		sp1= ConvertData.tosenalParametersGenerados(sp);// LLamamos a la clase ConvertData para pasar los parametros obtenidos al formato de nuestro cliente
		try {
			this.soapClient.setSignalParameters(sp1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void show() {
		frame.getFrame().setVisible(true);
	}

	
}