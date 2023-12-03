package ufn.project.libraryManagement.Service;

import org.springframework.stereotype.Service;

import ufn.project.libraryManagement.Model.AlunoModel;
import ufn.project.libraryManagement.Model.EmprestimoModel;
import ufn.project.libraryManagement.Model.LivroModel;
import ufn.project.libraryManagement.Repository.EmprestimoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public EmprestimoModel realizarEmprestimo(EmprestimoModel emprestimo) {
        if (livroJaEmprestado(emprestimo.getLivro())) {
            throw new RuntimeException("Livro já emprestado");
        }

        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(15));

        return emprestimoRepository.save(emprestimo);
    }

    public void realizarDevolucao(Long emprestimoId) {
        Optional<EmprestimoModel> emprestimoOptional = emprestimoRepository.findById(emprestimoId);
        if (emprestimoOptional.isPresent()) {
            EmprestimoModel emprestimo = emprestimoOptional.get();

            LocalDate dataDevolucaoReal = LocalDate.now();

            if (emprestimo.getDataDevolucao().isBefore(dataDevolucaoReal)) {
                long diasAtraso = emprestimo.getDataDevolucao().until(dataDevolucaoReal).getDays();
                double multa = diasAtraso * 2.00;
                System.out.println("Multa de R$ " + multa + " devida devido ao atraso na devolução.");
            }

            emprestimoRepository.delete(emprestimo);
        } else {
            throw new RuntimeException("Empréstimo não encontrado");
        }
    }

    public List<EmprestimoModel> buscarTodosEmprestimos() {
        return (List<EmprestimoModel>) emprestimoRepository.findAll();
    }

    private boolean livroJaEmprestado(LivroModel livro) {
        List<EmprestimoModel> emprestimos = emprestimoRepository.findByLivro(livro);
        return !emprestimos.isEmpty();
    }

    public List<EmprestimoModel> buscarEmprestimosPorLivro(LivroModel livro) {
        return emprestimoRepository.findByLivro(livro);
    }

    public List<EmprestimoModel> buscarEmprestimosPorAluno(AlunoModel aluno) {
        return emprestimoRepository.findByAluno(aluno);
    }

    public void deletarEmprestimo(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
