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

// Cerrar la ventana modal si se hace clic fuera del contenido de la modal
window.onclick = function(event) {
    var modal = document.getElementById('personalizacion');
    if (event.target == modal) {
        modal.style.display = 'none';
    }
}

// Validar el formulario al hacer clic en el botón de reservar
document.querySelector('.reservar-btn').addEventListener('click', function() {
    var form = document.getElementById('reservaForm');
    var celularInput = document.getElementById('celular');
    var correoInput = document.getElementById('correo');

    var celular = celularInput.value;
    var correo = correoInput.value;

    // Validar que todos los campos estén completos
    var inputs = form.querySelectorAll('input[required], select[required]');
    var isValid = true;

    for (var input of inputs) {
        if (!input.value.trim()) {
            isValid = false; // Detener el proceso si hay campos vacíos
            break;
        }
    }

    // Validar celular
    if (!/^\d{9}$/.test(celular)) {
        isValid = false; // Detener el proceso si el celular es inválido
    }

    // Validar correo
    if (!validateEmail(correo)) {
        isValid = false; // Detener el proceso si el correo es inválido
    }

    if (!isValid) {
        // Si alguna validación falla, no se envía el formulario
        return; // Detener el proceso
    }

    // Si todas las validaciones son correctas, abrir el modal
    abrirModal();
});

// Añadir evento para validar el celular al cambiar su valor
var celularInput = document.getElementById('celular');
if (celularInput) {
    celularInput.addEventListener('input', function() {
        validateInput(celularInput);
    });
}

// Añadir evento de clic al botón de reservar
document.querySelector('.reservar-btn').addEventListener('click', abrirModal);
