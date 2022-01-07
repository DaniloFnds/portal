package br.com.dhan.importacaoarquivo.adapter.jpa.repository;

import br.com.dhan.importacaoarquivo.adapter.jpa.entity.ImportacaoArquivoEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ImportacaoArquivoRepository extends CassandraRepository<ImportacaoArquivoEntity, UUID> {
}
