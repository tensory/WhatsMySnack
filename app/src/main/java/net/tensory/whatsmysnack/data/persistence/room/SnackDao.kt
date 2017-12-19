package net.tensory.whatsmysnack.data.persistence.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

/**
 * Database access object for Snacks.
 */
@Dao
interface SnackDao {
    @get:Query("SELECT * from snacks")
    val snacks: List<Snack>
}