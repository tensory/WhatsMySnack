package net.tensory.whatsmysnack.data

import android.content.Context
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.data.models.Snack

/**
 * Source for Snack data.
 */
class SnackDataSource(val context: Context) {

    fun fetchSnacks(): List<Snack> {
        val snacks = mutableListOf<Snack>()
        context.resources.getStringArray(R.array.veggies).forEach { snacks.add(Snack(it, Snack.Type.VEGGIE)) }
        context.resources.getStringArray(R.array.non_veggies).forEach { snacks.add(Snack(it, Snack.Type.NON_VEGGIE)) }
        return snacks.sortedBy { snack -> snack.name }
    }
}