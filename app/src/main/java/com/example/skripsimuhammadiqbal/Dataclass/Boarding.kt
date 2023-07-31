package com.example.skripsimuhammadiqbal.Dataclass

import java.io.Serializable

data class Boarding(
    var banner: Int,
    var iconSrc: Int,
    var title: String,
    var desc: String,
    var isLast: Boolean = false
) : Serializable