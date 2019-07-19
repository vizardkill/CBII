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
        },
        error: function (response) {
            alert('Error interno con el servidor, intentalo de nuevo más tarde')
            console.log(response);
        }
    });




    $('#form_reg_sol').validate({
        rules: {
            form_reg_sol_fk_categoria: {required: true},
            form_reg_sol_fk_programa_academico: {required: true},
            form_reg_sol_descripcion_problema: {required: true},
            form_reg_sol_descripcion_peticion: {required: true}
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

});