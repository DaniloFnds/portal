package br.com.dhan.relatorios.controller.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class NovoRelatorioRequest(
    @NotNull
    val tipoRelatorio: String,
    @NotNull
    val nomeRelatorio: String,
    @NotEmpty
    val parametros: List<ParametroRelatorio>,
    @NotNull
    val usuario: String
)
