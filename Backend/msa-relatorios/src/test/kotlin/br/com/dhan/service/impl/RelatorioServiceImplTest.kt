package br.com.dhan.service.impl

import br.com.dhan.relatorios.service.impl.RelatorioServiceImpl
import br.com.dhan.repositories.RelatorioRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Test


class RelatorioServiceImplTest {

    @MockK
    private lateinit var relatorioService: RelatorioServiceImpl

    @Before("algo")
    fun setup() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun deve_criar_um_relatorio_retornar_sucesso() {
        relatorioService.getAllRelatorios()
        println()
    }
}