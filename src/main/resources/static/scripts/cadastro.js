document.addEventListener('DOMContentLoaded', function () {
    const signupForm = document.getElementById('signup-form');
    var messageElement = document.getElementById('message-cadastro');

    signupForm.addEventListener('submit', function (event) {
        event.preventDefault();

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        // Requisição para a API de cadastro
        fetch('http://34.227.58.30:8080/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ username, password })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Failed to signup');
                }
                return response.json();
            })
            .then(data => {
                messageElement.innerHTML = "Cadastro Realizado com Sucesso";
                document.getElementById('username').value = '';
                document.getElementById('password').value = '';
                window.location.href = 'login.html';
            })
            .catch(error => {
                console.error('Signup failed:', error);
                messageElement.innerHTML = "Usuário já cadastrado!";
            });
    });
});