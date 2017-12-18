package net.tensory.whatsmysnack.display

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.data.SnackDataSource
import net.tensory.whatsmysnack.data.models.databinding.Snack
import net.tensory.whatsmysnack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = SnacksListAdapter()
        viewBinding.snacksList.adapter = adapter

        val viewModel = SnacksListViewModel(SnackDataSource(this))
        viewBinding.viewModel = viewModel

        viewModel.snacks.observe(this, Observer { data ->
            data?.let {
                adapter.items = data.map { snack -> Snack(snack.name, snack.type, false) }
            }
        })
    }
}
