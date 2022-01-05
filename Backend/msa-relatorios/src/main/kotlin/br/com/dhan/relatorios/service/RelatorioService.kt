package br.com.dhan.relatorios.service

import br.com.dhan.entity.RelatorioEntity

interface RelatorioService {

    fun getAllRelatorios(): List<RelatorioEntity>
}