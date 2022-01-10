package br.com.dhan.relatorios.service.impl

import br.com.dhan.relatorios.controller.dto.ParametroRelatorio
import br.com.dhan.relatorios.service.ParametroService
import br.com.dhan.relatorios.service.toParametroEntity
import br.com.dhan.relatorios.service.toParametroEntityList
import br.com.dhan.repositories.ParametroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ParametroServiceImpl(
    @Autowired var parametroRepository: ParametroRepository
) : ParametroService {

    override fun create(parametroRelatorio: ParametroRelatorio, idRelatorio: UUID) {
        this.parametroRepository.save(
            toParametroEntity(parametroRelatorio, idRelatorio)
        )
    }

    override fun create(parametroRelatorios: List<ParametroRelatorio>, idRelatorio: UUID) {
        this.parametroRepository.saveAll(
            toParametroEntityList(parametroRelatorios, idRelatorio)
        )
    }
}