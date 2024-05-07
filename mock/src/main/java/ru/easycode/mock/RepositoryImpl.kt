package ru.easycode.mock

import ru.easycode.domain.LoadQuoteResult
import ru.easycode.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {

    private var showError = true

    override suspend fun loadQuote(): LoadQuoteResult {
        return try {
            if (showError) {
                showError = false
                throw IllegalStateException("no internet connection")
            }
            val quote = "mock quote"
            LoadQuoteResult.Success(quote)
        } catch (e: Exception) {
            LoadQuoteResult.Error(e.message ?: "error")
        }
    }
}