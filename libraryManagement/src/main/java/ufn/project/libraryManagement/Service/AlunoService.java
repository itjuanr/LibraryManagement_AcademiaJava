package ufn.project.libraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ufn.project.libraryManagement.Model.AlunoModel;
import ufn.project.libraryManagement.Repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository AlunoRepository;
    
    public AlunoService(AlunoRepository AlunoRepository) {
        this.AlunoRepository = AlunoRepository;
    }
    
    public AlunoModel salvarAluno(AlunoModel aluno) {
        return AlunoRepository.save(aluno);
    }
    
    public List<AlunoModel> buscarTodosAlunos() {
        return (List<AlunoModel>) AlunoRepository.findAll();
    }

    public Optional<AlunoModel> buscarAlunoPorNome(String nome) {
        return AlunoRepository.findByNome(nome);
    }
    
    public Optional<AlunoModel> buscarAlunoPorId(Long id) {
        return AlunoRepository.findById(id);
    }
    
    public Optional<AlunoModel> buscarAlunoPorMatricula(String  matricula) {
        return AlunoRepository.findByMatricula(matricula);
    }
    
    public void deletarAluno(Long id) {
        AlunoRepository.deleteById(id);
    }
}
