package net.tensory.whatsmysnack.display.additem

import android.databinding.BaseObservable
import android.databinding.Bindable
import net.tensory.whatsmysnack.BR
import net.tensory.whatsmysnack.data.SnackDataProvider
import net.tensory.whatsmysnack.data.SnackType
import javax.inject.Inject

/**
 * View model for the Add Item UI.
 */
class AddItemViewModel : BaseObservable() {

    @Inject
    lateinit var snackDataProvider: SnackDataProvider

    var snackName: String = ""
        @Bindable
        get
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.snackName)
            }
        }

    var veggieSelected: Boolean = true
        @Bindable
        get
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.veggieSelected)
            }
        }

    fun addItem() {
        snackDataProvider.insertSnack(snackName,
                if (veggieSelected) SnackType.VEGGIE else SnackType.NON_VEGGIE)
    }
}