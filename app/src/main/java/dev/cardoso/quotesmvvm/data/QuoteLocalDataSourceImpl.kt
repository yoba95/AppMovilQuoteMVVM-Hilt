package dev.cardoso.quotesmvvm.data


import dev.cardoso.quotesmvvm.data.local.QuoteLocalDataSource
import dev.cardoso.quotesmvvm.data.local.daos.QuoteDAO
import dev.cardoso.quotesmvvm.data.local.entities.QuoteEntity
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class QuoteLocalDataSourceImpl @Inject constructor(
): QuoteLocalDataSource {

    @Inject lateinit var quoteDAO: QuoteDAO

    override fun getQuotes(): Flow<List<QuoteModel>> {
        val quotes = quoteDAO.getQuotes()
            val quotesMapped= quotes.map {
                it.map { quoteEntity ->
                    QuoteModel(
                        id = quoteEntity.id,
                        quote = quoteEntity.quote,
                        author = quoteEntity.author
                    )
                }
            }
            return  quotesMapped
        }

       override fun getQuote(quoteId: Int): Flow<QuoteModel> {
            return  quoteDAO.getQuote(quoteId).map {
                QuoteModel(id= it.id,
                    quote = it.quote,
                    author = it.author)
                }
        }

        override fun getQuoteRandom(): Flow<QuoteModel> {
            return  quoteDAO.getQuoteRandom().map {
                QuoteModel(id= it.id,
                    quote = it.quote,
                    author = it.author)
            }
        }

         override suspend fun insertAll(quotes: List<QuoteModel>) {
            quoteDAO.insertAll(quotes.map { // } quotes!!.map {
                QuoteEntity(id= it.id,
                    quote = it.quote,
                    author = it.author)
            })
        }

      override suspend fun insert(quote: QuoteModel) {
          quoteDAO.insert(
                QuoteEntity(
                    id= quote.id,
                    quote= quote.quote,
                    author = quote.author) )
        }

}
