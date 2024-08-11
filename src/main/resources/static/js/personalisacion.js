toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-center",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "60",
    "timeOut": "3500",
    "extendedTimeOut": "3500",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
};

// Función para validar el formato del correo electrónico
function validateEmail(email) {
    // Expresión regular para validar el formato del correo electrónico
    var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailPattern.test(email);
}

// Función para validar el input del celular
function validateInput(input) {
    // Reemplaza caracteres no numéricos
    input.value = input.value.replace(/[^0-9]/g, '');
}

// Abrir la ventana modal y establecer el valor del campo de destino turístico
function abrirModal() {
    // Obtener el título del paquete
    var titulo = document.querySelector('.paquete-info .titulo').innerText;

    // Establecer el valor del campo "Destino Turístico Seleccionado" con el título del paquete
    document.getElementById('destino').value = titulo;

    // Mostrar la ventana modal
    var modal = document.getElementById('personalizacion');
    modal.style.display = 'block';
}

// Cerrar la ventana modal al hacer clic en el botón de cierre
var closeBtn = document.querySelector('.personalizacion .close');
if (closeBtn) {
    closeBtn.onclick = function() {
        var modal = document.getElementById('personalizacion');
        modal.style.display = 'none';
    }
}

// Seleccionamos los elementos del DOM necesarios
var tipDocSelect = document.getElementById('tipDoc');
var documentoInput = document.getElementById('documento');

// Función para ajustar el campo de documento según el tipo de documento seleccionado
function adjustDocumentoInput() {
    if (tipDocSelect.value === 'DNI') {
        documentoInput.maxLength = 8;
        documentoInput.pattern = "\\d{8}";
        documentoInput.title = "Debe ingresar exactamente 8 dígitos para el DNI";
    } else if (tipDocSelect.value === 'Pasaporte') {
        documentoInput.maxLength = 20;
        documentoInput.pattern = "\\d{1,20}";
        documentoInput.title = "Debe ingresar un máximo de 20 dígitos para el Pasaporte";
    }
}

// Asignar la función adjustDocumentoInput al evento change del select
tipDocSelect.addEventListener('change', adjustDocumentoInput);

// Ejecutar la función al cargar la página para aplicar la configuración inicial
adjustDocumentoInput();

// Validar que solo se ingresen números en el campo de documento
documentoInput.addEventListener('input', function() {
    this.value = this.value.replace(/[^0-9]/g, '');
});

// Cerrar la ventana modal si se hace clic fuera del contenido de la modal
window.onclick = function(event) {
    var modal = document.getElementById('personalizacion');
    if (event.target == modal) {
        modal.style.display = 'none';
    }
}

// Añadir evento para validar el celular al cambiar su valor
var celularInput = document.getElementById('celular');
if (celularInput) {
    celularInput.addEventListener('input', function() {
        validateInput(celularInput);
    });
}

// Añadir evento de clic al botón de reservar
document.querySelector('.reservar-btn').addEventListener('click', abrirModal);

document.getElementById('documento').addEventListener('input', function (event) {
    let value = event.target.value;
    // Eliminar cualquier carácter que no sea un dígito
    event.target.value = value.replace(/\D/g, '');
});

document.getElementById('contacto_reserva').addEventListener('click', function() {
    var celularInput = document.getElementById('celular');
    var correoInput = document.getElementById('correo');
    var celular = celularInput.value.trim();
    var correo = correoInput.value.trim();

    // Obtener datos del formulario y aplicar trim()
    var destino = document.getElementById('destino').value.trim();
    var nombres = document.getElementById('nombres').value.trim();
    var apellidos = document.getElementById('apellidos').value.trim();
    var numDocumento = document.getElementById('documento').value.trim();
    var fechaPartida = document.getElementById('fecha').value.trim();
    var tipoViaje = document.getElementById('tipoViaje').value.trim();

    // Validar los campos
    if (!validateEmail(correo)) {
        toastr.warning('Correo electrónico inválido.');
        return;
    }
    if (celular.length < 7) {
        toastr.warning('Número de celular inválido.');
        return;
    }
    if (!destino || !nombres || !apellidos || !numDocumento || !fechaPartida || !tipoViaje) {
        toastr.warning('Todos los campos son obligatorios.');
        return;
    }

    // Crear objeto JSON
    var data = {
        destino: destino,
        nombres: nombres,
        apellidos: apellidos,
        correo: correo,
        celular: celular,
        numDocumento: numDocumento,
        fechaPartida: fechaPartida,
        tipoViaje: tipoViaje
    };
    console.log(data)

    // Enviar datos del formulario
    axios.post('http://localhost:8090/user/guardar', data)
        .then(response => {
            toastr.success(response.data);

            setTimeout(function() {
                location.reload();
            }, 3500);
        })
        .catch(error => {
            toastr.error('Error al guardar la reserva.');
            console.error(error);
        });
});


