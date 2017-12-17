package net.tensory.whatsmysnack.display.order

import android.content.Context
import android.support.v7.app.AlertDialog

/**
 * Please add a docstring!
 */
class OrderView(val context: Context) {
    interface OnDismissDelegate {
        fun onDismissOrderView()
    }

    fun show(onDismissDelegate: OnDismissDelegate) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setPositiveButton(android.R.string.ok) { _, _ ->
            onDismissDelegate.onDismissOrderView()
        }
        builder.create().show()
    }
}