package net.tensory.whatsmysnack.display.additem

import android.databinding.BaseObservable
import net.tensory.whatsmysnack.data.SnackType

/**
 * View model for the Add Item UI.
 */
class AddItemViewModel : BaseObservable() {
    var snackName: String = ""
    // TODO veggie for now
    var snackType: SnackType = SnackType.VEGGIE

    fun addItem() {
        // TODO insert
    }
}