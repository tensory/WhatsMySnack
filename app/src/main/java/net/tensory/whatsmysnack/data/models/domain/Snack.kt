package net.tensory.whatsmysnack.data.models.domain

import net.tensory.whatsmysnack.data.SnackType

data class Snack(val name: String, val type: SnackType, var selected: Boolean = false)