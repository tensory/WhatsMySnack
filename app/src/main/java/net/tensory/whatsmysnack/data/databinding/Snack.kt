package net.tensory.whatsmysnack.data.databinding

import android.databinding.BaseObservable
import android.databinding.Bindable
import net.tensory.whatsmysnack.BR
import net.tensory.whatsmysnack.data.SnackType
import kotlin.properties.Delegates

data class Snack(val name: String, val type: SnackType) : BaseObservable() {
    var selected: Boolean by Delegates.observable(false) {
        // No properties are consumed in this observer.
        // Sets a listener to notify the model that the property changed.
        _, _, _ -> notifyPropertyChanged(BR.selected)
    }

    @Bindable
    get
}