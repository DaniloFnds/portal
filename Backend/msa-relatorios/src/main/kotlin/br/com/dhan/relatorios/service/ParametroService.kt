package br.com.dhan.relatorios.service

import br.com.dhan.relatorios.controller.dto.ParametroRelatorio
import java.util.*

interface ParametroService {

    fun create(parametroRelatorio: ParametroRelatorio, idRelatorio: UUID)

    fun create(parametroRelatorios: List<ParametroRelatorio>, idRelatorio: UUID)
}