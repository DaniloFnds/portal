package br.com.dhan.repositories;

import br.com.dhan.entity.ArquivoEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ArquivoRepository extends CassandraRepository<ArquivoEntity, UUID> {
}
