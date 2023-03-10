package br.com.desafioinspiratech.controller


import br.com.desafioinspiratech.model.wrapper.CnpjWrapper
import br.com.desafioinspiratech.model.wrapper.response.ApiResponse
import br.com.desafioinspiratech.service.CnpjService
import br.com.desafioinspiratech.util.Cnpjutil

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("pesquisarCnpj")
class CnpjController(
    private val cnpjService: CnpjService
) {
    @GetMapping("/{cnpj}")
    fun pesquisarCnpj(
        @PathVariable cnpj: String
    ): ApiResponse<CnpjWrapper> {
        return try {
            val cnpjFormat = Cnpjutil.unformat((cnpj))
             ApiResponse(cnpjService.buscarPeloCnpjLocal(cnpjFormat))
        }catch (e: Exception){
            e.printStackTrace()
            ApiResponse(HttpStatus.BAD_REQUEST, "Erro, cnpj inválido")
        }
    }
}