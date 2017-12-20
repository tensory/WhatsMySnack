package net.tensory.whatsmysnack.data.persistence.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(Snack::class), version = 2, exportSchema = false)
abstract class SnackAppDatabase : RoomDatabase() {
    companion object {
        const val name: String = "snacks.db"
    }

    abstract fun snackDao(): SnackDao
}