package net.tensory.whatsmysnack.injection

import android.app.Application
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
    @Singleton
    fun provideSnackAppDatabase(): SnackAppDatabase = RoomAsset.databaseBuilder(application.applicationContext, SnackAppDatabase::class.java, "boolean_snacks.db")
            .allowMainThreadQueries()
            .build()
}