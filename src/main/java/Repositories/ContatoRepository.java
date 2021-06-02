package Repositories;

import Model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContatoRepository extends
        JpaRepository<Contato, Integer>,
        JpaSpecificationExecutor<Contato>,
        PagingAndSortingRepository<Contato, Integer> {
}
