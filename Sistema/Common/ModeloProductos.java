package Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.ArrayList;

import Common.Producto;

public interface ModeloProductos extends Remote{    
    public ArrayList<Producto> getProductos() throws RemoteException;
    public void alta(Producto producto) throws RemoteException;
    public Producto buscarProducto(String id) throws RemoteException;
}