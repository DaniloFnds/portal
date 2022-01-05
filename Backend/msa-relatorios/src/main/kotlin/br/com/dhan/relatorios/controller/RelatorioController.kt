package br.com.dhan.relatorios.controller

import br.com.dhan.entity.RelatorioEntity
import br.com.dhan.relatorios.service.RelatorioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("relatorios")
@CrossOrigin("*")
class RelatorioController(
    var relatorioService: RelatorioService
) {

    @GetMapping
    fun getAllRelatorios(): List<RelatorioEntity> {
        return this.relatorioService.getAllRelatorios()
    }

    @PostMapping
    fun createRelatorio() {

    }
}