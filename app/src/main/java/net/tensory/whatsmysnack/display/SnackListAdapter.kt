package net.tensory.whatsmysnack.display

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.data.databinding.Snack
import net.tensory.whatsmysnack.databinding.SnackListItemBinding

/**
 * List adapter for snacks list.
 */
class SnackListAdapter : RecyclerView.Adapter<SnackListAdapter.Companion.SnackViewHolder>(), Filterable {
    inner class SnacksFilter() : Filter() {
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val filterResults = FilterResults()
            filterResults.values = items.filter { it.visible }
            return filterResults
        }

        override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
            filterResults?.let {
                filteredItems = filterResults.values as List<Snack>
                notifyDataSetChanged()
            }
        }
    }

    override fun getFilter(): Filter = SnacksFilter()

    var items = emptyList<Snack>()
        set(items) {
            field = items
            filteredItems = items
        }

    var filteredItems = emptyList<Snack>()
        set(items) {
            field = items
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = filteredItems.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SnackViewHolder {
        val binding: SnackListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent?.context), R.layout.snack_list_item, parent, false)

        val viewHolder = SnackViewHolder(binding.root)
        viewHolder.binding = binding

        return viewHolder
    }

    override fun onBindViewHolder(holder: SnackViewHolder, position: Int) {
        holder.binding.snack = filteredItems[position]
        holder.binding.executePendingBindings()
    }

    companion object {
        class SnackViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            lateinit var binding: SnackListItemBinding
        }
    }
}