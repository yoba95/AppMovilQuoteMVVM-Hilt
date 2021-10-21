package dev.cardoso.quotesmvvm.domain.usecase

import dev.cardoso.quotesmvvm.data.QuoteRepositoryImpl
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteRandomUseCase @Inject constructor(private val quoteRepository : QuoteRepositoryImpl) {

    suspend fun getQuoteRandom(): Flow<QuoteModel> = quoteRepository.getQuoteRandom()

}