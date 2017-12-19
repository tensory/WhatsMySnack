package net.tensory.whatsmysnack.display.additem

import android.databinding.BaseObservable
import android.databinding.Bindable
import net.tensory.whatsmysnack.BR
import net.tensory.whatsmysnack.data.SnackType

/**
 * View model for the Add Item UI.
 */
class AddItemViewModel : BaseObservable() {
    // This type is automatically bindable.
    // No further annotation is needed.
    var snackName: String = ""

    var snackType: SnackType = SnackType.VEGGIE
        @Bindable
        get
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.snackType)
            }
        }

    fun addItem() {
        // TODO insert
    }
}