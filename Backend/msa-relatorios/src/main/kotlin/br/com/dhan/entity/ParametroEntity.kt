package br.com.dhan.entity

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table("parametro")
class ParametroEntity(
    @PrimaryKey
    val id: UUID,
    @Column("nome_parametro")
    val nomeParametro: String,
    @Column("valor_parametro")
    val valorParametro: String,
    @Column("relatorio")
    val relatorio: UUID
) {
}