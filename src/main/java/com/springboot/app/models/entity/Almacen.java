package com.springboot.app.models.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="almacen")
public class Almacen implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column (name="descripcion")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "almacen")
    private Set<AlmacenDetalle> almacenesDetalle = new HashSet<>();

    public Almacen(Long id, @NotNull String descripcion, @NotNull Set<AlmacenDetalle> almacenesDetalle) {
        super();
        this.id = id;
        this.descripcion = descripcion;
        this.almacenesDetalle = almacenesDetalle;
    }

    public Almacen() {

    }

    public AlmacenDetalle buscarAlmacenDetalle(Long idProducto){
        for (AlmacenDetalle d :almacenesDetalle) {
            if(d.getProducto().getId().equals(idProducto)) {
                return d;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long almacenId) {
        this.id = almacenId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
