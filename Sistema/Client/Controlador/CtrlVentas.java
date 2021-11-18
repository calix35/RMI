package Client.Controlador;

import java.util.Scanner;

import Client.Vista.Ventas.MenuVentas;
import Client.Vista.Ventas.AltaProductos;
import Client.Vista.Ventas.VentaProductos;
import Client.Vista.Ventas.ListadoProductos;
import Common.ModeloProductos;
import Common.Producto;

public class CtrlVentas{

    private Scanner sc;
    private ModeloProductos modeloProductos;

    public CtrlVentas(Scanner sc, ModeloProductos modeloProductos) {
        try {
            
            
            this.sc = sc;
            this.modeloProductos = modeloProductos;
            MenuVentas menuVentas = new MenuVentas(sc);
            do{
                menuVentas.show();
                switch(menuVentas.getOpcion()){
                    case 1://Altas de Usuarios
                        AltaProductos alta = new AltaProductos(sc);
                        modeloProductos.alta(alta.getProducto());                                       
                        break;
                    case 2://Ventas
                        VentaProductos venta = new VentaProductos(sc);
                        String id;
                        double total = 0;
                        do{
                            id = venta.getId();
                            if(!id.equals("-1")){
                                Producto producto = modeloProductos.buscarProducto(id);
                                if(producto != null){
                                    if(producto.getExistencias()>=1){
                                        venta.setMsg(producto.getNombre() + " " + producto.getCosto());
                                        total += producto.getCosto();
                                        producto.restarExistencias();
                                    }else{
                                        venta.setMsg("Cantidad no disponible!");
                                    }
                                }else{
                                    venta.setMsg("Producto inexistente!");
                                }
                            }
                        }while(!id.equals("-1"));
                        venta.setMsg("Total a pagar: " + total);
                        break;
                    case 3://Lista de Productos
                        ListadoProductos listado  = new ListadoProductos();                    
                        listado.imprimirProductos(modeloProductos.getProductos());
                        break;
                    case 4://Salir
                        break;
                    default://Opcion incorrecta
                        menuVentas.setMsg("Opcion Incorrecta");
                }
            }while(menuVentas.getOpcion()!=4);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}