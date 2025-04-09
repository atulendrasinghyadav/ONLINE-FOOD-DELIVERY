document.getElementById('signup-form').addEventListener('submit', function (e) {
    e.preventDefault(); // Prevent form submission

    // Input fields
    const firstName = document.getElementById('first-name');
    const lastName = document.getElementById('last-name');
    const email = document.getElementById('email');

    // Error messages
    const firstNameError = document.getElementById('first-name-error');
    const lastNameError = document.getElementById('last-name-error');
    const emailError = document.getElementById('email-error');

    // Validation flags
    let isValid = true;

    // Validate first name (no numbers allowed)
    if (!/^[a-zA-Z]+$/.test(firstName.value)) {
        firstNameError.textContent = "Invalid value: Only letters are allowed.";
        firstNameError.style.display = "block";
        isValid = false;
    } else {
        firstNameError.style.display = "none";
    }

    // Validate last name (no numbers allowed)
    if (!/^[a-zA-Z]+$/.test(lastName.value)) {
        lastNameError.textContent = "Invalid value: Only letters are allowed.";
        lastNameError.style.display = "block";
        isValid = false;
    } else {
        lastNameError.style.display = "none";
    }

    // Validate email
    if (!/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/.test(email.value)) {
        emailError.textContent = "Invalid value: Enter a valid email.";
        emailError.style.display = "block";
        isValid = false;
    } else {
        emailError.style.display = "none";
    }

    // If valid, submit the form (you can add additional actions here)
    if (isValid) {
        alert('Form submitted successfully!');
        // Example: send data to server
    }
    setTimeout(() => {
        window.location.href = 'index.html';
    }, 3000);
});