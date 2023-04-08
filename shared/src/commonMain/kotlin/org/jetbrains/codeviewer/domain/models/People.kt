package org.jetbrains.codeviewer.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val name: String?,
    val height: String?,
    val mass: String?,
    val url: String?
)


