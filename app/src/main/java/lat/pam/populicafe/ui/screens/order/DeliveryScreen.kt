package lat.pam.populicafe.ui.screens.order

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import lat.pam.populicafe.data.model.MenuData
import lat.pam.populicafe.ui.screens.home.formatRupiah
import lat.pam.populicafe.ui.theme.*
import lat.pam.populicafe.viewmodel.CartViewModel

@Composable
fun DeliveryScreen(
    cartViewModel: CartViewModel,
    onPlaceOrder: (String) -> Unit,
    onBack: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var detail by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    val menuItems = MenuData.menuItems

    val cartItems = menuItems.filter {
        cartViewModel.getQuantity(it) > 0
    }

    val total = cartViewModel.getSubtotal(menuItems)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        TextButton(onClick = onBack) {
            Text(
                text = "← Kembali ke pesanan",
                color = PopuliTerracotta
            )
        }

        Text(
            text = "Alamat Pengiriman",
            style = MaterialTheme.typography.headlineLarge,
            color = PopuliEspresso
        )

        Text(
            text = "Mau kami antar ke mana?",
            color = PopuliTextSecondary
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Ringkasan Pesanan",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 190.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = PopuliCard
            )
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                items(cartItems) { item ->
                    val quantity = cartViewModel.getQuantity(item)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        horizontalArrangement =
                            Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${item.name} x$quantity",
                            modifier = Modifier.weight(1f),
                            color = PopuliEspresso
                        )

                        Text(
                            text = formatRupiah(
                                item.price * quantity
                            ),
                            fontWeight = FontWeight.Bold,
                            color = PopuliEspresso
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total Pesanan",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = formatRupiah(total),
                fontWeight = FontWeight.Bold,
                color = PopuliTerracotta
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Data Penerima",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = nama,
            onValueChange = {
                nama = it
                errorMessage = ""
            },
            label = { Text("Nama Lengkap") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = alamat,
            onValueChange = {
                alamat = it
                errorMessage = ""
            },
            label = { Text("Alamat Lengkap") },
            placeholder = {
                Text("Contoh: Jl. Merdeka No. 10, Bandung")
            },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = detail,
            onValueChange = {
                detail = it
                errorMessage = ""
            },
            label = { Text("Patokan / Detail Lokasi") },
            placeholder = {
                Text("Contoh: Rumah pagar hitam, dekat minimarket")
            },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                errorMessage = when {
                    cartItems.isEmpty() ->
                        "Keranjang pesanan masih kosong."

                    nama.isBlank() ->
                        "Nama penerima wajib diisi."

                    alamat.isBlank() ->
                        "Alamat pengiriman wajib diisi."

                    detail.isBlank() ->
                        "Tambahkan patokan lokasi."

                    else -> ""
                }

                if (errorMessage.isEmpty()) {
                    onPlaceOrder(nama)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PopuliEspresso
            )
        ) {
            Text(
                text = "Order dan Kirim",
                color = PopuliCream,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
