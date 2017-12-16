package net.tensory.whatsmysnack

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

/**
 * Please add a docstring!
 */
class SnacksViewModel(application: Application) : AndroidViewModel(application) {
    val snacks: LiveData<List<String>> = {
        val liveData = MutableLiveData<List<String>>()
        liveData.value = listOf("Oples", "Bononos")
        liveData
    }()
}