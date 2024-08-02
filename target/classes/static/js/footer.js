 function submitForm(event) {
        event.preventDefault(); // Evitar que se envíe el formulario automáticamente

        // Obtener los valores del formulario
        const fullname = document.getElementById('fullname').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;
        const message = document.getElementById('message').value;

        // Construir el objeto de datos a enviar al servidor
        const formData = {
            fullname: fullname,
            email: email,
            phone: phone,
            message: message
        };

        // Realizar la solicitud AJAX para enviar los datos
        fetch('/contact/send', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Manejar la respuesta del servidor aquí
            console.log('Respuesta del servidor:', data);
            // Ejemplo: mostrar un mensaje de éxito al usuario
            alert('¡Mensaje enviado correctamente!');
            // O redirigir a una página de éxito
            window.location.href = '/contact/success';
        })
        .catch(error => {
            // Manejar errores de red u otros errores
            console.error('Hubo un problema con la solicitud fetch:', error);
            // Ejemplo: mostrar un mensaje de error al usuario
            alert('Hubo un problema al enviar el mensaje. Por favor, inténtelo nuevamente.');
        });
    }