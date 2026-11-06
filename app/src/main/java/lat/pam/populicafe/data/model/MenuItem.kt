package lat.pam.populicafe.data.model

data class MenuItem(
    val name: String,
    val category: String,
    val price: Int,
    val description: String,
    val isMerakyat: Boolean = false
)

object MenuData {
    val menuItems = listOf(
        // Drinks
        MenuItem(
            "Kopi Susu Gula Aren",
            "Drinks",
            22000,
            "Espresso, susu, dan manisnya gula aren."
        ),
        MenuItem(
            "Cappuccino",
            "Drinks",
            25000,
            "Perpaduan espresso, susu, dan foam lembut."
        ),
        MenuItem(
            "Matcha Latte",
            "Drinks",
            27000,
            "Matcha pilihan dengan susu creamy."
        ),
        MenuItem(
            "Es Kopi Shake Cheese Espresso",
            "Drinks",
            28000,
            "Espresso dingin dengan sensasi cheese."
        ),
        MenuItem(
            "Kopi Tubruk Spesial",
            "Drinks",
            15000,
            "Kopi hitam dengan cita rasa khas."
        ),

        // Snacks
        MenuItem(
            "Donat Cokelat",
            "Snacks",
            12000,
            "Donat lembut dengan topping cokelat."
        ),
        MenuItem(
            "Sourdough Aristokrat",
            "Snacks",
            35000,
            "Roti sourdough dengan karakter rasa khas."
        ),
        MenuItem(
            "Mix Snack Merakyat",
            "Snacks",
            18000,
            "Kombinasi camilan untuk teman nongkrong.",
            true
        ),
        MenuItem(
            "Roti Bakar Merakyat",
            "Snacks",
            15000,
            "Roti bakar hangat dengan isian lezat.",
            true
        ),

        // Meals
        MenuItem(
            "Nasi Goreng Merakyat",
            "Meals",
            20000,
            "Nasi goreng dengan bumbu khas Populi.",
            true
        ),
        MenuItem(
            "Mi Goreng Chili Oil Merakyat",
            "Meals",
            20000,
            "Mi goreng dengan chili oil khas Populi.",
            true
        ),
        MenuItem(
            "Mi Kuah Ayam Bawang Merakyat",
            "Meals",
            18000,
            "Mi kuah hangat dengan rasa ayam bawang.",
            true
        )
    )
}