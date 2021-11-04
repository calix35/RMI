package server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

//Interface de mi objeto remoto
import common.Calculadora;


public class Server  {
    

    public static void main(String[] args) {
        try {
            //Creo el objeto remoto
            CalculadoraRemota calculadora =  new CalculadoraRemota();

            //Creo el stub, encargado de recibir parametros y de regresar informacion
            Calculadora calc_remota =  (Calculadora)UnicastRemoteObject.exportObject(calculadora, 0);
            
            //Localizar el rmiregistry, es decir que este abierto
            Registry registry = LocateRegistry.getRegistry();
            
            //Registrar el objeto en la red
            registry.rebind("Calculadora", calc_remota);

            System.out.println("Servidor listo!!!");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

}