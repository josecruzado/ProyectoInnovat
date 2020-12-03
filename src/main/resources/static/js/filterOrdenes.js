function stringToDate(s) {
    var ret = NaN;
    var parts = s.split("-");
    date = new Date(parts[0], parts[1] - 1, parts[2]);
    if (!isNaN(date.getTime())) {
        ret = date;
    }
    return ret;
}

$(document).ready(function () {
    $("#inputTerm").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#tableOrdenes tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });

        calcularTotal();
    });

    $("#filterDate").on("click", function () {
        var from = stringToDate($("#inputFrom").val());
        var to = stringToDate($("#inputTo").val());
        console.log("From: " + from + " To: " + to);

        $("#tableOrdenes tr").each(function () {
            var row = $(this);
            var date = stringToDate(row.find("td").eq(6).text());

            //show all rows by default
            var show = true;

            //if from date is valid and row date is less than from date, hide the row
            if (from && date < from)
                show = false;
                Swal.fire({
                    title: 'Fecha invalida',
                    animation: false,
                    icon: 'warning',
                    customClass: 'animated tada'

                })
                console.log(error);
            //if to date is valid and row date is greater than to date, hide the row
            if (to && date > to)
                show = false;

            if (show)
                row.show();
            else
                row.hide();
        })

        calcularTotal();
    });

    $('#estado').change(function () {
        let stateSelect = $(this).find("option:selected").attr('value');
        console.log(stateSelect);

        $("#tableOrdenes tr").each(function () {
            var row = $(this);
            var state = row.find("td").eq(5).text();

            var show = true;

            if (state.localeCompare(stateSelect) == 0 || stateSelect.localeCompare('Todos') == 0) {
                show = true;
            } else {
                show = false;
            }

            if (show)
                row.show();
            else
                row.hide();
        })

        calcularTotal();
    });

    function calcularTotal() {
        let total = 0;

        $("#tableOrdenes tr").each(function () {
            var row = $(this);
            var totalFila = parseFloat(row.find("td").eq(11).text());

            if (row.is(':visible')) {
                total += totalFila;
                console.log(totalFila.toString());
            }

        })

        $("#montoTotal").text("Total: S/. " + total.toFixed(2).toString());
    }

    calcularTotal();
});