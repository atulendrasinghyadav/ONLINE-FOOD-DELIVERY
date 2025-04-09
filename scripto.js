document.getElementById('orderForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const foodItem = document.getElementById('foodItem').value;
    const quantity = parseInt(document.getElementById('quantity').value, 10);
    const address = document.getElementById('address').value.trim();
    const errorElement = document.getElementById('error');
    const successElement = document.getElementById('success');

    errorElement.textContent = '';
    successElement.textContent = '';

    if (!foodItem) {
        errorElement.textContent = 'Please select a food item.';
        return;
    }

    if (!quantity || quantity <= 0) {
        errorElement.textContent = 'Please enter a valid quantity.';
        return;
    }

    if (!address) {
        errorElement.textContent = 'Address is required for delivery.';
        return;
    }

    successElement.textContent = 'Order placed successfully for ${quantity} ${foodItem}(s). It will be delivered to "${address}".';

    // Return to home page after 3 seconds
    setTimeout(() => {
        window.location.href = 'index.html';
    }, 3000);
});