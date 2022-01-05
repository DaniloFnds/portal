package br.com.dhan.entity

import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.jpa.domain.AbstractPersistable
import java.io.Serializable
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@org.springframework.data.cassandra.core.mapping.Table("relatorio")
class RelatorioEntity(

    @PrimaryKey
    var id: UUID,

    @Column("nome_relatorio")
    var nomeRelatorio: String? = null,

    @Column("tipo_relatorio")
    var tipoRelatorio: String? = null
) : Serializable {}