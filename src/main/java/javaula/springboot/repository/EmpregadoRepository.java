package javaula.springboot.repository;

import java.util.List;
import java.util.Optional;

import javaula.springboot.model.Empregado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author prjunior
 * @version $Revision: $<br/>
 * $Id: $
 * @since 29/08/18 10:33
 */
@Repository
public interface EmpregadoRepository extends CrudRepository<Empregado, Long> {

    List<Empregado> findByNomeOrderByDataNascimentoAsc(String nome);

    Optional<Empregado> findByNomeAndDepartamento(String nome, String departamento);

}
