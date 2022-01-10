package br.com.dhan.repositories

import br.com.dhan.entity.ParametroEntity
import org.springframework.data.cassandra.core.mapping.CassandraPersistentEntity
import org.springframework.data.cassandra.repository.CassandraRepository
import java.util.*

interface ParametroRepository : CassandraRepository<ParametroEntity, UUID> {
}