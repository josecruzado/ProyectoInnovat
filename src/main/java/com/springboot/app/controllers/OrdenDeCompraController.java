package com.springboot.app.controllers;

import java.util.*;

import com.springboot.app.models.aplication.GenerarOrdenService;
import com.springboot.app.models.aplication.ReportarOrdenesService;
import com.springboot.app.models.entity.*;
import com.springboot.app.models.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("ordenDeCompra")
public class OrdenDeCompraController {

    @Autowired
    private IProveedorService iProveedorService;

    @Autowired
    private IProductoService iProductoService;

    @Autowired
    private IOrdenDeCompraService ordenDeCompraService;

    @Autowired
    private IEmpleadoService empleadoService;

    //Reporte
    @GetMapping(value = "orden")
    public String listar(Model model) {
        model.addAttribute("titulo","Listado de ordenes");
        model.addAttribute("ordenes", ReportarOrdenesService.getInstance(ordenDeCompraService).list());
        return "orden/reporteOrdenes";
    }

    @GetMapping(value="orden/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id,RedirectAttributes f) {
        if(id>0) {
            ordenDeCompraService.deleteById(id);
            f.addFlashAttribute("success","Eliminado con éxito");
        }
        return "redirect:/orden";
    }

    //GenerarOrdenDeCompra
    @GetMapping(value="orden/new")
    public String crear(HttpServletRequest request,Map<String, Object> model) {
        model.put("titulo","Formulario de Orden de Compra");
        return "orden/generarOrden";
    }

    //FORMULARIO
    @PostMapping(value = "orden/save")
    public String save(@RequestBody OrdenDeCompra ordenDeCompra, SessionStatus status, RedirectAttributes redirectAttributes, Model model) {
        try {
            GenerarOrdenService.getInstance(ordenDeCompraService, iProveedorService, iProductoService, empleadoService).guardar(ordenDeCompra);
            status.setComplete();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.toString());
            redirectAttributes.addFlashAttribute("error", "Ocurrio un error al intenet guardar la orden");
        }
        return "index";
    }



}
