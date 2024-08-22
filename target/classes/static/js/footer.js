 function submitForm(event) {
        event.preventDefault(); // Evitar que se envíe el formulario automáticamente

        const fullname = document.getElementById('fullname').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;
        const message = document.getElementById('message').value;

        const formData = {
            fullname: fullname,
            email: email,
            phone: phone,
            message: message
        };

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
            alert('¡Mensaje enviado correctamente!');
            window.location.href = '/contact/success';
        })
        .catch(error => {
            // Manejar errores de red u otros errores
            console.error('Hubo un problema con la solicitud fetch:', error);
            // Ejemplo: mostrar un mensaje de error al usuario
            alert('Hubo un problema al enviar el mensaje. Por favor, inténtelo nuevamente.');
        });
    }