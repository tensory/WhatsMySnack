package net.tensory.whatsmysnack.injection

import android.app.Application
import android.content.Context
import com.huma.room_for_asset.RoomAsset
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
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideSnackAppDatabase(): SnackAppDatabase = RoomAsset.databaseBuilder(application.applicationContext, SnackAppDatabase::class.java, SnackAppDatabase.name)
            // This is inadvisable.
            // Better to execute queries through an Rx-managed thread or another thread executor.
            .allowMainThreadQueries()
            .build()
}