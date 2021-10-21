package dev.cardoso.quotesmvvm.data.remote


import dev.cardoso.quotesmvvm.data.model.QuoteModel
import retrofit2.Response
import javax.inject.Inject

class QuoteApiImpl @Inject constructor(private val apiService: QuoteApi){

suspend fun getQuotes(): Response<List<QuoteModel>> {
        return apiService.getQuotes()
    }

}