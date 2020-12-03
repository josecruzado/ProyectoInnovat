package com.springboot.app.models.entity;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="ordenDeCompra")
public class OrdenDeCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="condicionDePago")
    private String condicionDePago;

    @NotNull
    @Column(name="divisa")
    private String divisa;

    @NotNull
    @Size(min=2, message = "Campo requerido")
    @Column(name="estado")
    private String estado;

    @NotNull
    @Column(name="costoTotal")
    private float costoTotal;

    @NotNull
    @Column(name="subTotal")
    private float subTotal;

    @Temporal(TemporalType.DATE)
    @Column (name="fechaEmision")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaEmision;

    @Temporal(TemporalType.DATE)
    @Column (name="fechaEnvio")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaEnvio;

    @Temporal(TemporalType.DATE)
    @Column (name="fechaRequerida")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaRequerida;

    @NotNull
    @Column(name="lugarEntrega")
    private String lugarEntrega;

//detalle de ordenes
    @OneToMany(mappedBy = "ordenDeCompra", cascade = CascadeType.ALL)
    private List<DetalleDeOrden> detallesDeOrden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleadoId", nullable = false)
    private Empleado empleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedorId", nullable = false)
    private Proveedor proveedor;

    //FUNCIONES ORDEN DE COMPRA

    @PrePersist
    private void prePersist(){
        subTotal=calcularSubtotal();
        costoTotal=calcularTotalPorMoneda(divisa);
        fechaEmision =new Date();
    }

    public float calcularCostoTotal(){
        float subtotal= calcularSubtotal();
        float igv = (float) (subtotal*0.18);
        return subtotal+igv;
    }

    public float calcularSubtotal(){
        float suma=0.0f;
        for (DetalleDeOrden detalleDeOrden : detallesDeOrden) {
            float totalDetalle = detalleDeOrden.calcularTotalDetalle();
            suma += totalDetalle;
        }
        return suma;
    }

    public float calcularTotalPorMoneda(String divisa){
        if(divisa.equals("Dolares")){
            float costototal= calcularCostoTotal();
            return (float)(costototal/3.6);
        }
        else if(divisa.equals("Soles")){
            return calcularCostoTotal();
        }
        else{
            return 0;
        }
    }


    public DetalleDeOrden buscarDetalleDeOrden(Long idProducto) {
        for (DetalleDeOrden detalleDeOrden : detallesDeOrden) {
            if(detalleDeOrden.getProducto().getId().equals(idProducto)) {
                return detalleDeOrden;
            }
        }
        return null;
    }

    public void actualizarEstado(String estado){
        if(estado.equals("Recibido")){
            this.estado="Recibido";
        }
        if(estado.equals("Enviado")){
            this.estado="Enviado";
        }
        if(estado.equals("Anulado")){
            this.estado="Anulado";
        }
        if(estado.equals("Espera")){
            this.estado="Espera";
        }
    }

    public boolean hayDetalleDeOrden() {
        return !detallesDeOrden.isEmpty();
    }

    //VALIDACIONES

    public boolean esFechaRequeridaValida(){
        return fechaEnvio.before(fechaRequerida);
    }
    public boolean esFechaEnvioValida(){
        return fechaEnvio.after(new Date());
    }
    public boolean esRucValido(){
        if(this.proveedor.getRuc().length()!=11){ return false; }
        for (char caracter: this.proveedor.getRuc().toCharArray()) {
            if(!Character.isDigit(caracter)){
                return false;
            }
        }
        return true;
    }


    //CONSTRUCTOR SET Y GET

    public OrdenDeCompra(String condicionDePago, String divisa, String estado, Date fechaEmision, Date fechaEnvio, Date fechaRequerida, String lugarEntrega, List<DetalleDeOrden> detallesDeOrden, Empleado empleado, Proveedor proveedor) {
        super();
        this.condicionDePago = condicionDePago;
        this.divisa = divisa;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.fechaEnvio = fechaEnvio;
        this.fechaRequerida = fechaRequerida;
        this.lugarEntrega = lugarEntrega;
        this.detallesDeOrden = detallesDeOrden;
        this.empleado = empleado;
        this.proveedor = proveedor;
    }

    public OrdenDeCompra() {
        this.proveedor=new Proveedor();
        this.detallesDeOrden = new ArrayList<DetalleDeOrden>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ordenDeCompraId) {
        this.id = ordenDeCompraId;
    }

    public String getCondicionDePago() {
        return condicionDePago;
    }

    public void setCondicionDePago(String condicionDePago) {
        this.condicionDePago = condicionDePago;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public float getSubTotal() {
        return subTotal;
    }
/*
    public void setSubTotal() {
        this.subTotal = subTotal;
    }
*/
    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaDeEmision) {
        this.fechaEmision = fechaDeEmision;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaDeEnvio) {
        this.fechaEnvio = fechaDeEnvio;
    }

    public Date getFechaRequerida() {
        return fechaRequerida;
    }

    public void setFechaRequerida(Date fechaRequerida) {
        this.fechaRequerida = fechaRequerida;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarDeEntrega) {
        this.lugarEntrega = lugarDeEntrega;
    }

    public List<DetalleDeOrden> getDetallesDeOrden() {
        return detallesDeOrden;
    }

    public void setDetallesDeOrden(List<DetalleDeOrden> detalleDeOrden) {
        this.detallesDeOrden = detalleDeOrden;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
