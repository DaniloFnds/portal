package br.com.dhan.entity

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.io.Serializable
import java.util.*

@Table("relatorio")
class RelatorioEntity(

    @PrimaryKey
    val id: UUID,

    @Column("nome_relatorio")
    val nomeRelatorio: String,

    @Column("tipo_relatorio")
    val tipoRelatorio: String,

    @Column("usuario")
    val usuario: String

) : Serializable {
    val parametros: List<ParametroEntity>? = null
}