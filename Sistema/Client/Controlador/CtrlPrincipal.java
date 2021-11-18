package Client.Controlador;

import java.util.Scanner;

import Client.Vista.Login;

/*import Modelo.ModeloUsuariosPersistente;
import Modelo.ModeloProductos;
import DataObjects.Usuario;*/

import Common.ModeloProductos;
import Common.ModeloUsuarios;
import Common.Usuario;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class CtrlPrincipal{
    private Scanner sc = new Scanner(System.in);
    private Login login = new Login(sc);
    /*private ModeloUsuariosPersistente modeloUsuarios = new ModeloUsuariosPersistente();
    private ModeloProductos modeloProductos = new ModeloProductos();*/
    private Registry registry;
    private ModeloUsuarios modeloUsuarios;
    private ModeloProductos modeloProductos;
    public CtrlPrincipal() {
        try {
            registry = LocateRegistry.getRegistry("localhost");
            modeloUsuarios = (ModeloUsuarios)registry.lookup("ModeloUsuarios");    
            modeloProductos = (ModeloProductos)registry.lookup("ModeloProductos");    
        
        
            do{
                login.show();        
                Usuario usuario = modeloUsuarios.login(login.getUser(), login.getPass());                
                if(usuario!=null){
                    switch(usuario.getTipo()){
                        case 1://Administrador                            
                            new CtrlAdministrador(sc, modeloUsuarios);
                            break;
                        case 2://Vendedor
                            new CtrlVentas(sc, modeloProductos);
                            break;
                    }
                }else{
                    //Login incorrecto
                    login.setMsg("Login incorrecto");
                }
            }while(true);
        } catch (Exception e) {
        //TODO: handle exception
        }
    }
}