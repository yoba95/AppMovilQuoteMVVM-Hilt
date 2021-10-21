package dev.cardoso.quotesmvvm.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cardoso.quotesmvvm.data.local.QuoteDB
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.domain.usecase.GetQuoteRandomUseCase
import dev.cardoso.quotesmvvm.domain.usecase.GetQuotesUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getQuoteRandomUseCase: GetQuoteRandomUseCase,
) : ViewModel() {

    private val _quoteModel = MutableStateFlow(QuoteModel(0,"",""))
    val quoteModel: StateFlow<QuoteModel> = _quoteModel

    @Inject lateinit var quoteDB: QuoteDB

    fun getQuotes() {
        viewModelScope.launch {
            val quotes = getQuotesUseCase.getQuotes().first()
            val quote= when(quotes.isEmpty()){
                true -> QuoteModel(id=0,"Solo sé que no sé nada","Sócrates")
                else -> quotes[0]
            }
            _quoteModel.value=quote
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            _quoteModel.value= getQuoteRandomUseCase.getQuoteRandom().first()
        }
    }

    fun setContext(context: Context){
         quoteDB.quoteDao()
    }


}