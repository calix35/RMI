package server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

//Interface de mi objeto remoto
import common.Hello;


public class Server implements Hello{
    public Server(){

    }

    public String sayHello(){
        return "Hello, Alan was here!";
    }

    public static void main(String[] args) {
        try {
            //Creo el objeto remoto
            Server obj = new Server();

            //Creo el stub, encargado de recibir parametros y de regresar informacion
            Hello stub =  (Hello)UnicastRemoteObject.exportObject(obj, 0);

            //Localizar el rmiregistry, es decir que este abierto
            Registry registry = LocateRegistry.getRegistry();

            //Registrar el objeto en la red
            registry.rebind("Hello", stub);

            System.out.println("Servidor listo!!!");
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}