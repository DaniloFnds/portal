package br.com.dhan.relatorios.service

import br.com.dhan.entity.RelatorioEntity
import br.com.dhan.relatorios.controller.dto.NovoRelatorioRequest

interface RelatorioService {

    fun getAllRelatorios(): List<RelatorioEntity>

    fun createRelatorio(novoRelatorio: NovoRelatorioRequest)
}