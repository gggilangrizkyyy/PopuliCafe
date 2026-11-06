package lat.pam.populicafe.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import lat.pam.populicafe.data.model.MenuData
import lat.pam.populicafe.data.model.MenuItem
import lat.pam.populicafe.ui.theme.*
import lat.pam.populicafe.viewmodel.CartViewModel
import androidx.compose.foundation.clickable

import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeScreen( cartViewModel: CartViewModel,
                onOpenCart: () -> Unit) {
    val menuItems = MenuData.menuItems

    var selectedCategory by remember {
        mutableStateOf("All")
    }

    val categories = listOf("All", "Drinks", "Snacks", "Meals")

    val filteredMenu = if (selectedCategory == "All") {
        menuItems
    } else {
        menuItems.filter {
            it.category == selectedCategory
        }
    }

    val cartCount = cartViewModel.totalItems

    val cartTotal = cartViewModel.getSubtotal(menuItems)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "POPULI COFFEE",
            style = MaterialTheme.typography.titleLarge,
            color = PopuliTerracotta,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ngopi dan nyemil, yuk!",
            style = MaterialTheme.typography.headlineLarge,
            color = PopuliEspresso
        )

        Text(
            text = "Temukan menu favoritmu hari ini.",
            style = MaterialTheme.typography.bodyMedium,
            color = PopuliTextSecondary
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Filter kategori menu
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = {
                        selectedCategory = category
                    },
                    label = {
                        Text(
                            if (category == "All") "Semua" else category
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Informasi keranjang
        Card(
            modifier = Modifier.fillMaxWidth().clickable {
                onOpenCart()
            },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = PopuliEspresso
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Keranjang",
                        color = PopuliWhite,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "$cartCount item",
                        color = PopuliCream
                    )
                }

                Text(
                    text = formatRupiah(cartTotal),
                    color = PopuliGold,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Menu Kami",
            style = MaterialTheme.typography.headlineMedium,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Daftar menu
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = filteredMenu,
                key = { it.name }
            ) { item ->
                MenuCard(
                    item = item,
                    quantity = cartViewModel.getQuantity(item),
                    onAdd = {
                        cartViewModel.addItem(item)
                    }
                )
            }
        }
    }
}

@Composable
fun MenuCard(
    item: MenuItem,
    quantity: Int,
    onAdd: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = PopuliCard
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium,
                    color = PopuliEspresso,
                    fontWeight = FontWeight.Bold
                )

                if (item.isMerakyat) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = PopuliSage
                    ) {
                        Text(
                            text = "Merakyat",
                            modifier = Modifier.padding(
                                horizontal = 8.dp,
                                vertical = 4.dp
                            ),
                            color = PopuliEspresso,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium,
                color = PopuliTextSecondary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = item.category,
                        style = MaterialTheme.typography.labelSmall,
                        color = PopuliTextSecondary
                    )

                    Text(
                        text = formatRupiah(item.price),
                        style = MaterialTheme.typography.titleMedium,
                        color = PopuliTerracotta,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = onAdd,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PopuliTerracotta
                    )
                ) {
                    Text(
                        if (quantity == 0) "Tambah" else "Tambah ($quantity)"
                    )
                }
            }
        }
    }
}

fun formatRupiah(amount: Int): String {
    val formatter = NumberFormat.getCurrencyInstance(
        Locale("id", "ID")
    )

    formatter.maximumFractionDigits = 0
    formatter.minimumFractionDigits = 0

    return formatter.format(amount)
}