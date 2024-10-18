document.addEventListener('DOMContentLoaded', function () {
    const VAT_RATE = 0.15;
    let cart = JSON.parse(localStorage.getItem('cart')) || [];

    // Function to calculate total price, VAT, and discount
    function calculateTotal() {
        let totalAmount = 0;
        let discount = 0;

        // Calculate base total
        cart.forEach(item => totalAmount += item.price);

        // Apply discount: 5% for every item above 2
        if (cart.length > 2) {
            discount = Math.min((cart.length - 2) * 0.05, 0.5);  // Cap discount at 50%
            totalAmount = totalAmount * (1 - discount);
        }

        const vatAmount = totalAmount * VAT_RATE;
        const finalAmount = totalAmount + vatAmount;
        return { totalAmount, vatAmount, finalAmount, discount };
    }

    // Function to update cart display
    function updateCartDisplay() {
        const cartItemsContainer = document.getElementById('items');
        cartItemsContainer.innerHTML = '';  // Clear current items

        let { totalAmount, vatAmount, finalAmount, discount } = calculateTotal();

        // Populate cart items
        cart.forEach(item => {
            const itemElement = document.createElement('tr');
            itemElement.innerHTML = `
                <td>${item.course}</td>
                <td>R${item.price.toFixed(2)}</td>
            `;
            cartItemsContainer.appendChild(itemElement);
        });

        // Update totals
        document.getElementById('total-price').textContent = `R${totalAmount.toFixed(2)}`;
        document.getElementById('vat-amount').textContent = `R${vatAmount.toFixed(2)}`;
        document.getElementById('final-amount').textContent = `R${finalAmount.toFixed(2)}`;
        
        // Show discount information if applicable
        if (discount > 0) {
            document.getElementById('discount-info').textContent = `Discount applied: ${(discount * 100).toFixed(0)}%`;
        } else {
            document.getElementById('discount-info').textContent = '';  // Clear discount info if no discount
        }
    }

    // Update the cart display when page loads
    updateCartDisplay();
});
