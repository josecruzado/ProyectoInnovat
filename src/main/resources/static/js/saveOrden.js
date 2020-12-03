
class Producto {
    constructor(nombre, precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
class DetalleCompra {
    constructor(cantidad, precio, producto, ordenCompra) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.ordenCompra = ordenCompra;
    }
}
class OrdenCompra {
    constructor(condicionDePago, divisa, estado, fechaEnvio, fechaRequerida, lugarEntrega, detallesDeOrden, proveedor) {
        this.condicionDePago = condicionDePago;
        this.divisa = divisa;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.fechaRequerida = fechaRequerida;
        this.lugarEntrega = lugarEntrega;
        this.detallesDeOrden = detallesDeOrden;
        this.proveedor = proveedor;
    }
}

function getDetalle() {
    var table = $("#cargarItemProductos tbody");
    let detalles = new Array();
    table.find('tr').each(function (i, el) {
        var $tds = $(this).find('td').find('input');
        let id = $tds.eq(0).val();
        let cantidad = $tds.eq(1).val();

        let detalleOrden = new DetalleCompra(cantidad, null, {
            id: id
        }, null);
        detalles.push(detalleOrden);

    });
    return detalles;
}

function save() {
    let ordenCompra = new OrdenCompra(
        $("#condicionPago").val(),
        $("#divisa option:selected").text(),
        $("#estado option:selected").text(),
        new Date($('#fechaEnvio').val()),
        new Date($('#fechaRequerida').val()),
        $("#lugarEntrega").val(),
        null, {
            ruc: $("#inputRUC").val()
        }
    );

    ordenCompra.detallesDeOrden = getDetalle();
    if(ordenCompra.detallesDeOrden.length<=0){
        Swal.fire({
            title: 'No existen productos',
            animation: false,
            icon: 'warning',
            customClass: 'animated tada'

        })
        return;
    }

    ordenCompra.fechaRequerida.setDate(ordenCompra.fechaRequerida.getDate()+1);
    ordenCompra.fechaEnvio.setDate(ordenCompra.fechaEnvio.getDate()+1);

    if(ordenCompra.fechaEnvio>ordenCompra.fechaRequerida){
        Swal.fire({
            title: 'La fecha de envio no puede ser mayor a la requerida',
            animation: false,
            icon: 'warning',
            customClass: 'animated tada'
        })
        return;
    }
    console.log(ordenCompra);
    console.log(JSON.stringify(ordenCompra));

    let url = 'http://localhost:8080/orden/save';

    Swal.fire({
        title: 'Quieres guardar la orden de compra?',
        showDenyButton: true,
        confirmButtonText: `Guardar`,
        denyButtonText: `Cancelar`,
    }).then((result) => {
        /* Read more about isConfirmed, isDenied below */
        if (result.isConfirmed) {
            Swal.fire('Guardado!', '', 'success')

            console.log(JSON.stringify(ordenCompra));
            fetch(url, {
                method: 'POST', // or 'PUT'
                body: JSON.stringify(ordenCompra), // data can be `string` or {object}!
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => res.json())
                .catch(error => console.log('Error:'+ error))
                .then(response => {
                    console.log('Success:', response);
                    //window.location.replace("http://localhost:8080");
                });

        } else if (result.isDenied) {
            Swal.fire('Los cambios no se han realizado', '', 'info')
        }
    })


}