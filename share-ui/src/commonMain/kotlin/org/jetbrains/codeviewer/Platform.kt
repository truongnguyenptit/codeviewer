package org.jetbrains.codeviewer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform