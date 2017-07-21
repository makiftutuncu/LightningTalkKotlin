package com.mehmetakiftutuncu.lightningtalkkotlin

data class User(val username: String, val password: String)

inline fun Pair<String, String>.toUser(): User = User(first, second)
