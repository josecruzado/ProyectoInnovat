package com.springboot.app.models.aplication;

import com.springboot.app.models.entity.DetalleDeOrden;
import com.springboot.app.models.entity.OrdenDeCompra;
import com.springboot.app.models.services.IEmpleadoService;
import com.springboot.app.models.services.IOrdenDeCompraService;
import com.springboot.app.models.services.IProductoService;
import com.springboot.app.models.services.IProveedorService;

import java.util.ArrayList;
import java.util.List;

public class GenerarOrdenService {

    private final IOrdenDeCompraService ordenDeCompraService;
    private final IProveedorService iProveedorService;
    private final IProductoService iProductoService;
    private final IEmpleadoService empleadoService;

    private static GenerarOrdenService generarOrdenService = null;

    private GenerarOrdenService(IOrdenDeCompraService ordenDeCompraService, IProveedorService iProveedorService, IProductoService iProductoService, IEmpleadoService empleadoService) {
        this.ordenDeCompraService = ordenDeCompraService;
        this.iProveedorService = iProveedorService;
        this.iProductoService = iProductoService;
        this.empleadoService = empleadoService;
    }

    public  static  GenerarOrdenService getInstance(IOrdenDeCompraService ordenDeCompraService,IProveedorService iProveedorService,IProductoService iProductoService,IEmpleadoService empleadoService) {
        if (generarOrdenService==null) {

            generarOrdenService=new GenerarOrdenService(ordenDeCompraService, iProveedorService, iProductoService, empleadoService);
        }
        return generarOrdenService;
    }

    private boolean esOrdenValida(OrdenDeCompra ordenDeCompra) throws Exception {
        if(!ordenDeCompra.esFechaEnvioValida()){
            throw new Exception("fecha envio no valida");
        }
        if(!ordenDeCompra.esFechaRequeridaValida()){
            throw new Exception("fecha requerida no valida");
        }
        if(!ordenDeCompra.esRucValido()){
            throw new Exception("Ruc no valido");
        }
        return true;
    }

    public void guardar(OrdenDeCompra ordenDeCompra) throws Exception {
        ordenDeCompra.setEmpleado(empleadoService.findById(1L));
        ordenDeCompra.setDetallesDeOrden(getDetalles(ordenDeCompra));
        ordenDeCompra.setProveedor(iProveedorService.findByRuc(ordenDeCompra.getProveedor().getRuc()));


        if(esOrdenValida(ordenDeCompra)){
            ordenDeCompraService.save(ordenDeCompra);
        }
    }

    private List<DetalleDeOrden> getDetalles(OrdenDeCompra ordenDeCompra){
        List<DetalleDeOrden> detallesDeOrden = new ArrayList<DetalleDeOrden>();

        for (DetalleDeOrden detalle: ordenDeCompra.getDetallesDeOrden()){
            DetalleDeOrden detalleDeOrden = new DetalleDeOrden();
            detalleDeOrden.setCantidad(detalle.getCantidad());
            detalleDeOrden.setProducto(iProductoService.findById(detalle.getProducto().getId()));
            detalleDeOrden.setPrecio(detalleDeOrden.getProducto().getPrecio());
            detalleDeOrden.setOrdenDeCompra(ordenDeCompra);

            detallesDeOrden.add(detalleDeOrden);
        }

        return  detallesDeOrden;
    }

}
