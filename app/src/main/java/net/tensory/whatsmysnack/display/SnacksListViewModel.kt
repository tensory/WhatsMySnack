package net.tensory.whatsmysnack.display

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable
import android.util.Log
import android.view.View
import net.tensory.whatsmysnack.BR
import net.tensory.whatsmysnack.display.models.Snack

/**
 * Data model for snack list.
 */
class SnacksListViewModel : BaseObservable(), SelectedItemsView.OnDismissDelegate {
    override fun onDismissOrderView() {
        Log.i("ondismiss", "TODO")
    }

    var showVeggies = true
            // Add the getter for this field to the databinding resources (BR) namespace.
        @Bindable
        get() = field
        set(value) {
            // Binding value to this model:
            // Bind a change notifier to the checkbox bound to this field.
            field = value
            notifyPropertyChanged(BR.showVeggies)
        }

    var showNonVeggies = true
        @Bindable
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.showNonVeggies)
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

    fun onSubmitButtonClicked(): View.OnClickListener = View.OnClickListener { view ->
        SelectedItemsView(view.context).show(snacks.value, this)
    }

    class ControlPropertyChangedCallback : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: Observable?, propertyId: Int) {
            when (propertyId) {
                BR.showVeggies,
                BR.showNonVeggies -> Log.d(SnacksListViewModel::class.java::getName.toString(), "changed")
            }
        }
    }

    init {
        // Binding values to this model:
        // Bind a change listener to the properties that change.
        addOnPropertyChangedCallback(ControlPropertyChangedCallback())
    }
}

