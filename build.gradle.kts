// 루트에서는 플러그인을 "apply false"로 선언만 하고, 실제 적용은 app/build.gradle.kts 에서 한다.
// kotlin-jvm 선언은 쓰지 않지만, AGP 9 built-in Kotlin 이 사용할 KGP 버전을 카탈로그의 kotlin 버전으로
// 끌어올리기 위한 것이다 (Compose 컴파일러 플러그인 버전과 맞추려면 필요). → 검증 포인트 1
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.spotless)
}

// 단일 모듈이라 포맷 설정은 루트 한 곳에 둔다. 로컬: spotlessApply / CI: spotlessCheck
spotless {
    kotlin {
        target("app/src/**/*.kt")
        ktlint().setEditorConfigPath(rootProject.file(".editorconfig"))
    }
    kotlinGradle {
        target("*.gradle.kts", "app/*.gradle.kts")
        ktlint().setEditorConfigPath(rootProject.file(".editorconfig"))
    }
}
