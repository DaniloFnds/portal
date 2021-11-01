package br.com.dhan.repositories;

import br.com.dhan.entity.OperacaoRecebivel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperacaoRecebivelRepository extends CassandraRepository<OperacaoRecebivel, UUID> {
}
