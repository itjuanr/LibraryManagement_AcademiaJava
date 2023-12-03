package ufn.project.libraryManagement.Service;

import org.springframework.stereotype.Service;

import ufn.project.libraryManagement.Model.LivroModel;
import ufn.project.libraryManagement.Repository.LivroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public LivroModel salvarLivro(LivroModel livro) {
        return livroRepository.save(livro);
    }

    public List<LivroModel> buscarTodosLivros() {
        return (List<LivroModel>) livroRepository.findAll();
    }

    public Optional<LivroModel> buscarLivroPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Optional<LivroModel> buscarLivroPorTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }
    
    public Optional<LivroModel> buscarLivroPorAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }
    
    public List<LivroModel> buscarLivroPorPreco(double preco) {
        return (List<LivroModel>) livroRepository.findByPreco(preco);
    }
    
    public Optional<LivroModel> buscarLivroPorGenero(String genero) {
        return livroRepository.findByGenero(genero);
    }
    
    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }

}
