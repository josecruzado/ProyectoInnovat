package com.springboot.app.controllers;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springboot.app.models.entity.Producto;
import com.springboot.app.models.services.IProductoService;

@Controller
@SessionAttributes("producto")
public class ProductoController {
	@Autowired
	private IProductoService productoService;

	@GetMapping(value = "/productos/n/{name}", produces = { "application/json" })
	public @ResponseBody List<Producto> findByName(@PathVariable String name){
		return productoService.findByNombre(name);
	}
	
	@GetMapping("/productos")
	private Set<Producto> index(){
		return productoService.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto show(@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto producto) {
		return productoService.save(producto);
	}
	
	@PutMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoActual=productoService.findById(id);
		productoActual.setNombre(producto.getNombre());
		productoActual.setPrecio(producto.getPrecio());
		return productoService.save(productoActual);
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productoService.deleteById(id);
	}
}
