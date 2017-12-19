package net.tensory.whatsmysnack.data

import net.tensory.whatsmysnack.data.models.domain.Snack
import net.tensory.whatsmysnack.data.persistence.room.SnackAppDatabase

/**
 * Source for Snack data.
 */
class SnackDataProvider(val snackAppDatabase: SnackAppDatabase) {

    fun fetchSnacks(): List<Snack> = snackAppDatabase.snackDao().getAll().map { Snack(it.name, it.type) }
}