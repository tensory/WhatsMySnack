package net.tensory.whatsmysnack.display

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.data.models.Snack
import net.tensory.whatsmysnack.databinding.SnackListItemBinding

/**
 * List adapter for snacks list.
 */
class SnacksListAdapter : RecyclerView.Adapter<SnacksListAdapter.Companion.SnackViewHolder>() {
    var items: List<Snack> = emptyList()
        set(items) {
            field = items
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SnackViewHolder {
        val binding: SnackListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent?.context), R.layout.snack_list_item, parent, false)

        val viewHolder = SnackViewHolder(binding.root)
        viewHolder.binding = binding

        binding.checkbox.setOnCheckedChangeListener({ buttonView, isChecked ->
            binding.notifyPropertyChanged(BR.snack)
            Toast.makeText(buttonView.context, isChecked.toString(), LENGTH_SHORT).show()
        })

        return viewHolder
    }

    override fun onBindViewHolder(holder: SnackViewHolder, position: Int) {
        holder.binding.snack = items[position]
        holder.binding.executePendingBindings()
    }

    companion object {
        class SnackViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
            lateinit var binding: SnackListItemBinding
        }
    }
}