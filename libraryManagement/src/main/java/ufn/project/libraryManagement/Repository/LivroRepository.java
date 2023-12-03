package ufn.project.libraryManagement.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import ufn.project.libraryManagement.Model.LivroModel;

public interface LivroRepository extends CrudRepository<LivroModel, Long> {

    Optional<LivroModel> findByTitulo(String titulo);
    Optional<LivroModel> findByAutor(String autor);
    Optional<LivroModel> findByGenero(String genero);
    List<LivroModel> findByPreco(double preco);
}
