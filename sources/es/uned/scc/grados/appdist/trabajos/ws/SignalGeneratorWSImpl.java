package es.uned.scc.grados.appdist.trabajos.ws;

import java.rmi.RemoteException;

import javax.jws.WebService;

import es.uned.scc.grados.appdist.trabajos.signal.model.SignalGenerator;
import es.uned.scc.grados.appdist.trabajos.signal.model.SignalGeneratorThread;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.OperationInfo;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalData;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalParameters;
// Clase implementa interfaz generador SOAP
@WebService(endpointInterface = "es.uned.scc.grados.appdist.trabajos.ws.SignalGeneratorWS",
serviceName = "SignalGenerator")
public class SignalGeneratorWSImpl implements SignalGeneratorWS {
	public double sampleTime = 0.01;
	SignalGeneratorThread sgThread = new SignalGeneratorThread(sampleTime);
	public SignalGeneratorWSImpl(double sampleTime) throws RemoteException {

		super();
	}
	 
	public OperationInfo start() { //Inicia el funcionamiento de generador de señales
		// TODO Auto-generated method stub
		return sgThread.start();
	}
	
	
	public OperationInfo stop() { // Para el generador de señales
		// TODO Auto-generated method stub
		return  sgThread.stop();
	}


	public OperationInfo isRunning() { // Comprueba el estado de funcionamiento del generador
		// TODO Auto-generated method stub
		return sgThread.isThreadRunning();
	}

	
	public SignalData getSignalValue() { // Obtiene los datos de tiempo y de salida del generador
		SignalGenerator sg = this.sgThread.getSignalgenerator();
		SignalData sd = new SignalData(sg.getTime(), sg.getOutput());
		return sd;
		
	}


	public SignalParameters getSignalParameters() { // Obtiene los parametros de Amplitud, Frecuencia y el tipo de señal del generador
		SignalGenerator sg = this.sgThread.getSignalgenerator();
		SignalParameters sp = new SignalParameters(sg.getType(), sg.getAmplitude(), sg.getFrequency());
		return sp;		
	}


	public void setSignalParameters(SignalParameters signal_parameters) {  //Cambia los parametros de Amplitud, Frecuencia y tipo de señal en el generador	
		SignalGenerator sg = this.sgThread.getSignalgenerator();
		sg.setSignalType(signal_parameters.getType());
		sg.setAmplitude(signal_parameters.getAmplitude());
		sg.setFrequency(signal_parameters.getFrequency());		
	}

}
