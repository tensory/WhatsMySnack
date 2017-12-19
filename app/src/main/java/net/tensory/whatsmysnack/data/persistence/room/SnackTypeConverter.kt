package net.tensory.whatsmysnack.data.persistence.room

import android.arch.persistence.room.TypeConverter
import net.tensory.whatsmysnack.data.SnackType

/**
 * Please add a docstring!
 */
class SnackTypeConverter {
    @TypeConverter
    fun toSnackType(ordinal: Int): SnackType =
            if (ordinal == 1) SnackType.NON_VEGGIE else SnackType.VEGGIE

    @TypeConverter
    fun toInt(snackType: SnackType): Int = snackType.ordinal
}