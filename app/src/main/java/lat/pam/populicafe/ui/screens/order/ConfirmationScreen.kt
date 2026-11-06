package lat.pam.populicafe.ui.screens.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import lat.pam.populicafe.ui.theme.*

@Composable
fun ConfirmationScreen(
    customerName: String,
    onFinish: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PopuliEspresso)
            .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .size(110.dp)
                .background(
                    color = PopuliGold,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✓",
                color = PopuliEspresso,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = "Populi Coffee",
            style = MaterialTheme.typography.headlineMedium,
            color = PopuliCream,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Halo, $customerName!",
            style = MaterialTheme.typography.headlineLarge,
            color = PopuliGold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Pesanan Berhasil!",
            style = MaterialTheme.typography.titleLarge,
            color = PopuliCream,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Suaramu sudah didengar. Terima kasih sudah memesan, tunggu aja sebentar, kurir kami segera mengantarkan pesananmu!",
            color = PopuliCream,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Vox populi, vox caffeine",
            color = PopuliGold,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = onFinish,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PopuliCream
            )
        ) {
            Text(
                text = "Oke",
                color = PopuliEspresso,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
