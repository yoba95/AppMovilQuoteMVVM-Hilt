package dev.cardoso.quotesmvvm.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cardoso.quotesmvvm.data.QuoteLocalDataSourceImpl
import dev.cardoso.quotesmvvm.data.QuoteRemoteDataSourceImpl
import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.local.QuoteDB
import dev.cardoso.quotesmvvm.data.local.QuoteLocalDataSource
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.remote.QuoteRemoteDataSource
import dev.cardoso.quotesmvvm.domain.QuoteRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesQuoteRemoteDataSource(retrofit: Retrofit): QuoteRemoteDataSource {
        return retrofit.create(QuoteRemoteDataSource::class.java)
    }

    @Singleton
    @Provides
    fun provideQuoteDAO(db: QuoteDB): QuoteDAO {
        return db.quoteDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
    abstract class ProvideQuoteRepository{
        @Binds
        abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl):QuoteRepository
    }

@Module
@InstallIn(SingletonComponent::class)
    abstract class ProvideQuoteLocalDataSource{
        @Binds
        abstract fun bindQuoteLocalDataSource(
            quoteLocalDataSourceImpl: QuoteLocalDataSourceImpl):QuoteLocalDataSource
    }

@Module
@InstallIn(SingletonComponent::class)
    abstract class ProvideQuoteRemoteDataSource{
        @Binds
        abstract fun bindQuoteRemoteDataSource(
            quoteRemoteDataSourceImpl: QuoteRemoteDataSourceImpl):QuoteRemoteDataSource
    }




