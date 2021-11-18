package Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ModeloUsuarios extends Remote{    
    Usuario login(String user, String pass) throws RemoteException;
    public void alta(Usuario usuario) throws RemoteException;
    public boolean buscarUsuario(String user) throws RemoteException;
}