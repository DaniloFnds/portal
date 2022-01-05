package br.com.dhan.relatorios.service.impl

import br.com.dhan.entity.RelatorioEntity
import br.com.dhan.relatorios.service.RelatorioService
import br.com.dhan.repositories.RelatorioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RelatorioServiceImpl(
    @Autowired var relatorioRepository: RelatorioRepository
) : RelatorioService {

    override fun getAllRelatorios(): List<RelatorioEntity> {
        return this.relatorioRepository.findAll()
    }
}