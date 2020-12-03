package com.springboot.app.models.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="almacenDetalle")
public class AlmacenDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column (name="cantidadMax")
    private int cantidadMax;

    @NotNull
    @Column (name="stock")
    private int stock;

    @NotNull
    @Column (name="ubicacion")
    private String ubicacion;

    //RELACION MUCHOS A UNO

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "almacenId", nullable = false)
    private Almacen almacen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productoId", nullable = false)
    private Producto producto;

    public AlmacenDetalle(Long id, @NotNull int cantidadMax, @NotNull int stock, @NotNull String ubicacion, @NotNull Almacen almacen, @NotNull Producto producto) {
        super();
        this.id = id;
        this.cantidadMax = cantidadMax;
        this.stock = stock;
        this.ubicacion = ubicacion;
        this.almacen = almacen;
        this.producto = producto;
    }

    public AlmacenDetalle() {

    }

    //FUNCIONES A IMPLEMENTAR

    /*
    private void actualizarStock(){

    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long almacenDetalleId) {
        this.id = almacenDetalleId;
    }

    public int getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(int cantMaxima) {
        this.cantidadMax = cantMaxima;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Almacen getAlmacen() { return almacen; }

    public void setAlmacen(Almacen almacen) { this.almacen = almacen; }

    public Producto getProducto() { return producto; }

    public void setProducto(Producto producto) { this.producto = producto; }
}
