package com.springboot.app.controllers;

import com.springboot.app.models.entity.Almacen;
import com.springboot.app.models.services.IAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@SessionAttributes("almacen")
public class AlmacenController {

    @Autowired
    private IAlmacenService almacenService;


    @RequestMapping(value = "listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo","Listado de productos");
        model.addAttribute("productos",almacenService.findAll());
        return "listar";
    }

    @RequestMapping(value="/form")
    public String crear(Map<String, Object> model) {
        model.put("titulo","Formulario de Productos");
        Almacen almacen= new Almacen();
        model.put("producto", almacen);
        return "form";
    }


    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String guardar(@Validated Almacen almacen, BindingResult result, Model model, SessionStatus status, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            model.addAttribute("titulo","Formulario de Clientes");
            return "form";
        }
        almacenService.save(almacen);
        status.setComplete();
        redirectAttributes.addFlashAttribute("success","Grabado con éxito");
        return "redirect:listar";
    }

    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String,Object> model, RedirectAttributes redirectAttributes) {
        Almacen almacen=null;
        if(id>0){
            almacen=almacenService.findById(id);
            if(almacen==null){
                redirectAttributes.addFlashAttribute("error","El ID del Producto no existe en la BD");
            }
        }
        else{	redirectAttributes.addAttribute("error","El ID del Cliente no puede ser cero!");
            return "redirect:/listar";
        }
        model.put("paciente",almacen);
        model.put("titulo","Editar de Producto");
        return "form";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id,RedirectAttributes f) {
        if(id>0) {
            almacenService.deleteById(id);
            f.addFlashAttribute("success","Eliminado con éxito");
        }
        return "redirect:/listar";
    }
}
