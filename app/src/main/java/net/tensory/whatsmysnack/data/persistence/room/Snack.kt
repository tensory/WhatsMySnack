package net.tensory.whatsmysnack.data.persistence.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import net.tensory.whatsmysnack.data.SnackType

/**
 * Room implementation of Snack entity.
 */
@Entity(tableName = "snacks")
class Snack(@PrimaryKey
            val name: String,

            @TypeConverters(SnackTypeConverter::class)
            val type: SnackType)