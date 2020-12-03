package com.springboot.app.models.entity;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DetalleDeOrdenTest {
	@Test
	 public void test1_calcularPrecioTotalProducto() {
		System.out.println("Calcular Precio Total de Producto Caso 1");
		DetalleDeOrden detalleOrden= new DetalleDeOrden();
		detalleOrden.setCantidad(5);
		detalleOrden.setPrecio(10);
		float resultadoEsperado=50;
		float resultado =detalleOrden.calcularTotalDetalle();
		assertEquals(resultadoEsperado,resultado);
	}
	@Test
	 public void test2_calcularPrecioTotalProducto() {
		System.out.println("Calcular Precio Total de Producto Caso 2");
		DetalleDeOrden detalleOrden= new DetalleDeOrden();
		detalleOrden.setCantidad(10);
		detalleOrden.setPrecio(10);
		float resultadoEsperado=100;
		float resultado =detalleOrden.calcularTotalDetalle();
		assertEquals(resultadoEsperado,resultado);
	}
	@Test
	public void test1_esCantidadValidad() {
		System.out.println("Verificar Cantidad Valida Caso 1");
		DetalleDeOrden detalleOrden = new DetalleDeOrden();
		detalleOrden.setCantidad(5);
		boolean resultadoEsperado= true;
		boolean resultado = detalleOrden.esCantidadValida();
		assertEquals(resultadoEsperado,resultado);
	}
	@Test
	public void test2_esCantidadValidad() {
		System.out.println("Verificar Cantidad Valida Caso 2");
		DetalleDeOrden detalleOrden = new DetalleDeOrden();
		detalleOrden.setCantidad(0);
		boolean resultadoEsperado= false;
		boolean resultado = detalleOrden.esCantidadValida();
		assertEquals(resultadoEsperado,resultado);
	}
}
