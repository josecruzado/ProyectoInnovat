package com.springboot.app.models.aplication;

import com.springboot.app.models.entity.OrdenDeCompra;
import com.springboot.app.models.services.IOrdenDeCompraService;

import java.util.List;

public class ReportarOrdenesService {
    private final IOrdenDeCompraService ordenDeCompraService;

    private static ReportarOrdenesService reportarOrdenesService;

    public ReportarOrdenesService(IOrdenDeCompraService ordenDeCompraService) {
        this.ordenDeCompraService = ordenDeCompraService;
    }

    public  static  ReportarOrdenesService getInstance(IOrdenDeCompraService ordenDeCompraService) {
        if (reportarOrdenesService==null) {

            reportarOrdenesService=new ReportarOrdenesService(ordenDeCompraService);
        }
        return reportarOrdenesService;
    }

    public List<OrdenDeCompra> list(){
        return ordenDeCompraService.findAll();
    }
}
