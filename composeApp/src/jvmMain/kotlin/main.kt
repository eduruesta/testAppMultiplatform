import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.example.testapp.App
import org.jetbrains.compose.resources.stringResource
import testapp.composeapp.generated.resources.Res
import testapp.composeapp.generated.resources.app_name

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name),
        state = rememberWindowState(
            size = DpSize(480.dp, 640.dp)
        )
    ) {
        App()
    }
}