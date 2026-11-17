package dev.mj.linkbox.feature.links.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.mj.linkbox.core.designsystem.theme.LinkboxTheme

/** Route: ViewModel 을 아는 쪽. Screen: 상태만 받는 쪽 (프리뷰와 UI 테스트가 쉬워진다). */
@Composable
fun LinkListRoute(
    modifier: Modifier = Modifier,
    viewModel: LinkListViewModel = hiltViewModel(),
) {
    val message by viewModel.message.collectAsStateWithLifecycle()
    LinkListScreen(message = message, modifier = modifier)
}

@Composable
internal fun LinkListScreen(
    message: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = message, style = MaterialTheme.typography.titleMedium)
    }
}

@Preview(showBackground = true)
@Composable
private fun LinkListScreenPreview() {
    LinkboxTheme {
        LinkListScreen(message = "Preview")
    }
}
