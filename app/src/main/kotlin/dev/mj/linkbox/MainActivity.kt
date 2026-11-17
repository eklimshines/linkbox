package dev.mj.linkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import dev.mj.linkbox.core.designsystem.theme.LinkboxTheme
import dev.mj.linkbox.feature.links.list.LinkListRoute

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LinkboxTheme {
                Scaffold { innerPadding ->
                    LinkListRoute(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
