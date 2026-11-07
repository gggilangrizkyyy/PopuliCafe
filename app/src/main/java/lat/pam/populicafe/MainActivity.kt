package lat.pam.populicafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import lat.pam.populicafe.navigation.PopuliApp
import lat.pam.populicafe.ui.theme.PopuliCoffeeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PopuliCoffeeTheme {
                PopuliApp()
            }
        }
    }
}
