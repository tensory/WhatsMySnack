package net.tensory.whatsmysnack.display

import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable
import android.view.View
import net.tensory.whatsmysnack.BR
import net.tensory.whatsmysnack.data.SnackDataSource
import net.tensory.whatsmysnack.data.SnackType
import net.tensory.whatsmysnack.data.models.databinding.Snack

/**
 * Data model for snack list.
 */
// TODO DI candidate
class SnacksListViewModel(snackDataSource: SnackDataSource) : BaseObservable(), SelectedItemsView.OnDismissDelegate {
    override fun onDismissOrderView() {
        showVeggies = true
        showNonVeggies = true
        snacks.postValue(filterSnacks().onEach { it.selected = false })
    }

    var showVeggies = true
            // Add the getter for this field to the databinding resources (BR) namespace.
        @Bindable
        get

        set(value) {
            // Binding value to this model:
            // Bind a change notifier to the checkbox bound to this field.
            // The property change listener is defined in the init block.
            field = value
            notifyPropertyChanged(BR.showVeggies)
        }

    var showNonVeggies = true
        @Bindable
        get

        set(value) {
            field = value
            notifyPropertyChanged(BR.showNonVeggies)
        }

    // Backing field for Snack data
    private var _snacks = snackDataSource.fetchSnacks()
            .map { Snack(it.name, it.type) }
            .sortedBy { it.name }

    var snacks: MutableLiveData<List<Snack>> = {
        val liveData = MutableLiveData<List<Snack>>()
        liveData.value = filterSnacks()
        liveData
    }()

    fun onSubmitButtonClicked(): View.OnClickListener = View.OnClickListener { view ->
        SelectedItemsView(view.context).show(snacks.value?.filter { it.selected }, this)
    }

    inner class ControlPropertyChangedCallback : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: Observable?, propertyId: Int) {
            when (propertyId) {
                BR.showVeggies,
                BR.showNonVeggies -> {
                    snacks.postValue(filterSnacks())
                }
            }
        }
    }

    init {
        // Binding values to this model:
        // Bind a change listener that checks the two properties that control the list.
        addOnPropertyChangedCallback(ControlPropertyChangedCallback())
    }

    private fun filterSnacks(): List<Snack> {
        return _snacks.filter { snack ->
            (snack.type == SnackType.VEGGIE && showVeggies) || (snack.type == SnackType.NON_VEGGIE && showNonVeggies)
        }
    }

}

