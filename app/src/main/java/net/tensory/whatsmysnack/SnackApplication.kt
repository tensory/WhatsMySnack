package net.tensory.whatsmysnack

import android.app.Application
import net.tensory.whatsmysnack.injection.*

class SnackApplication : Application() {
    lateinit var dataComponent: DataComponent
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        dataComponent = DaggerDataComponent.builder()
                .applicationModule(ApplicationModule(this))
                .dataModule(DataModule())
                .build()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

    }
}