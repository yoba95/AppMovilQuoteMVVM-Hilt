package dev.cardoso.quotesmvvm.domain.usecase

import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(private val quoteRepository :QuoteRepositoryImpl){

    suspend fun getQuote(quoteId:Int): Flow<QuoteModel> = quoteRepository.getQuote(quoteId)

}