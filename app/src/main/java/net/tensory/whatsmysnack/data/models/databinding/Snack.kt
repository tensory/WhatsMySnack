package net.tensory.whatsmysnack.data.models.databinding

import android.databinding.BaseObservable
import net.tensory.whatsmysnack.data.models.SnackType

data class Snack(val name: String, val type: SnackType, var selected: Boolean = false) : BaseObservable()