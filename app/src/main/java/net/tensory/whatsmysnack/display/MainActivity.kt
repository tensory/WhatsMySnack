package net.tensory.whatsmysnack.display

import android.arch.lifecycle.Observer
import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import net.tensory.whatsmysnack.R
import net.tensory.whatsmysnack.SnackApplication
import net.tensory.whatsmysnack.data.SnackDataProvider
import net.tensory.whatsmysnack.databinding.ActivityMainBinding
import net.tensory.whatsmysnack.display.additem.AddItemPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), AddItemPresenter {

    // region AddItemPresenter implementation

    override fun addItem() {
        AlertDialog.Builder(this)
                .setTitle(R.string.add_snack)
                .setView(R.layout.add_item)
                .setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialogInterface, i ->

                })
                .setNegativeButton(android.R.string.cancel, { dialogInterface, _ ->
                    dialogInterface.cancel()
                })
                .show()
    }

    // endregion

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_add_item -> addItem()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

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
