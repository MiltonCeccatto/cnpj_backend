package br.com.desafioinspiratech.service

import br.com.desafioinspiratech.feign.CnpjApiFeign
import br.com.desafioinspiratech.model.wrapper.CnpjWrapper
import br.com.desafioinspiratech.model.wrapper.response.ApiResponse
import br.com.desafioinspiratech.util.Cnpjutil
import org.springframework.stereotype.Service

@Service
class CnpjService(
    private val cnpjApiFeign: CnpjApiFeign,
) {

    fun buscarPeloCnpjLocal(cnpj : String): CnpjWrapper {

        return cnpjApiFeign.buscarPeloCnpj(cnpj)

    }
}