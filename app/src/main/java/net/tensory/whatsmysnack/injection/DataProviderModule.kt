package net.tensory.whatsmysnack.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import net.tensory.whatsmysnack.data.SnackDataProvider
import javax.inject.Singleton

/**
 * Provides the Snack data provider.
 */
@Module
class DataProviderModule {
    @Provides
    @Singleton
    fun provideSnackDataProvider(context: Context) = SnackDataProvider(context)
}