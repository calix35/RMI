package Client.Vista.Administrador;

import java.util.Scanner;
import Common.Usuario;

public class AltaUsuarios{
    private Usuario usuario;

    public Usuario getUsuario(){
        return this.usuario;
    }

    public AltaUsuarios(Scanner sc){
        String nombre, user, pass;
        int tipo;
        System.out.print("Nombre: ");        
        nombre = sc.nextLine();
        nombre = sc.nextLine();
        System.out.print("User: ");
        user = sc.nextLine();
        System.out.print("Pass: ");
        pass = sc.nextLine();
        System.out.print("Tipo: ");
        tipo = sc.nextInt();
        this.usuario = new Usuario(user, pass, nombre, tipo);
    }

    public void setMsg(String msg){
        System.out.println(msg);
    }
}