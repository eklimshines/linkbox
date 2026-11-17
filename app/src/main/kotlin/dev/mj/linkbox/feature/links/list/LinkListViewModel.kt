package dev.mj.linkbox.feature.links.list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * 1일차: Hilt → ViewModel → StateFlow → Compose 배선이 끝까지 이어지는지만 확인하는 placeholder.
 * 2일차에 LinkListUiState(sealed interface) + 이벤트 처리로 교체한다.
 */
@HiltViewModel
class LinkListViewModel @Inject constructor() : ViewModel() {
    private val _message = MutableStateFlow("Day 1 — Hilt wiring OK")
    val message: StateFlow<String> = _message.asStateFlow()
}
