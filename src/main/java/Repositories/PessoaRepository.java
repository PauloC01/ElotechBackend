package Repositories;

import Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends
        JpaRepository<Pessoa, Integer>,
        JpaSpecificationExecutor<Pessoa>,
        PagingAndSortingRepository<Pessoa, Integer>
{ }
