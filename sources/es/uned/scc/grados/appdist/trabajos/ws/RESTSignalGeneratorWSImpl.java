package es.uned.scc.grados.appdist.trabajos.ws;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import es.uned.scc.grados.appdist.trabajos.signal.model.SignalGenerator;
import es.uned.scc.grados.appdist.trabajos.signal.model.SignalGeneratorThread;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.OperationInfo;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalData;
import es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalParameters;

//Clase implementa interfaz generador REST
@Path("SignalGenerator")
public class RESTSignalGeneratorWSImpl implements RESTSignalGenerator {
	
	static double sampleTime = 0.01;
	static SignalGeneratorThread sgThread = new SignalGeneratorThread(sampleTime);
	
	@GET
	@Path("start")
	@Produces({"text/xml"})
	public OperationInfo start() { //Inicia el funcionamiento de generador de señales
		// TODO Auto-generated method stub
		return sgThread.start();
	}
    
	@GET
	@Path("stop")
	@Produces({"text/xml"})
	public OperationInfo stop() {  // Para el generador de señales
		// TODO Auto-generated method stub
		return sgThread.stop();
	}
	
	@GET
	@Path("isrunning")
	@Produces({"text/xml"})
	public OperationInfo isRunning() { // Comprueba el estado de funcionamiento del generador
		
		return sgThread.isThreadRunning();
	}
	
	@GET
	@Path("get")
	@Produces({"text/xml"})
	public SignalData getSignalValue() {  // Obtiene los datos de tiempo y de salida del generador
		SignalGenerator sg = RESTSignalGeneratorWSImpl.sgThread.getSignalgenerator();
		SignalData sd = new SignalData(sg.getTime(), sg.getOutput());
		return sd;
	}
	
	@GET
	@Path("getParams")
	@Produces({"text/xml"})
	public SignalParameters getSignalParameters() {// Obtiene los parametros de Amplitud, Frecuencia y el tipo de señal del generador
		SignalGenerator sg = RESTSignalGeneratorWSImpl.sgThread.getSignalgenerator();
		SignalParameters sp = new SignalParameters(sg.getType(), sg.getAmplitude(), sg.getFrequency());
		return sp;	
	}
	
	@POST
	@Path("setParams")
	@Produces({"text/xml"})
	public void setSignalParameters(SignalParameters signal_parameters) {//Cambia los parametros de Amplitud, Frecuencia y tipo de señal en el generador	
		SignalGenerator sg = RESTSignalGeneratorWSImpl.sgThread.getSignalgenerator();
		sg.setSignalType(signal_parameters.getType());
		sg.setAmplitude(signal_parameters.getAmplitude());
		sg.setFrequency(signal_parameters.getFrequency());
		
	}

}
