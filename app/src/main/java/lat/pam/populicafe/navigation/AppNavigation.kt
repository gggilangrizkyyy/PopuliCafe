
package lat.pam.populicafe.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import lat.pam.populicafe.ui.theme.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.foundation.text.KeyboardOptions
import lat.pam.populicafe.ui.screens.home.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import lat.pam.populicafe.viewmodel.CartViewModel
import lat.pam.populicafe.ui.screens.order.OrderScreen
import android.net.Uri
import androidx.navigation.NavType
import androidx.navigation.navArgument

import lat.pam.populicafe.ui.screens.order.DeliveryScreen
import lat.pam.populicafe.ui.screens.order.ConfirmationScreen

// ==========================================
// 1. APP ROUTE
// ==========================================

object AppRoute {
    const val SPLASH = "splash"
    const val SIGN_UP = "sign_up"
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"
    const val ORDER = "order"
    const val DELIVERY = "delivery"
    const val CONFIRMATION = "confirmation/{customerName}"
}

// ==========================================
// 2. NAVIGATION CONTROLLER
// ==========================================

@Composable
fun PopuliApp() {

    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppRoute.SPLASH
    ) {

        composable(AppRoute.SPLASH) {
            SplashScreen(navController)
        }

        composable(AppRoute.SIGN_UP) {
            SignUpScreen(navController)
        }

        composable(AppRoute.LOGIN) {
            LoginScreen(navController)
        }

        composable(AppRoute.REGISTER) {
            RegisterScreen(navController)
        }

        composable(AppRoute.HOME) {
            HomeScreen(
                cartViewModel = cartViewModel,
                onOpenCart = {
                    navController.navigate(AppRoute.ORDER)
                }
            )
        }

        composable(AppRoute.ORDER) {
            OrderScreen(
                cartViewModel = cartViewModel,
                onCheckout = {
                    navController.navigate(AppRoute.DELIVERY)
                }
            )
        }

        composable(AppRoute.DELIVERY) {
            DeliveryScreen(
                cartViewModel = cartViewModel,
                onBack = {
                    navController.popBackStack()
                },
                onPlaceOrder = { customerName ->
                    navController.navigate(
                        "confirmation/${Uri.encode(customerName)}"
                    )
                }
            )
        }

        composable(
            route = AppRoute.CONFIRMATION,
            arguments = listOf(
                navArgument("customerName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val customerName =
                backStackEntry.arguments?.getString("customerName")
                    ?: "Rakyat Populi"

            ConfirmationScreen(
                customerName = customerName,
                onFinish = {
                    cartViewModel.clearCart()

                    navController.popBackStack(
                        route = AppRoute.HOME,
                        inclusive = false
                    )
                }
            )
        }
    }
}

// ==========================================
// 3. SPLASH SCREEN
// ==========================================

@Composable
fun SplashScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PopuliEspresso)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "☕",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Populi Coffee",
            style = MaterialTheme.typography.headlineLarge,
            color = PopuliCream
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Vox populi, vox caffeine",
            color = PopuliGold,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(80.dp))

        PopuliButton(
            text = "Start now",
            onClick = {
                navController.navigate(AppRoute.SIGN_UP)
            },
            backgroundColor = PopuliCream,
            textColor = PopuliEspresso
        )
    }
}

// ==========================================
// 4. SIGN UP SCREEN
// ==========================================

@Composable
fun SignUpScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PopuliCream)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Populi Coffee",
            style = MaterialTheme.typography.headlineLarge,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Satu suara, satu cangkir.",
            style = MaterialTheme.typography.headlineMedium,
            color = PopuliEspresso
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Daftar dan nikmati kopi serta camilan favoritmu.",
            color = PopuliTextSecondary
        )

        Spacer(modifier = Modifier.height(40.dp))

        PopuliButton(
            text = "Gabung jadi rakyat",
            onClick = {
                navController.navigate(AppRoute.REGISTER)
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        PopuliButton(
            text = "Saya sudah jadi rakyat",
            onClick = {
                navController.navigate(AppRoute.LOGIN)
            },
            outlined = true
        )
    }
}

// ==========================================
// 5. LOGIN SCREEN
// ==========================================

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Selamat Datang Kembali",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Masuk untuk melanjutkan pesananmu.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                errorMessage = when {
                    email.isBlank() -> "Email wajib diisi."
                    !android.util.Patterns.EMAIL_ADDRESS
                        .matcher(email).matches() -> "Format email tidak valid."
                    password.isBlank() -> "Password wajib diisi."
                    else -> ""
                }

                if (errorMessage.isEmpty()) {
                    navController.navigate(AppRoute.HOME)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Masuk")
        }

        TextButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali")
        }
    }
}
// ==========================================
// 6. REGISTER SCREEN
// ==========================================

@Composable
fun RegisterScreen(navController: NavHostController) {
    var nama by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var konfirmasiPassword by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Buat Akun",
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Gabung dan nikmati menu Populi Coffee.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama lengkap") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = konfirmasiPassword,
            onValueChange = { konfirmasiPassword = it },
            label = { Text("Konfirmasi password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                errorMessage = when {
                    nama.isBlank() -> "Nama lengkap wajib diisi."
                    email.isBlank() -> "Email wajib diisi."
                    !android.util.Patterns.EMAIL_ADDRESS
                        .matcher(email).matches() -> "Format email tidak valid."
                    password.length < 6 -> "Password minimal 6 karakter."
                    password != konfirmasiPassword ->
                        "Konfirmasi password tidak cocok."
                    else -> ""
                }

                if (errorMessage.isEmpty()) {
                    navController.navigate(AppRoute.HOME)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Daftar")
        }

        TextButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali")
        }
    }
}

// ==========================================
// 7. REUSABLE BUTTON COMPONENT
// ==========================================

@Composable
fun PopuliButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = PopuliEspresso,
    textColor: Color = PopuliCream,
    outlined: Boolean = false
) {

    if (outlined) {

        OutlinedButton(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = text,
                color = PopuliEspresso
            )
        }

    } else {

        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = textColor
            )
        ) {
            Text(text = text)
        }
    }
}
