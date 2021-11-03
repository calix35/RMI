package client;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import common.Hello;

public class Client{

    public static void main(String[] args) {
    
        try {
            //Localizar el rmiregistry
            //OJO: El rmiregistry solo se ejecuta en el servidor
            //Como el cliente y el servidor estan en la misma computadora, se le puede poner localhost
            Registry registry = LocateRegistry.getRegistry("localhost");

            //Obtengo el objeto remoto
            Hello skeleton = (Hello)registry.lookup("Hello");

            //Ejecuto el metodo remoto
            String resp = skeleton.sayHello();

            //Imprimo la respuesta
            System.out.println(resp);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}