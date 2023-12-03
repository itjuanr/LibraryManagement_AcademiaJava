package ufn.project.libraryManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufn.project.libraryManagement.Model.LivroModel;
import ufn.project.libraryManagement.Service.LivroService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> buscarTodosLivros() {
        List<LivroModel> livros = livroService.buscarTodosLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarLivroPorId(@PathVariable Long id) {
        Optional<LivroModel> livro = livroService.buscarLivroPorId(id);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LivroModel> salvarLivro(@RequestBody LivroModel livro) {
        LivroModel novoLivro = livroService.salvarLivro(livro);
        return ResponseEntity.ok(novoLivro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscarPorTitulo/{titulo}")
    public ResponseEntity<LivroModel> buscarLivroPorTitulo(@PathVariable String titulo) {
        Optional<LivroModel> livro = livroService.buscarLivroPorTitulo(titulo);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/buscarPorAutor/{autor}")
    public ResponseEntity<LivroModel> buscarLivroPorAutor(@PathVariable String autor) {
        Optional<LivroModel> livro = livroService.buscarLivroPorAutor(autor);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/buscarPorPreco/{preco}")
    public ResponseEntity<List<LivroModel>> buscarLivroPorPreco(@PathVariable double preco) {
        List<LivroModel> livros = livroService.buscarLivroPorPreco(preco);
        return livros.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(livros);
    }
    
    @GetMapping("/buscarPorGenero/{genero}")
    public ResponseEntity<LivroModel> buscarLivroPorGenero(@PathVariable String genero) {
        Optional<LivroModel> livro = livroService.buscarLivroPorGenero(genero);
        return livro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
