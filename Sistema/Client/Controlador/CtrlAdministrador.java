package Client.Controlador;

import java.util.Scanner;

import Client.Vista.Administrador.MenuAdministrador;
import Client.Vista.Administrador.AltaUsuarios;
import Client.Vista.Administrador.BajaUsuarios;
import Common.ModeloUsuarios;

public class CtrlAdministrador{

    private Scanner sc;
    private ModeloUsuarios modeloUsuarios;

    public CtrlAdministrador(Scanner sc, ModeloUsuarios modeloUsuarios){
        try {
            
            
            this.sc = sc;
            this.modeloUsuarios = modeloUsuarios;
            MenuAdministrador menuAdm = new MenuAdministrador(sc);
            boolean existe;
            do{
                menuAdm.show();
                switch(menuAdm.getOpcion()){
                    case 1://Altas de Usuarios
                        AltaUsuarios alta = new AltaUsuarios(sc);
                        existe = modeloUsuarios.buscarUsuario(alta.getUsuario().getUser());
                        if(existe)
                            alta.setMsg("El usuario ya existe!");
                        else
                            modeloUsuarios.alta(alta.getUsuario());                    
                        break;
                    case 2://Bajas
                        BajaUsuarios baja =  new BajaUsuarios(sc);                    
                        do{
                            baja.show();
                            existe = modeloUsuarios.buscarUsuario(baja.getUsuario());
                            if(existe){
                                //Existe el usuario
                                //modeloUsuarios.eliminar(baja.getUsuario());
                                //baja.setMsg("Se da de baja!");
                            }else{
                                baja.setMsg("Usuario inexistente. Intenta de nuevo!");
                            }
                        }while(!existe);
                        break;
                    case 3://Salir
                        break;
                    default://Opcion incorrecta
                        menuAdm.setMsg("Opcion Incorrecta");
                }
            }while(menuAdm.getOpcion()!=3);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}