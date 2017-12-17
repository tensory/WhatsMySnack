package net.tensory.whatsmysnack.display.models

data class Snack(val name: String, val type: Type, var selected: Boolean = false) {
    enum class Type {
        VEGGIE,
        NON_VEGGIE
    }
}