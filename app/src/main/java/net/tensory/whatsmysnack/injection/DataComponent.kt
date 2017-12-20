package net.tensory.whatsmysnack.injection

import dagger.Component
import net.tensory.whatsmysnack.SnackApplication
import net.tensory.whatsmysnack.display.MainActivity
import net.tensory.whatsmysnack.display.SnackListViewModel
import net.tensory.whatsmysnack.display.additem.AddItemViewModel
import net.tensory.whatsmysnack.display.confirm.ConfirmItemsViewModel
import javax.inject.Singleton

/**
 * Defines valid targets for injection of provided types.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class))
interface DataComponent {
    fun inject(application: SnackApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(snackListViewModel: SnackListViewModel)
    fun inject(addItemViewModel: AddItemViewModel)
}