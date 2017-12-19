package net.tensory.whatsmysnack.display

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.SnackApplication
import net.tensory.whatsmysnack.data.SnackDataProvider
import net.tensory.whatsmysnack.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var snackDataProvider: SnackDataProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inject this Activity to the DataComponent so that the component can provide data dependencies.
        (application as SnackApplication).dataComponent.inject(this)

        val viewBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = SnackListAdapter()
        viewBinding.snacksList.adapter = adapter

        val viewModel = SnackListViewModel(snackDataProvider)
        viewBinding.viewModel = viewModel

        viewModel.snacks.observe(this, Observer { data ->
            data?.let {
                adapter.items = data
            }
        })
    }
}
