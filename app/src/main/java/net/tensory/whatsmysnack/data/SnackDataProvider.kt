package net.tensory.whatsmysnack.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import net.tensory.whatsmysnack.data.databinding.Snack
import net.tensory.whatsmysnack.data.persistence.room.SnackAppDatabase

/**
 * Source for Snack data.
 */
class SnackDataProvider(private val snackAppDatabase: SnackAppDatabase) {

    fun fetchSnacks(): LiveData<List<Snack>> =
            Transformations.switchMap(snackAppDatabase.snackDao().snacks, { liveData ->
                val domainData = MutableLiveData<List<Snack>>()
                domainData.value = liveData.map { persistedSnack ->
                    Snack(
                            persistedSnack.name,
                            if (persistedSnack.type == 0) SnackType.VEGGIE else SnackType.NON_VEGGIE
                    )
                }
                domainData
            })


    fun insertSnack(snackName: String, snackType: SnackType) {
        snackAppDatabase.snackDao().insert(net.tensory.whatsmysnack.data.persistence.room.Snack(snackName, snackType.ordinal))
    }
}
