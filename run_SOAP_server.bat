@echo off

echo Presiona Enter para ejecutar server SOAP
pause > null
java -cp ./lib/WS_Services.jar;./lib/SignalModel.jar;./lib/apache-cxf-3.1.3/* es.uned.scc.grados.appdist.trabajos.ws.server.WSServer
