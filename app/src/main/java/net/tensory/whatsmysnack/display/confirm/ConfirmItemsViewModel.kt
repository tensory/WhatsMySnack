package net.tensory.whatsmysnack.display.confirm

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.data.databinding.Snack
import javax.inject.Inject

/**
 * ViewModel for Confirm Items.
 */
class ConfirmItemsViewModel(val items: List<Snack>?) : BaseObservable() {
    @Inject lateinit var context: Context

    @Bindable
    fun getItemNames(): String? {
        return items?.
                map { item -> item.name }?.
                sortedBy { it }?.
                joinToString(separator = context.resources.getString(R.string.separator))
    }
}