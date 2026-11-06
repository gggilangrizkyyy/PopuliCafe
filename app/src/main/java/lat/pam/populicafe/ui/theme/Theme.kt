package lat.pam.populicafe.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val PopuliColorScheme = lightColorScheme(
    primary = PopuliEspresso,
    onPrimary = PopuliCream,

    secondary = PopuliTerracotta,
    onSecondary = PopuliWhite,

    tertiary = PopuliSage,
    onTertiary = PopuliEspresso,

    background = PopuliCream,
    onBackground = PopuliTextPrimary,

    surface = PopuliCard,
    onSurface = PopuliTextPrimary,

    outline = PopuliBorder,
    error = PopuliTerracotta
)

@Composable
fun PopuliCoffeeTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = PopuliColorScheme,
        typography = PopuliTypography,
        content = content
    )
}
