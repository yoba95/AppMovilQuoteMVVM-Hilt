package dev.cardoso.quotesmvvm.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.cardoso.quotesmvvm.data.local.QuoteDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
        fun providerInstansDataBase(
            @ApplicationContext context: Context) : QuoteDB {
        return Room.databaseBuilder(
            context,
            QuoteDB::class.java,
            "quotes.dbf"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

}