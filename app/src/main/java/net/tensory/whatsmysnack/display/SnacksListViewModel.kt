package net.tensory.whatsmysnack.display

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import net.tensory.whatsmysnack.BR
import net.tensory.whatsmysnack.display.models.Snack

/**
 * Data model for snack list.
 */
class SnacksListViewModel : BaseObservable(), SelectedItemsView.OnDismissDelegate {
    override fun onDismissOrderView() {
        Log.i("ondismiss", "ondismiss")
    }

    private var _snacks = listOf(Snack("Oples", Snack.Type.VEGGIE), Snack("Bononos", Snack.Type.NON_VEGGIE))

    var snacks: LiveData<List<Snack>> = MutableLiveData()
        get() {
            val liveData: MutableLiveData<List<Snack>> = MutableLiveData()
            liveData.value = _snacks.filter { snack ->
                (snack.type == Snack.Type.VEGGIE && showVeggies) || (snack.type == Snack.Type.NON_VEGGIE && showNonVeggies)
            }
            return liveData
        }

    var showVeggies = true
    var showNonVeggies = true

    fun onSubmitButtonClicked(): View.OnClickListener = View.OnClickListener { view ->
        SelectedItemsView(view.context).show(snacks.value, this)
    }
}

