package net.tensory.whatsmysnack.display

import android.content.Context
import android.support.v7.app.AlertDialog
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.data.models.databinding.Snack

/**
 * Launch a view of selected choices.
 */
class SelectedItemsView(val context: Context) {
    interface OnDismissDelegate {
        fun onDismissOrderView()
    }

    // TODO this is not very MVVM yet
    fun show(items: List<Snack>?, onDismissDelegate: OnDismissDelegate) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder
                .setTitle(R.string.confirm_your_order)
                .setMessage(items?.map { item -> item.name }
                        ?.joinToString(separator = context.getString(R.string.separator)))
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    onDismissDelegate.onDismissOrderView()
                }

        builder.create().show()
    }
}