package net.tensory.whatsmysnack.injection

import dagger.Component
import net.tensory.whatsmysnack.display.confirm.ConfirmItemsViewModel
import javax.inject.Singleton

/**
 * Application component.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(confirmItemsViewModel: ConfirmItemsViewModel)
}