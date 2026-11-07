
package lat.pam.populicafe.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import lat.pam.populicafe.ui.theme.*
import lat.pam.populicafe.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel
) {
    var nama by remember {
        mutableStateOf(profileViewModel.customerName)
    }

    var saveMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Halo, ${profileViewModel.customerName}!",
            style = MaterialTheme.typography.headlineMedium,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Profile Saya",
            style = MaterialTheme.typography.headlineLarge,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Profile Setting",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = nama,
            onValueChange = {
                nama = it
                saveMessage = ""
            },
            label = { Text("Nama Lengkap") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (nama.isNotBlank()) {
                    profileViewModel.updateName(nama.trim())
                    saveMessage = "Profil berhasil diperbarui!"
                } else {
                    saveMessage = "Nama tidak boleh kosong."
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
                text = "Save",
                color = PopuliCream,
                fontWeight = FontWeight.Bold
            )
        }

        if (saveMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = saveMessage,
                color = PopuliTerracotta
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Aktivitas Saya",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PopuliCard
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Pesanan Selesai",
                        color = PopuliTextSecondary,
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = profileViewModel.completedOrders.toString(),
                        color = PopuliEspresso,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = PopuliCard
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Status Akun",
                        color = PopuliTextSecondary,
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Aktif",
                        color = PopuliTerracotta,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Terima kasih sudah menjadi bagian dari Populi Coffee ☕",
            color = PopuliTextSecondary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
