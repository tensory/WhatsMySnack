package net.tensory.whatsmysnack.data

import android.content.Context
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.data.models.Snack
import net.tensory.whatsmysnack.data.models.SnackType

/**
 * Source for Snack data.
 */
class SnackDataSource(val context: Context) {

    fun fetchSnacks(): List<Snack> {
        val snacks = mutableListOf<Snack>()
        context.resources.getStringArray(R.array.veggies).forEach { snacks.add(Snack(it, SnackType.VEGGIE)) }
        context.resources.getStringArray(R.array.non_veggies).forEach { snacks.add(Snack(it, SnackType.NON_VEGGIE)) }
        return snacks
    }
}