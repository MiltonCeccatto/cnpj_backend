package br.com.desafioinspiratech.validator

import br.com.desafioinspiratech.model.wrapper.CnpjWrapper
import br.com.desafioinspiratech.util.Cnpjutil
import br.com.desafioinspiratech.util.MessageSourceUtil
import org.springframework.stereotype.Service
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Service
class ValidatorCnpj (

    private val messageSource: MessageSourceUtil,

) : Validator {
    override fun supports(receivedClass: Class<*>): Boolean {
        return CnpjWrapper::class.java.isAssignableFrom(receivedClass)
    }
    /** verifica se o Cnpj inserido é válido*/

    override fun validate(target: Any, errors: Errors) {
        val cnpj = target as String
        val bindingResult = BeanPropertyBindingResult(target, errors.objectName)
        if (!Cnpjutil.isValid(Cnpjutil.unformat(cnpj))) {
            /**retorno se o Cnpj inserido é inválido */
            val message = messageSource.mensagem("aplication.error.cnpj")
            errors.rejectValue("", message, message)
        }
        errors.addAllErrors(bindingResult)
    }



}