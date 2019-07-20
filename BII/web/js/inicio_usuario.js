//################################## Configuraciones de JQuery Validator
jQuery.validator.setDefaults({
    errorElement: 'p',
    errorPlacement: function (error, element) {
        error.addClass('invalid-feedback');
        element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass, error) {
        $(element).addClass('is-invalid').removeClass('is-valid');
    },
    unhighlight: function (element, errorClass, validClass) {
        $(element).removeClass('is-invalid').addClass('is-valid');
    },
    /*success: function(label) {
        label
          .text('OK!').addClass('valid-feedback').removeClass('invalid-feedback')
          .closest('.form-group')
    }*/
});

$(document).ready(function () {
    //Carga las categorias de solicitudes en el elemento Select del Formulario de Creación de Solicitudes
    $.ajax({
        type: "GET",
        url: "../../Data?Peticion=data_categorias_solicitudes",
        dataType: "json",

        success: function (Data) {
            $.each(Data.CATEGORIAS_SOLICITUDES, function (i, item) {
                $("#form_reg_sol_fk_categoria").append('<option value=' + item.pk_id + '>' + item.nombre + '</option>');
            });

            $.each(Data.CATEGORIAS_SOLICITUDES, function (i, item) {
                $("#form_edit_sol_fk_categoria").append('<option value=' + item.pk_id + '>' + item.nombre + '</option>');
            });
        },
        error: function (response) {
            alert('Error interno con el servidor, intentalo de nuevo más tarde')
            console.log(response);
        }
    });

    //Carga los programas academicos en el elemento Select del Formulario de Creación de Solicitudes
    $.ajax({
        type: "GET",
        url: "../../Data?Peticion=data_programas_academicos",
        dataType: "json",

        success: function (Data) {
            $.each(Data.PROGRAMAS_ACADEMICOS, function (i, item) {
                $("#form_reg_sol_fk_programa_academico").append('<option value=' + item.pk_id + '>' + item.nombre + '</option>');
            });

            $.each(Data.PROGRAMAS_ACADEMICOS, function (i, item) {
                $("#form_edit_sol_fk_programa_academico").append('<option value=' + item.pk_id + '>' + item.nombre + '</option>');
            });
        },
        error: function (response) {
            alert('Error interno con el servidor, intentalo de nuevo más tarde')
            console.log(response);
        }
    });

    //Validacion de Formulario para el registro de Solicitudes
    $('#form_reg_sol').validate({
        rules: {
            form_reg_sol_fk_categoria: { required: true },
            form_reg_sol_fk_programa_academico: { required: true },
            form_reg_sol_titulo: { required: true },
            form_reg_sol_descripcion_problema: { required: true },
            form_reg_sol_descripcion_peticion: { required: true }
        },
        messages: {
            form_reg_sol_fk_categoria: {
                required: 'El campo es requerido'
            },
            form_reg_sol_fk_programa_academico: {
                required: 'El campo es requerido'
            },
            form_reg_sol_descripcion_problema: {
                required: 'El campo es requerido'
            },
            form_reg_sol_descripcion_peticion: {
                required: 'El campo es requerido'
            },
            form_reg_sol_titulo: {
                required: 'El campo es requerido'
            }
        },

        submitHandler: function () {
            $.ajax({
                url: $("#form_reg_sol").attr('action'),
                type: $("#form_reg_sol").attr('method'),
                data: $("#form_reg_sol").serialize(),
                dataType: "text",

                beforeSend: function () {
                    $('#icon_load_form_reg_sol').removeClass('d-none').addClass('d-block');
                    $('#btn_submit_form_reg_sol').removeClass('d-block').addClass('d-none');
                },
                success: function (response) {
                    if (response == 'true') {

                        $("#form_reg_sol")[0].reset();
                        $("#form_reg_sol .form-control").removeClass('is-valid');


                        $('#mod_form_reg_sol').modal('hide');
                        $('#mod_sucess').modal('show');
                        $('#table_solicitudes').DataTable().ajax.reload();
                        $('#mod_sucess_text').text('Solicitud enviada con éxito');

                        function ShowSucess() {
                            $('#mod_sucess').modal('hide');
                        } setTimeout(ShowSucess, 4000);

                    }
                },
                error: function (response) {
                    console.log(response);
                    alert('Error con el servidor, por favor intentalo de nuevo mas tarde');
                },
                complete: function () {
                    $('#icon_load_form_reg_sol').removeClass('d-block').addClass('d-none');
                    $('#btn_submit_form_reg_sol').removeClass('d-none').addClass('d-block');
                }
            });
        }
    })

    //Validacion de Formulario para el registro de Solicitudes
    $('#form_edit_sol').validate({
        rules: {
            form_edit_sol_fk_categoria: { required: true },
            form_edit_sol_fk_programa_academico: { required: true },
            form_edit_sol_titulo: { required: true },
            form_edit_sol_descripcion_problema: { required: true },
            form_edit_sol_descripcion_peticion: { required: true }
        },
        messages: {
            form_edit_sol_fk_categoria: {
                required: 'El campo es requerido'
            },
            form_edit_sol_fk_programa_academico: {
                required: 'El campo es requerido'
            },
            form_edit_sol_descripcion_problema: {
                required: 'El campo es requerido'
            },
            form_edit_sol_descripcion_peticion: {
                required: 'El campo es requerido'
            },
            form_edit_sol_titulo: {
                required: 'El campo es requerido'
            }
        },

        submitHandler: function () {
            $.ajax({
                url: $("#form_edit_sol").attr('action'),
                type: $("#form_edit_sol").attr('method'),
                data: $("#form_edit_sol").serialize(),
                dataType: "text",

                beforeSend: function () {
                    $('#icon_load_form_edit_sol').removeClass('d-none').addClass('d-block');
                    $('#btn_submit_form_edit_sol').removeClass('d-block').addClass('d-none');
                },
                success: function (response) {
                    if (response == 'true') {

                        $("#form_edit_sol")[0].reset();
                        $("#form_edit_sol .form-control").removeClass('is-valid');


                        $('#mod_form_edit_sol').modal('hide');
                        $('#mod_sucess').modal('show');
                        $('#table_solicitudes').DataTable().ajax.reload();
                        $('#mod_sucess_text').text('Solicitud modificada con éxito');

                        function ShowSucess() {
                            $('#mod_sucess').modal('hide');
                        } setTimeout(ShowSucess, 4000);

                    }
                },
                error: function (response) {
                    console.log(response);
                    alert('Error con el servidor, por favor intentalo de nuevo mas tarde');
                },
                complete: function () {
                    $('#icon_load_form_edit_sol').removeClass('d-block').addClass('d-none');
                    $('#btn_submit_form_edit_sol').removeClass('d-none').addClass('d-block');
                }
            });
        }
    })

    //Confirmacion del Formulario para la eliminacion de una Materia
    $("#mod_form_elim_solicitud").submit(function (e) {
        e.preventDefault();
        $.ajax({
            type: $('#form_elim_solicitud').attr('method'),
            url: $('#form_elim_solicitud').attr('action'),
            data: $('#form_elim_solicitud').serialize(),
            dataType: "text",

            beforeSend: function () {
                $('#icon_load_form_elim_solicitud').removeClass('d-none').addClass('d-block');
                $('#btn_submit_form_elim_solicitud').removeClass('d-block').addClass('d-none');
                $('#btn_cancel_form_elim_solicitud').removeClass('d-block').addClass('d-none');
            },
            success: function (response) {
                if (response == 'true') {
                    $('#mod_form_elim_solicitud').modal('hide');
                    $('#table_solicitudes').DataTable().ajax.reload();
                    $('#mod_sucess').modal('show');
                    $('#mod_sucess_text').text('Materia eliminada con éxito');
                    function ShowSucess() {
                        $('#mod_sucess').modal('hide');
                    } setTimeout(ShowSucess, 2000);
                }
            },
            error: function (response) {
                console.log(response);
                alert('Error con el servidor, por favor intentalo de nuevo mas tarde');
            },
            complete: function () {
                $('#icon_load_form_elim_solicitud').removeClass('d-block').addClass('d-none');
                $('#btn_submit_form_elim_solicitud').removeClass('d-none').addClass('d-block');
                $('#btn_cancel_form_elim_solicitud').removeClass('d-none').addClass('d-block');
            }
        });
    });

    //################################## Seccion extendida para adicionar configuracion a la Tabla de Solicitudes

    //Tabla de Solicitudes
    var table_solicitudes = $('#table_solicitudes').DataTable({
        language: {
            sProcessing: "Procesando...",
            sLengthMenu: "Mostrar _MENU_  Registros",
            sZeroRecords: "No se encontraron resultados",
            sEmptyTable: "Ningún dato disponible en esta tabla",
            sInfo: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            sInfoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
            sInfoFiltered: "(filtrado de un total de _MAX_ registros)",
            sInfoPostFix: "",
            sSearch: "Buscar:",
            sUrl: "",
            sInfoThousands: ",",
            sLoadingRecords: "Cargando...",
            oPaginate: {
                sFirst: "Primero",
                sLast: "Último",
                sNext: "Siguiente",
                sPrevious: "Anterior"
            },
            oAria: {
                sSortAscending: ": Activar para ordenar la columna de manera ascendente",
                sSortDescending: ": Activar para ordenar la columna de manera descendente"
            }
        },
        ajax: {
            method: "GET",
            url: "../../Data?Peticion=data_solicitudes_usuarios",
            dataSrc: "v_Solicitudes_Usuarios"
        },
        select: "single",
        columns: [
            {
                className: 'details-control',
                orderable: false,
                data: null,
                defaultContent: '',
                render: function () {
                    return '<i class="fa fa-plus-square" aria-hidden="true"></i>';
                },
                width: '15px'
            },
            { data: "fecha_creacion" },
            { data: "titulo" },
            { data: "descripcion_problema" },
            { data: "descripcion_peticion" },
            {
                orderable: false,
                data: null,
                defaultContent: '',
                render: function () {
                    return '<div class="btn-group btn-group-sm" role="group" aria-label="Botones de Accion"> ' +
                        '<button id="btn_elim_solicitud" type="button" class="btn btn-sm danger-color" title="Eliminar"><i class="fas fa-trash"></i></button>' +
                        '<button id="btn_mod_solicitud" type="button" class="btn btn-sm success-color" title="Modificar"><i class="fas fa-marker"></i></button>' +
                        '</div>';
                }
            }
        ],
        order: [[1, 'asc']],
        dom: 'Bfrtip',
        buttons: [
            {
                extend: 'excelHtml5',
                text: '<i class="fa fa-file-excel"></i><span> Generar Informe</span>',
                titleAttr: 'Excel',
                className: 'btn-sm',
                action: function (e, dt, node, config) {
                    $('#Table_Facultad').DataTable().ajax.reload();

                    $.fn.DataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
                }
            }
        ]
    });
    //Script para ampliar la informacion de la tabla Solicitudes
    $('#table_solicitudes tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var tdi = tr.find('i.fa');
        var row = table_solicitudes.row(tr);

        if (row.child.isShown()) {

            row.child.hide();
            tr.removeClass('shown');
            tdi.first().removeClass('fa-minus-square');
            tdi.first().addClass('fa-plus-square');

        } else {

            row.child(table_solicitudes_Format(row.data())).show();
            tr.addClass('shown');
            tdi.first().removeClass('fa-plus-square');
            tdi.first().addClass('fa-minus-square');
        }
    });
    table_solicitudes.on('user-select', function (e, dt, type, cell, originalEvent) {
        if ($(cell.node()).hasClass('details-control')) {
            e.preventDefault();
        }
    });
    function table_solicitudes_Format(d) {

        return '<table class="w-100">' +
            '<tr>' +
            '<td><b>Estado de la Solicitud:</b></td>' +
            '<td>' + d.fk_estado + '</td>' +
            '</tr>' +
            '<tr>' +
            '<tr>' +
            '<tr>' +
            '<td><b>Programa Academico:</b></td>' +
            '<td>' + d.fk_programa_academico + '</td>' +
            '</tr>' +
            '<tr>' +
            '<tr>' +
            '<td><b>Categoria:</b></td>' +
            '<td>' + d.fk_categoria + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Solución:</b></td>' +
            '<td>' + d.descripcion_solucion + '</td>' +
            '</tr>' +
            '</table>';
    }


    //Script para ejecutar la eliminacion y modificacion de los registros en la Tabla Solicitudes
    $(document).on('click', "#btn_elim_solicitud", function () {
        var data = table_solicitudes.row($(this).parents('tr')).data();

        $('#msg_form_elim_solicitud').text('¿Estas seguro de eliminar esta solicitud, con numero ' + data.pk_id + '?');
        $('#form_elim_pk_id').val(data.pk_id);

        $('#mod_form_elim_solicitud').modal('show');
    });

    $(document).on('click', "#btn_mod_solicitud", function () {
        var data = table_solicitudes.row($(this).parents('tr')).data();

        $('#form_edit_sol_titulo').val(data.titulo);
        $('#form_edit_sol_descripcion_problema').val(data.descripcion_problema);
        $('#form_edit_sol_descripcion_peticion').val(data.descripcion_peticion);
        $('#form_edit_sol_pk_id').val(data.pk_id);

        $('#mod_form_edit_sol').modal('show');
    });


});