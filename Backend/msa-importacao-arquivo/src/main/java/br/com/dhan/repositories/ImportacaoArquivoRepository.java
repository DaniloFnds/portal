package br.com.dhan.repositories;

import br.com.dhan.entity.ImportacaoArquivoEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ImportacaoArquivoRepository extends CassandraRepository<ImportacaoArquivoEntity, UUID> {
}
