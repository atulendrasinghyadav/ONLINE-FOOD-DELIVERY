document.getElementById('orderForm').addEventListener('submit', function (e) {
    e.preventDefault();

    // Collecting the values from the form
    const chefName = document.getElementById('foodItem').value;
    const foodDetails = document.getElementById('quantity').value.trim();
    const address = document.getElementById('address').value.trim();
    const errorElement = document.getElementById('error');
    const successElement = document.getElementById('success');

    // Clear previous messages
    errorElement.textContent = '';
    successElement.textContent = '';

    // Validation checks
    if (!chefName) {
        errorElement.textContent = 'Please select a chef.';
        return;
    }

    if (!foodDetails) {
        errorElement.textContent = 'Please provide details about the food and quantity.';
        return;
    }

    if (!address) {
        errorElement.textContent = 'Address is required for confirmation.';
        return;
    }

    // Display success message
    successElement.textContent = 'Chef ${chefName} has been booked successfully. Details: "${foodDetails}". Address: "${address}".';

    // Return to home page after 3 seconds
    setTimeout(() => {
        window.location.href = 'index.html';
    }, 3000);
});