package net.tensory.whatsmysnack.injection

import dagger.Component
import net.tensory.whatsmysnack.SnacksApplication
import net.tensory.whatsmysnack.display.MainActivity
import javax.inject.Singleton

/**
 * Defines valid targets for injection of provided types.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataProviderModule::class))
interface DataComponent {
    fun inject(application: SnacksApplication)
    fun inject(mainActivity: MainActivity)
}