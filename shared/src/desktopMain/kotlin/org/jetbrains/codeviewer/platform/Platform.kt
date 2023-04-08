package org.jetbrains.codeviewer.platform


actual class Platform actual constructor() {
    actual val platform: String
        get() = "JVM"
}