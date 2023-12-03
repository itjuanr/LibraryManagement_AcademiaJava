package ufn.project.libraryManagement.Repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import ufn.project.libraryManagement.Model.AlunoModel;

public interface AlunoRepository extends CrudRepository<AlunoModel, Long> {
	
    Optional<AlunoModel> findByNome(String nome);
    Optional<AlunoModel> findByMatricula(String matricula);
}