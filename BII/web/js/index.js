//################################## Configuraciones de JQuery Validator
jQuery.validator.setDefaults({
    errorElement: 'p',
    errorPlacement: function (error, element) {
        error.addClass('invalid-feedback');
        element.closest('.md-form').append(error);
        element.closest('.form-group').append(error);
    },
    highlight: function (element, errorClass, validClass, error) {
        $(element).addClass('invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
        $(element).removeClass('invalid');
    }
});


//################################## Metodos Adicionales para JQuery Validator
$.validator.addMethod("especial", function (value) {
    return /[\@\#\$\%\^\&\*\(\)\_\+\!]/.test(value)
});
$.validator.addMethod("minuscula", function (value) {
    return /[a-z]/.test(value)
});
$.validator.addMethod("mayuscula", function (value) {
    return /[A-Z]/.test(value)
});
$.validator.addMethod("digito", function (value) {
    return /[0-9]/.test(value)
});
$.validator.addMethod("letras", function (value) {
    return /^[a-zA-Z]+(\s*[a-zA-Z]*)*[a-zA-Z]+$/.test(value)
});

$(document).ready(function () {

    /** Se configura el Ajax para que permita redirigir las solicitudes a travez del servlet */
    $('#form_login').validate({
        rules: {
            NICK_USER: { required: true },
            PASSWORD_USER: { required: true }
        },
        messages: {
            NICK_USER: {
                required: 'Por favor ingresa tu usuario'
            },
            PASSWORD_USER: { required: 'Por favor suministra tu contraseña' }
        },

        submitHandler: function () {

            $.ajax({
                type: $("#form_login").attr('method'),
                url: $("#form_login").attr('action'),
                data: $("#form_login").serialize(),
                dataType: "text",

                beforeSend: function () {
                    $('#icon_load').removeClass('d-none').addClass('d-block');
                    $('#btn_ingreso').removeClass('d-block').addClass('d-none');
                },
                success: function (response) {
                    if (response == 'false') {
                        $('#msg_error_form_login').slideDown('slow').removeClass('d-none');
                        function error() {
                            $('#msg_error_form_login').slideUp('slow');
                        } setTimeout(error, 4000);
                    } else {
                        window.location.href = "JSP/Administrador/Inicio.jsp";
                    }
                },
                error: function (response) {
                    console.log(response);
                    alert('Error con el servidor, por favor intentalo de nuevo mas tarde');
                },
                complete: function () {
                    $('#icon_load').removeClass('d-block').addClass('d-none');
                    $('#btn_ingreso').removeClass('d-none').addClass('d-block');
                }
            });
        }
    });


        //Validacion del Formulario para el registro de un usuario
        $('#Form_Registro_Usuario').validate({
            rules: {
                ID_PERFIL_USER: { required: true },
                NOMBRE_USER: { required: true, minlength: 3, maxlength: 20, letras: true },
                APELLIDOS_USER: { required: true, minlength: 5, maxlength: 20, letras: true },
                DOC_USER: {
                    required: true, minlength: 5, maxlength: 15,
                    remote: {
                        url: "../../Ingreso?Peticion=ValidarDocUsuario",
                        type: "GET",
                        data: {
                            DOC_USER: function () {
                                return $("#DOC_USER").val()
                            }
                        }
                    }
                },
                CORREO_USER: {
                    required: true, email: true,
                    remote: {
                        url: "../../Ingreso?Peticion=ValidarEmailUsuario",
                        type: "GET",
                        data: {
                            CORREO_USER: function () {
                                return $("#CORREO_USER").val();
                            }
                        }
                    }
                },
                R_NICK_USER: {
                    required: true, minlength: 4, maxlength: 10,
                    remote: {
                        url: "../../Ingreso?Peticion=ValidarNickUsuario",
                        type: "GET",
                        data: {
                            R_NICK_USER: function () {
                                return $("#R_NICK_USER").val();
                            }
                        }
                    }
                },
                R_PASSWORD_USER: { required: true, minlength: 8, maxlength: 20, especial: true, minuscula: true, mayuscula: true, digito: true },
                pwd: { required: true, equalTo: '#R_PASSWORD_USER' }
            },
            messages: {
                ID_PERFIL_USER: { required: 'Por favor seleccione un perfil' },
                NOMBRE_USER: {
                    required: 'El campo es requerido',
                    minlength: 'El campo debe contener un minimo de 3 caracteres',
                    maxlength: 'El campo solo puede contener un maximo de 20 caracteres',
                    letras: 'El campo no puede contener caracteres especiales ni números'
                },
                APELLIDOS_USER: {
                    required: 'El campo es requerido',
                    minlength: 'El campo debe contener un minimo de 3 caracteres',
                    maxlength: 'El campo solo puede contener un maximo de 20 caracteres',
                    letras: 'El campo no puede contener caracteres especiales ni números'
                },
                DOC_USER: {
                    required: 'El campo es requerido',
                    minlength: 'El campo debe contener un minimo de 5 caracteres',
                    maxlength: 'El campo solo puede contener un maximo de 15 caracteres',
                    remote: 'Este documento ya se encuentra en uso'
                },
                CORREO_USER: {
                    required: 'El campo es requerido',
                    email: 'El correo electronico introducido es incorrecto',
                    remote: 'Este correo ya se encuentra en uso'
                },
                R_NICK_USER: {
                    required: 'El campo es requerido',
                    minlength: 'El campo debe contener un minimo de 4 caracteres',
                    maxlength: 'El campo solo puede contener un maximo de 10 caracteres',
                    remote: 'Este nick ya se encuentra en uso por favor usa uno diferente'
                },
                R_PASSWORD_USER: {
                    required: 'La contraseña es obligatoria',
                    minlength: 'La contraseña debe ser de almenos 8 digitos',
                    maxlength: 'La contraseña no puede sobrepasar los 20 digitos',
                    especial: 'La contraseña debe contener almenos un caracter especial',
                    minuscula: 'La contraseña debe contener una letra minuscula',
                    mayuscula: 'La contraseña debe contener una letra mayuscula'
                },
                pwd: {
                    required: 'Es obligatorio que confirmes tu contraseña',
                    equalTo: 'Las contraseñas no coinciden'
                }
            },
    
            submitHandler: function () {
                $.ajax({
                    url: $("#Form_Registro_Usuario").attr('action'),
                    type: $("#Form_Registro_Usuario").attr('method'),
                    data: $("#Form_Registro_Usuario").serialize(),
                    dataType: "text",
    
                    beforeSend: function () {
                        $('#icon_load_usuario').removeClass('d-none').addClass('d-block');
                        $('#btn_registro_usuario').removeClass('d-block').addClass('d-none');
                    },
                    success: function (response) {
                        if (response == 'true') {
                            $('#msg_SucessRegistro_usuario').slideDown('slow').removeClass('d-none');
                            function ShowSucess() {
                                $('#msg_SucessRegistro_usuario').slideUp('slow');
                            } setTimeout(ShowSucess, 4000);
                            $("#Form_Registro_Usuario")[0].reset();
                        }
                    },
                    error: function (response) {
                        console.log(response);
                        alert('Error con el servidor, por favor intentalo de nuevo mas tarde');
                    },
                    complete: function () {
                        $('#icon_load_usuario').removeClass('d-block').addClass('d-none');
                        $('#btn_registro_usuario').removeClass('d-none').addClass('d-block');
                    }
                });
            }
        });
});




