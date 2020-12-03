package com.springboot.app.models.entity;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="direccion")
    private String direccion;

    @NotNull
    @Column(name="razonSocial")
    private String razonSocial;

    @NotNull
    @Column(name="ruc")
    private String ruc;

    @NotNull
    @Column(name="telefono")
    private String telefono;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<OrdenDeCompra> ordenesDeCompra;

    //CONSTRUCTOR SET Y GET

    public Proveedor(Long id, String razonSocial, String direccion, String ruc, String telefono) {
        super();
        this.razonSocial=razonSocial;
        this.id = id;
        this.direccion = direccion;
        this.ruc = ruc;
        this.telefono = telefono;
    }

    public Proveedor() {

    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long proveedorId) {
        this.id = proveedorId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
