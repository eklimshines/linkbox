package dev.mj.linkbox.core.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class UrlExtractorTest {
    @Test
    fun `공유 문장 사이의 URL을 뽑는다`() {
        assertEquals(
            "https://youtu.be/dQw4w9WgXcQ",
            UrlExtractor.extractFirst("Check this out https://youtu.be/dQw4w9WgXcQ"),
        )
    }

    @Test
    fun `문장 끝 마침표는 URL에 포함하지 않는다`() {
        assertEquals(
            "https://example.com/post",
            UrlExtractor.extractFirst("Read https://example.com/post."),
        )
    }

    @Test
    fun `짝이 맞는 괄호는 URL에 남긴다`() {
        assertEquals(
            "https://en.wikipedia.org/wiki/Kotlin_(programming_language)",
            UrlExtractor.extractFirst("(see https://en.wikipedia.org/wiki/Kotlin_(programming_language))"),
        )
    }

    @Test
    fun `URL 바로 뒤에 붙은 한국어는 자른다`() {
        assertEquals(
            "https://example.com/a",
            UrlExtractor.extractFirst("링크: https://example.com/a입니다"),
        )
    }

    @Test
    fun `여러 개면 첫 번째만`() {
        assertEquals(
            "https://first.com",
            UrlExtractor.extractFirst("https://first.com and https://second.com"),
        )
    }

    @Test
    fun `URL이 없거나 호스트가 비어 있으면 null`() {
        assertNull(UrlExtractor.extractFirst("no link here"))
        assertNull(UrlExtractor.extractFirst("broken https://"))
    }
}
