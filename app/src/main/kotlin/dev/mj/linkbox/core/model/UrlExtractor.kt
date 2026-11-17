package dev.mj.linkbox.core.model

/**
 * 공유 텍스트에서 첫 번째 http(s) URL 을 뽑는다.
 * 앱마다 공유 텍스트 모양이 다르다: "Check this out https://youtu.be/abc" 처럼 앞뒤에 문장이 붙는다.
 *
 * android.util.Patterns.WEB_URL 을 쓰지 않는 이유: 로컬 단위 테스트(JVM)에서는 android.jar 가
 * 스텁이라 Patterns 접근 시 예외가 난다. 순수 Kotlin 으로 두면 에뮬레이터 없이 테스트된다.
 *
 * 알려진 한계: RFC 3986 의 ASCII 문자만 URL 로 인정한다. 그래서 "https://a.com/x입니다" 에서
 * 한국어 조사는 잘리지만, 퍼센트 인코딩 안 된 한글 경로(예: 위키 문서명)도 거기서 잘린다.
 */
object UrlExtractor {
    private val URL_REGEX = Regex(
        """https?://[A-Za-z0-9\-._~:/?#\[\]@!$&'()*+,;=%]+""",
        RegexOption.IGNORE_CASE
    )

    // 문장 끝 구두점은 URL 이 아니라고 본다. ')' 는 괄호 짝을 보고 따로 판단.
    private val TRAILING_PUNCTUATION = setOf('.', ',', '!', '?', ';', ':', ']', '\'', '"')

    fun extractFirst(text: String): String? {
        val raw = URL_REGEX.find(text)?.value ?: return null
        return trimTrailing(raw).takeIf { it.substringAfter("://").isNotEmpty() }
    }

    private fun trimTrailing(url: String): String {
        var result = url
        while (result.isNotEmpty()) {
            val shouldTrim = when (result.last()) {
                // https://en.wikipedia.org/wiki/Kotlin_(programming_language) 의 ')' 는 살린다
                ')' -> result.count { it == '(' } < result.count { it == ')' }

                in TRAILING_PUNCTUATION -> true

                else -> false
            }
            if (!shouldTrim) break
            result = result.dropLast(1)
        }
        return result
    }
}
