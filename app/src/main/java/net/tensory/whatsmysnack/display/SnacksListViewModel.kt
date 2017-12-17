package net.tensory.whatsmysnack.display

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.view.View
import android.widget.Toast
import net.tensory.whatsmysnack.display.models.Snack

/**
 * Data model for snack list.
 */
class SnacksListViewModel : BaseObservable() {
    val snacks: LiveData<List<Snack>> = {
        val liveData = MutableLiveData<List<Snack>>()
        liveData.value = listOf(Snack("Oples", Snack.Type.VEGGIE), Snack("Bononos", Snack.Type.NON_VEGGIE))
        liveData
    }()

    fun onSubmitButtonClicked(): View.OnClickListener = View.OnClickListener { view ->
        Toast.makeText(view.context, "Yup", Toast.LENGTH_SHORT).show()
    }
}