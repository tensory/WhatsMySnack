package net.tensory.whatsmysnack.data.persistence.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Room implementation of Snack entity.
 */
@Entity(tableName = "snacks")
class Snack(@PrimaryKey
             @ColumnInfo(name = "name")
             var name: String = "",
             @ColumnInfo(name = "type")
             var type: Int = 0)