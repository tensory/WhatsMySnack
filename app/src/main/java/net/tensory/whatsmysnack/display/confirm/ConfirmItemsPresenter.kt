package net.tensory.whatsmysnack.display.confirm

import net.tensory.whatsmysnack.data.databinding.Snack

/**
 * Present confirmation of orders.
 */
interface ConfirmItemsPresenter {
    fun onConfirmOrder(items: List<Snack>?)

    interface OnDismissDelegate {
        fun onDismissOrderView()
    }
}