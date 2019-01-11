package es.uned.scc.grados.appdist.trabajos.ws.soap;




import es.uned.scc.grados.appdist.trabajos.signal.model.data.WaveForm;
// **Clase auxiliar para convertir los datos al formato deseado**
public class ConvertData {


    // Metodo que pasa los datos de nuestro cliente al formato de la interface grafica
	static public es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalData tosenalDataOriginal
	(es.uned.scc.grados.appdist.trabajos.ws.SignalData sd) {
	es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalData SenalOriginal =
	new es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalData();
	SenalOriginal.setTime(sd.getTime());
	SenalOriginal.setOutput(sd.getOutput());
	return SenalOriginal;
	}
	
	// Metodo que pasa los parametros de nuestra interface grafica al formato de nuestro cliente
	static public es.uned.scc.grados.appdist.trabajos.ws.SignalParameters tosenalParametersGenerados
	( es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalParameters sp) {
		es.uned.scc.grados.appdist.trabajos.ws.SignalParameters Parametrosgenerados =
	new es.uned.scc.grados.appdist.trabajos.ws.SignalParameters();
		Parametrosgenerados.setAmplitude(sp.getAmplitude());
		Parametrosgenerados.setFrequency(sp.getFrequency());
		if (sp.getType().equals(WaveForm.SINE)){
	    Parametrosgenerados.setType(es.uned.scc.grados.appdist.trabajos.ws.WaveForm.SINE);}
		else if (sp.getType().equals(WaveForm.SQUARE)){
			 Parametrosgenerados.setType(es.uned.scc.grados.appdist.trabajos.ws.WaveForm.SQUARE);}
		else if (sp.getType().equals(WaveForm.TRIANGLE)){
			 Parametrosgenerados.setType(es.uned.scc.grados.appdist.trabajos.ws.WaveForm.TRIANGLE);}
	return  Parametrosgenerados;
	}
	
	// Metodo que pasa los parametros de nuestro cliente al formato e la interface grafica
	static public es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalParameters tosenalParametersOriginal
	(es.uned.scc.grados.appdist.trabajos.ws.SignalParameters sp) {
		 es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalParameters ParametrosOriginales =
	new  es.uned.scc.grados.appdist.trabajos.signal.model.data.SignalParameters();
		 if (sp.getType().equals(es.uned.scc.grados.appdist.trabajos.ws.WaveForm.SINE)){	
		ParametrosOriginales.setType( WaveForm.SINE);}
		else if (sp.getType().equals(es.uned.scc.grados.appdist.trabajos.ws.WaveForm.SQUARE)){
			ParametrosOriginales.setType(WaveForm.SQUARE);}
		else if (sp.getType().equals(es.uned.scc.grados.appdist.trabajos.ws.WaveForm.TRIANGLE)){
			ParametrosOriginales.setType(WaveForm.TRIANGLE);}
		 ParametrosOriginales.setAmplitude(sp.getAmplitude());
		 ParametrosOriginales.setFrequency(sp.getFrequency());
	return  ParametrosOriginales;
	}
		
	}       
	
			

	

			
	 




