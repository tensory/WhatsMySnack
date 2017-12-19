package net.tensory.whatsmysnack.injection

import dagger.Module
import dagger.Provides
import net.tensory.whatsmysnack.data.SnackDataProvider
import net.tensory.whatsmysnack.data.persistence.room.SnackAppDatabase
import javax.inject.Singleton

/**
 * Provides the Snack data provider.
 */
@Module
class DataModule {
    @Provides
    @Singleton
    fun provideSnackDataProvider(snackAppDatabase: SnackAppDatabase) = SnackDataProvider(snackAppDatabase)
}