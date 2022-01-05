package br.com.dhan.repositories

import br.com.dhan.entity.RelatorioEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import java.util.*

interface RelatorioRepository : CassandraRepository<RelatorioEntity, UUID> {
}