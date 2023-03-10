package br.com.desafioinspiratech.model.wrapper

data class CnpjWrapper (
    val atividade_principal:  ArrayList<atividade_principal>? = arrayListOf(),
    val data_situacao: String? = null,
    val complemento: String? = null,
    val tipo: String? = null,
    val nome: String? = null,
    val uf: String? = null,
    val abertura: String? = null,
    val telefone: String? = null,
    val email: String? = null,
    val atividades_secundarias : ArrayList<atividades_secundaria>? = arrayListOf(),
    val qsa: ArrayList<qsa>? = arrayListOf(),
    val situacao: String? = null,
    val bairro: String? = null,
    val logradouro: String? = null,
    val numero: Int? = null,
    val cep: String? = null,
    val municipio: String? = null,
    val porte: String? = null,
    val natureza_juridica: String? = null,
    val fantasia: String?= null,
    val cnpj: String? = null,
    val ultima_atualizacao: String? = null,
    val status: String? = null,
    val efr: String? = null,
    val motivo_situacao: String? = null,
    val situacao_especial: String? = null,
    val data_situacao_especial: String? = null,
    val capital_social: String? = null,
    val billing : billing
    )
data class atividades_secundaria(
    var code: String? = null,
    var text: String? = null
)

data class atividade_principal(
    var code: String? = null,
    var text: String? = null
)
data class qsa(
    var nome: String? = null,
    var qual: String? = null
)

data class billing(
    var free: Boolean? = null,
    var database: Boolean? =null
)