package com.springboot.app.models.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="nombre")
    private String nombre;

    @NotNull
    @Column(name="precio")
    private Float precio;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
    private final Set<AlmacenDetalle> almacenDetalles = new HashSet<>();


    public Producto(Long id, String nombre, Float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long productoId) {
        this.id = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

}
