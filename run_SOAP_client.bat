@echo off

echo Presiona Enter para ejecutar Cliente SOAP
pause > null
java -cp ./lib/WS_SOAP_Client.jar;./lib/SignalModel.jar;./lib/SignalPlot.jar;./lib/jcommon-1.0.17.jar;./lib/jfreechart-1.0.14.jar;./lib/jax-ws/* es.uned.scc.grados.appdist.trabajos.ws.soap.WSClient