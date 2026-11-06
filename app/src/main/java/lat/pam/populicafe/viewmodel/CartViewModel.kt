package lat.pam.populicafe.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import lat.pam.populicafe.data.model.MenuItem

class CartViewModel : ViewModel() {

    private val _cart = mutableStateMapOf<String, Int>()

    val cart: Map<String, Int>
        get() = _cart

    val totalItems: Int
        get() = _cart.values.sum()

    fun getQuantity(item: MenuItem): Int {
        return _cart[item.name] ?: 0
    }

    fun addItem(item: MenuItem) {
        _cart[item.name] = getQuantity(item) + 1
    }

    fun decreaseItem(item: MenuItem) {
        val currentQuantity = getQuantity(item)

        if (currentQuantity <= 1) {
            _cart.remove(item.name)
        } else {
            _cart[item.name] = currentQuantity - 1
        }
    }

    fun removeItem(item: MenuItem) {
        _cart.remove(item.name)
    }

    fun clearCart() {
        _cart.clear()
    }

    fun getSubtotal(menuItems: List<MenuItem>): Int {
        return menuItems.sumOf { item ->
            item.price * getQuantity(item)
        }
    }
}