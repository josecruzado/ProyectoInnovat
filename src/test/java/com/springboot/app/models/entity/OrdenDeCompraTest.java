package com.springboot.app.models.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class OrdenDeCompraTest {

	@Test
	public void test_calcularSubtotal() {
		System.out.println("Calcular Costo SubTotal de la Orden de Compra");
		List<DetalleDeOrden> d = new ArrayList<DetalleDeOrden>();
		DetalleDeOrden detalleDeOrden1= new DetalleDeOrden(5,2);
		DetalleDeOrden detalleDeOrden2= new DetalleDeOrden(3,8);
		DetalleDeOrden detalleDeOrden3= new DetalleDeOrden(6,4);
		d.add(detalleDeOrden1);
		d.add(detalleDeOrden2);
		d.add(detalleDeOrden3);
		OrdenDeCompra ordenDeCompra= new OrdenDeCompra();
		ordenDeCompra.setDetallesDeOrden(d);
		float resultado = 58;
		float resultadoEsperado = ordenDeCompra.calcularSubtotal();
		assertEquals(resultado,resultadoEsperado);
	}
	/*
	@Test
	public void test2_calcularSubtotal() {
		System.out.println("Calcular Costo SubTotal de la Orden de Compra Caso 1");
		HashSet<DetalleDeOrden> d = new HashSet<DetalleDeOrden>();
		DetalleDeOrden detalleDeOrden1= new DetalleDeOrden(5,2);
		DetalleDeOrden detalleDeOrden2= new DetalleDeOrden(3,8);
		DetalleDeOrden detalleDeOrden3= new DetalleDeOrden(6,4);
		d.add(detalleDeOrden1);
		d.add(detalleDeOrden2);
		d.add(detalleDeOrden3);
		OrdenDeCompra ordenDeCompra= new OrdenDeCompra();
		float resultado = 50;
		float resultadoEsperado = ordenDeCompra.calcularSubtotal(d);
		assertEquals(resultado,resultadoEsperado);
	}*/
	
	@Test
	public void test_calcularCostoTotal() {
		System.out.println("Calcular Costo SubTotal de la Orden de Compra");
		List<DetalleDeOrden> d = new ArrayList<DetalleDeOrden>();
		DetalleDeOrden detalleDeOrden1= new DetalleDeOrden(5,2);
		DetalleDeOrden detalleDeOrden2= new DetalleDeOrden(3,8);
		DetalleDeOrden detalleDeOrden3= new DetalleDeOrden(6,4);
		d.add(detalleDeOrden1);
		d.add(detalleDeOrden2);
		d.add(detalleDeOrden3);
		OrdenDeCompra ordenDeCompra= new OrdenDeCompra();
		ordenDeCompra.setDetallesDeOrden(d);
		float resultado = (float)68.44;
		float resultadoEsperado = ordenDeCompra.calcularCostoTotal();
		assertEquals(resultado,resultadoEsperado);
	}
	
	@Test
	public void test_calcularTotalPorMoneda() {
		System.out.println("Calcular Total por tipo de Moneda de la Orden de Compra");
		List<DetalleDeOrden> d = new ArrayList<DetalleDeOrden>();
		DetalleDeOrden detalleDeOrden1= new DetalleDeOrden(5,2);
		DetalleDeOrden detalleDeOrden2= new DetalleDeOrden(3,8);
		DetalleDeOrden detalleDeOrden3= new DetalleDeOrden(6,4);
		d.add(detalleDeOrden1);
		d.add(detalleDeOrden2);
		d.add(detalleDeOrden3);
		String divisa ="Dolares";
		OrdenDeCompra ordenDeCompra= new OrdenDeCompra();
		ordenDeCompra.setDetallesDeOrden(d);
		float resultado = (float)217.6392;
		float resultadoEsperado = ordenDeCompra.calcularTotalPorMoneda(divisa);
		assertEquals(resultado,resultadoEsperado,0.001f);
	}

	@Test
	public void test_actualizarEstado() {
		System.out.println("Test Actualizar Estado");
		String estado = "Recibido";
		OrdenDeCompra ordenDeCompra = new OrdenDeCompra();
		String resultadoEsperado = "Recibido";
		ordenDeCompra.actualizarEstado(estado);
		String resultado=ordenDeCompra.getEstado();
		assertEquals(resultadoEsperado, resultado);
	}

	@Test
	public void test_productoMinimo() {
		System.out.println("¿Hay Minimo de producto?");
		List<DetalleDeOrden> d = new ArrayList<DetalleDeOrden>();
		DetalleDeOrden detalleDeOrden1= new DetalleDeOrden(5,2);
		DetalleDeOrden detalleDeOrden2= new DetalleDeOrden(3,8);
		DetalleDeOrden detalleDeOrden3= new DetalleDeOrden(6,4);
		d.add(detalleDeOrden1);
		d.add(detalleDeOrden2);
		d.add(detalleDeOrden3);
		OrdenDeCompra ordenDeCompra= new OrdenDeCompra();
		ordenDeCompra.setDetallesDeOrden(d);
		boolean resultadoEsperado=true;
		boolean resultado=ordenDeCompra.hayDetalleDeOrden();
		assertEquals(resultadoEsperado,resultado);
	}
	
	              
}
