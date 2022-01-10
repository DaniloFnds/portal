package br.com.dhan.relatorios.service.impl

import br.com.dhan.entity.RelatorioEntity
import br.com.dhan.relatorios.controller.dto.NovoRelatorioRequest
import br.com.dhan.relatorios.service.ParametroService
import br.com.dhan.relatorios.service.RelatorioService
import br.com.dhan.relatorios.service.toRelatorioEntity
import br.com.dhan.repositories.ParametroRepository
import br.com.dhan.repositories.RelatorioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RelatorioServiceImpl(
    @Autowired var relatorioRepository: RelatorioRepository,
    @Autowired var parametroService: ParametroService
) : RelatorioService {

    override fun getAllRelatorios(): List<RelatorioEntity> {
        return this.relatorioRepository.findAll()
    }

    override fun createRelatorio(novoRelatorio: NovoRelatorioRequest) {
        val relatorioEntity = toRelatorioEntity(novoRelatorio)
        this.relatorioRepository.save(
            relatorioEntity
        )

    }
}