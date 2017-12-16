package net.tensory.whatsmysnack

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.tensory.whatsmysnack.databinding.ActivityMainBinding
import net.tensory.whatsmysnack.snacksList.SnacksListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = SnacksListAdapter()
        viewBinding.snacksList.adapter = adapter

        val viewModel = SnacksViewModel(this.application)

        // TODO refactor - there's no need for this to be in the AAC
        viewModel.snacks.observe(this, Observer { data ->
            data?.let {
                adapter.items = data
            }
        })
    }
}
