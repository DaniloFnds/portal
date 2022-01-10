package br.com.dhan.relatorios.service

import br.com.dhan.entity.ParametroEntity
import br.com.dhan.entity.RelatorioEntity
import br.com.dhan.relatorios.controller.dto.NovoRelatorioRequest
import br.com.dhan.relatorios.controller.dto.ParametroRelatorio
import java.util.*

fun toRelatorioEntity(novoRelatorioRequest: NovoRelatorioRequest): RelatorioEntity {
    var randomUUID = UUID.randomUUID()
    return RelatorioEntity(
        id = randomUUID,
        nomeRelatorio = novoRelatorioRequest.nomeRelatorio,
        tipoRelatorio = novoRelatorioRequest.tipoRelatorio,
        usuario = novoRelatorioRequest.usuario
    )
}


fun toParametroEntityList(parametroRelatorio: List<ParametroRelatorio>, idRelatorio: UUID): List<ParametroEntity> {
    return parametroRelatorio.map {
        ParametroEntity(
            id = UUID.randomUUID(),
            nomeParametro = it.nomeParametro,
            valorParametro = it.valorParametro,
            relatorio = idRelatorio
        )
    }
}

fun toParametroEntity(parametroRelatorio: ParametroRelatorio, idRelatorio: UUID): ParametroEntity {
    return ParametroEntity(
        id = UUID.randomUUID(),
        nomeParametro = parametroRelatorio.nomeParametro,
        valorParametro = parametroRelatorio.valorParametro,
        relatorio = idRelatorio
    )
}
