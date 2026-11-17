package dev.mj.linkbox.core.model

import java.time.Instant

/**
 * 저장된 링크 하나. 2일차 목록 화면, 5일차 Room 엔티티 매핑의 기준 모델.
 * title 은 메타데이터를 아직 못 가져왔을 수 있어서 nullable (4일차에 서버에서 채움).
 */
data class Link(
    val id: Long,
    val url: String,
    val title: String?,
    val tags: List<String>,
    val isRead: Boolean,
    val savedAt: Instant,
)
