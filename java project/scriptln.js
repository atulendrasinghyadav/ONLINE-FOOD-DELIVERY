document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value.trim();
    const emailError = document.getElementById('emailError');

    // Check if email contains any integers
    const emailHasInteger = /\d/.test(email);

    if (emailHasInteger) {
        emailError.textContent = "Email cannot contain numbers.";
        emailError.style.display = "block";
    } else {
        emailError.style.display = "none";
        // Proceed with form submission
        alert('Login successful!');
    }
    setTimeout(() => {
        window.location.href = 'index.html';
    }, 3000);
});