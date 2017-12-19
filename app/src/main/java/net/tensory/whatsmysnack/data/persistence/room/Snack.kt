package net.tensory.whatsmysnack.data.persistence.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import net.tensory.whatsmysnack.data.SnackType

/**
 * Room implementation of Snack entity.
 */
@Entity(tableName = "snacks")
class Snack(@PrimaryKey
            val name: String,
            val type: SnackType)