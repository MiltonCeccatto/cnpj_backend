package br.com.desafioinspiratech.util

import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component

@Component
class MessageSourceUtil(private val messageSource: MessageSource) {

    fun mensagem(chave: String, vararg params: Any): String {
        return try {
            messageSource.getMessage(chave, params, LocaleContextHolder.getLocale())
        } catch (e: Exception) {
            chave
        }
    }
}