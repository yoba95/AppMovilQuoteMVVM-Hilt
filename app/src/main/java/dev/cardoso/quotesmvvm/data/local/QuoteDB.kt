package dev.cardoso.quotesmvvm.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.local.entities.QuoteEntity



@Database(entities = [QuoteEntity::class, ], version = 1)
abstract class QuoteDB : RoomDatabase() {

    abstract fun quoteDao(): QuoteDAO

}
