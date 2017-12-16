package net.tensory.whatsmysnack.display

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import net.tensory.whatsmysnack.display.models.Snack

/**
 * Data model for snack list.
 */
class SnacksListViewModel(application: Application) : AndroidViewModel(application) {
    val snacks: LiveData<List<Snack>> = {
        val liveData = MutableLiveData<List<Snack>>()
        liveData.value = listOf(Snack("Oples", Snack.Type.VEGGIE), Snack("Bononos", Snack.Type.NON_VEGGIE))
        liveData
    }()
}