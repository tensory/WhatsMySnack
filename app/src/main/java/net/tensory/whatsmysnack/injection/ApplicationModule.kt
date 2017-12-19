package net.tensory.whatsmysnack.injection

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import net.tensory.whatsmysnack.data.persistence.room.SnackAppDatabase
import javax.inject.Singleton

/**
 * Module providing application components.
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideSnackAppDatabase() = Room.databaseBuilder(application.applicationContext, SnackAppDatabase::class.java, SnackAppDatabase.name).build()
}