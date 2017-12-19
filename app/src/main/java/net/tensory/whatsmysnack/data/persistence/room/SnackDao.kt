package net.tensory.whatsmysnack.data.persistence.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

/**
 * Database access object for Snacks.
 */
@Dao
interface SnackDao {
    @Query("SELECT * from snacks")
    fun getAll(): List<Snack>
}