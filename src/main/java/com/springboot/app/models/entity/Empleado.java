package com.springboot.app.models.entity;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable    {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="dni")
    private String dni;

    @NotNull
    @Column (name="contraseña")
    private String contraseña;

    @NotNull
    @Column (name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private Set<OrdenDeCompra> ordenesDeCompra = new HashSet<>();


    public Empleado(Long id, String dni, String contraseña, String nombre, Set<OrdenDeCompra> ordenesDeCompra) {
        super();
        this.id = id;
        this.dni = dni;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.ordenesDeCompra = ordenesDeCompra;
    }

    public Empleado() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long empleadoId) {
        this.id = empleadoId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
