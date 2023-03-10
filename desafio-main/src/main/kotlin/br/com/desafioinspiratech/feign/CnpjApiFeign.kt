package br.com.desafioinspiratech.feign

import br.com.desafioinspiratech.model.wrapper.CnpjWrapper
import br.com.desafioinspiratech.model.wrapper.response.ApiResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(
    name = "fsj-cnpj-api",
    value = "fsj-cnpj-api",
    url = "\${fsj.cnpj-api.url}"
)
interface CnpjApiFeign {
    @GetMapping("/{cnpj}")
    fun buscarPeloCnpj(@PathVariable cnpj: String) : CnpjWrapper
}