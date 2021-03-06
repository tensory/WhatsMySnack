package net.tensory.whatsmysnack.data.persistence.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Database access object for Snacks.
 */
@Dao
interface SnackDao {
    @get:Query("SELECT * from snacks")
    val snacks: LiveData<List<Snack>>

    @Insert
    fun insert(snack: Snack)
}