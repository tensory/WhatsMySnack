package net.tensory.whatsmysnack.display

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.util.Log
import android.view.View
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
            var liveData: MutableLiveData<List<Snack>> = MutableLiveData()
            if (showVeggies && showNonVeggies) {
                liveData.value = _snacks
            } else if (showVeggies) {
                liveData.value = _snacks.filter { snack -> snack.type == Snack.Type.VEGGIE }
            } else if (showNonVeggies) {
                liveData.value = _snacks.filter { snack -> snack.type == Snack.Type.NON_VEGGIE }
            }
            return liveData
        }

    var showVeggies = true
    var showNonVeggies = true

    fun onSubmitButtonClicked(): View.OnClickListener = View.OnClickListener { view ->
        SelectedItemsView(view.context).show(snacks.value, this)
    }
}

