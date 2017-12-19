package net.tensory.whatsmysnack

import android.app.Application
import net.tensory.whatsmysnack.injection.ApplicationModule
import net.tensory.whatsmysnack.injection.DaggerDataComponent
import net.tensory.whatsmysnack.injection.DataComponent

class SnackApplication : Application() {
    lateinit var dataComponent: DataComponent

    override fun onCreate() {
        super.onCreate()
        dataComponent = DaggerDataComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}