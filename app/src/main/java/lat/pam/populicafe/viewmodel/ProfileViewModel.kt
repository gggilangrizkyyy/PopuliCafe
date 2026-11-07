
package lat.pam.populicafe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    var customerName by mutableStateOf("Rakyat Populi")
        private set

    var completedOrders by mutableIntStateOf(0)
        private set

    fun updateName(newName: String) {
        if (newName.isNotBlank()) {
            customerName = newName
        }
    }

    fun recordOrder(name: String) {
        if (name.isNotBlank()) {
            customerName = name
        }

        completedOrders++
    }
}
