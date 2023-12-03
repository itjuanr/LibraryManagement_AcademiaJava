package ufn.project.libraryManagement.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ufn.project.libraryManagement.Model.AlunoModel;
import ufn.project.libraryManagement.Model.EmprestimoModel;
import ufn.project.libraryManagement.Model.LivroModel;

public interface EmprestimoRepository extends JpaRepository<EmprestimoModel, Long>{
	
    List<EmprestimoModel> findByLivro(LivroModel livro);
    List<EmprestimoModel> findByAluno(AlunoModel aluno);
}
