new WOW().init();
var scroll = new SmoothScroll('a[href*="#"]');
var options = { speed: 1000, easing: 'easeOutQuint' };
scroll.animateScroll(options);


jQuery.validator.setDefaults({
    errorElement: 'p',
    errorPlacement: function (error, element) {
        error.addClass('invalid-feedback');
        element.closest('.md-form').append(error);
    },
    highlight: function (element, errorClass, validClass, error) {
        $(element).addClass('invalid');
    },
    unhighlight: function (element, errorClass, validClass) {
        $(element).removeClass('invalid');
    }
});

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

$(document).ready(function () {

    /** Se configura el Ajax para que permita redirigir las solicitudes a travez del servlet */
    $('#Login').validate({
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
                type: $("#Login").attr('method'),
                url: $("#Login").attr('action'),
                data: $("#Login").serialize(),
                dataType: "text",

                beforeSend: function () {
                    $('#load').removeClass('d-none').addClass('d-block');
                    $('#ingreso').removeClass('d-block').addClass('d-none');
                },
                success: function (response) {
                    if (response == 'false') {
                        $('#errorLogin').slideDown('slow').removeClass('d-none');
                        function error() {
                            $('#errorLogin').slideUp('slow');
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
                    $('#load').removeClass('d-block').addClass('d-none');
                    $('#ingreso').removeClass('d-none').addClass('d-block');
                }
            });
        }
    });
});




