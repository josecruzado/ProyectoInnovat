package com.springboot.app.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="detalleDeOrden")
public class DetalleDeOrden implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column (name="cantidad")
    private int cantidad;

    @NotNull
    @Column (name="precio")
    private float precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productoId", nullable = false)
    private Producto producto;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordenDeCompraId")
    @JsonIgnore
    private OrdenDeCompra ordenDeCompra;

    //FUNCIONES DETALLE DE ORDEN

    public float calcularTotalDetalle(){
        return cantidad>0?cantidad*precio:0;
    }

    public boolean esCantidadValida(){
        return cantidad > 0;
    }


    //CONSTRUCTOR - SET GET

    public DetalleDeOrden(Long id, @NotNull int cantidad, @NotNull float precio, @NotNull Producto producto, @NotNull OrdenDeCompra ordenDeCompra) {
        super();
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.ordenDeCompra=ordenDeCompra;
    }
    public DetalleDeOrden( @NotNull int cantidad, @NotNull float precio) {
        super();
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public DetalleDeOrden() {
        this.producto=new Producto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long detalleDeOrdenId) {
        this.id = detalleDeOrdenId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setOrdenDeCompra(OrdenDeCompra ordenDeCompra){
        this.ordenDeCompra = ordenDeCompra;
    }
}
