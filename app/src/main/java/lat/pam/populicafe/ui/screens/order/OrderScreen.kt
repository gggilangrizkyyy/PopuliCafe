package lat.pam.populicafe.ui.screens.order

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import lat.pam.populicafe.data.model.MenuData
import lat.pam.populicafe.data.model.MenuItem
import lat.pam.populicafe.viewmodel.CartViewModel
import lat.pam.populicafe.ui.screens.home.formatRupiah
import lat.pam.populicafe.ui.theme.*

@Composable
fun OrderScreen(
    cartViewModel: CartViewModel,
    onCheckout: () -> Unit
) {
    val menuItems = MenuData.menuItems

    val cartItems = menuItems.filter {
        cartViewModel.getQuantity(it) > 0
    }

    val subtotal = cartViewModel.getSubtotal(menuItems)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Pesanan Saya",
            style = MaterialTheme.typography.headlineLarge,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${cartViewModel.totalItems} item dalam keranjang",
            color = PopuliTextSecondary
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (cartItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Keranjang masih kosong",
                        style = MaterialTheme.typography.titleLarge,
                        color = PopuliEspresso
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Yuk, pilih menu favoritmu!",
                        color = PopuliTextSecondary
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = cartItems,
                    key = { it.name }
                ) { item ->
                    CartItemCard(
                        item = item,
                        quantity = cartViewModel.getQuantity(item),
                        onIncrease = {
                            cartViewModel.addItem(item)
                        },
                        onDecrease = {
                            cartViewModel.decreaseItem(item)
                        },
                        onRemove = {
                            cartViewModel.removeItem(item)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = PopuliCard
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Subtotal")

                        Text(
                            text = formatRupiah(subtotal),
                            fontWeight = FontWeight.Bold,
                            color = PopuliTerracotta
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = onCheckout,
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PopuliTerracotta
                        )
                    ) {
                        Text("Lanjut Checkout")
                    }
                }
            }
        }
    }
}

@Composable
fun CartItemCard(
    item: MenuItem,
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = PopuliCard
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = PopuliEspresso
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = formatRupiah(item.price),
                color = PopuliTerracotta
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(onClick = onDecrease) {
                        Text("-")
                    }

                    Text(
                        text = quantity.toString(),
                        modifier = Modifier.padding(horizontal = 12.dp),
                        fontWeight = FontWeight.Bold
                    )

                    OutlinedButton(onClick = onIncrease) {
                        Text("+")
                    }
                }

                TextButton(onClick = onRemove) {
                    Text(
                        text = "Hapus",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            Text(
                text = "Total: ${formatRupiah(item.price * quantity)}",
                fontWeight = FontWeight.Bold,
                color = PopuliEspresso
            )
        }
    }
}