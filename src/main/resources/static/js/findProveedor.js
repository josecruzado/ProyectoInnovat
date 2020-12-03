const url = 'https://api.sunat.cloud/ruc/';

$(document).ready(function () {
    $("#btnFindProveedor").click(function () {
        const ruc = $("#inputRUC").val();
        $.ajax({
            type: "POST",
            url: "https://api.migo.pe/api/v1/ruc",
            data: {
                token: "Yg4sGM9ZtvkyW1o7YSR8XNpeYhOau2GcR1F8xiZtawXwBwbWbSepLBTl7IMW",
                ruc: ruc,
            },
            success: function (result) {
                console.log(result);
                var json=JSON.parse(JSON.stringify(result));
                console.log(json);
                let proveedor = new Proveedor(json.ruc,json.nombre_o_razon_social,json.direccion);
                console.log(proveedor);

                $("#inputRazonSocial").val(proveedor.nombre_o_razon_social);
                $("#inputDireccion").val(proveedor.direccion);
            },
            error: function (error) {
                Swal.fire({
                    title: 'Proveedor no existe',
                    animation: false,
                    icon: 'error',
                    customClass: 'animated tada'

                })
                console.log(error);
            },
        });
    })
})

class Proveedor {
    constructor(ruc, nombre_o_razon_social, direccion) {
      this.ruc = ruc;
      this.nombre_o_razon_social = nombre_o_razon_social;
      this.direccion = direccion;
    }
  }