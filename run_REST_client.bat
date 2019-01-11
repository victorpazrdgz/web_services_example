@echo off

echo Presiona Enter para ejecutar cliente REST
pause > null
java -cp ./lib/WS_REST_Client.jar;./lib/SignalModel.jar;./lib/SignalPlot.jar;./lib/jcommon-1.0.17.jar;./lib/jfreechart-1.0.14.jar;./lib/apache-cxf-3.1.3/* es.uned.scc.appdist.trabajos.rest.client.RESTClient
