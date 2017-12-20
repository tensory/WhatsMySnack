package net.tensory.whatsmysnack.display

import android.arch.lifecycle.LiveData
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.Observable
import android.view.View
import net.tensory.whatsmysnack.BR
import net.tensory.whatsmysnack.data.SnackDataProvider
import net.tensory.whatsmysnack.data.SnackType
import net.tensory.whatsmysnack.data.databinding.Snack
import net.tensory.whatsmysnack.display.confirm.ConfirmItemsPresenter
import javax.inject.Inject

/**
 * Data model for snack list.
 */
class SnackListViewModel(private val confirmItemsPresenter: ConfirmItemsPresenter) : BaseObservable(), ConfirmItemsPresenter.OnDismissDelegate {

    @Inject
    lateinit var snackDataProvider: SnackDataProvider

    fun LiveData<List<Snack>>.makeVisible(snackType: SnackType, isVisible: Boolean) {
        this.value?.filter { it.type == snackType }?.forEach {
            it.visible = isVisible
            it.notifyChange()
        }
    }

    override fun onDismissOrderView() {
        showVeggies = true
        showNonVeggies = true
        snacks.value?.forEach {
            it.selected = false
            it.notifyChange()
        }
    }

    var showVeggies = true
            // Add the getter for this field to the databinding resources (BR) namespace.
        @Bindable // annotation applies to getter only
        get
        set(value) {
            // Binding value to this model:
            // Bind a change notifier to the checkbox bound to this field.
            // The property change listener is defined in the init block.
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.showVeggies)
            }
        }

    var showNonVeggies = true
        @Bindable
        get
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.showNonVeggies)
            }
        }

    val snacks: LiveData<List<Snack>> = snackDataProvider.fetchSnacks()

    fun onSubmitButtonClicked(): View.OnClickListener = View.OnClickListener {
        confirmItemsPresenter.onConfirmOrder(snacks.value?.filter { it.selected }, this)
    }

    inner class ControlPropertyChangedCallback : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: Observable?, propertyId: Int) {
            when (propertyId) {
                BR.showVeggies -> snacks.makeVisible(SnackType.VEGGIE, showVeggies)
                BR.showNonVeggies -> snacks.makeVisible(SnackType.NON_VEGGIE, showNonVeggies)
            }
        }
    }

    init {
        // Binding values to this model:
        // Bind a change listener that checks the two properties that control the list.
        addOnPropertyChangedCallback(ControlPropertyChangedCallback())
    }
}

