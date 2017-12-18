package net.tensory.whatsmysnack.data.models

data class Snack(val name: String, val type: SnackType, var selected: Boolean = false)