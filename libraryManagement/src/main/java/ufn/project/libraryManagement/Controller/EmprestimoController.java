package ufn.project.libraryManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufn.project.libraryManagement.Model.EmprestimoModel;
import ufn.project.libraryManagement.Service.EmprestimoService;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public ResponseEntity<EmprestimoModel> realizarEmprestimo(@RequestBody EmprestimoModel emprestimo) {
        EmprestimoModel novoEmprestimo = emprestimoService.realizarEmprestimo(emprestimo);
        return ResponseEntity.ok(novoEmprestimo);
    }

    @PostMapping("/devolucao/{id}")
    public ResponseEntity<Void> realizarDevolucao(@PathVariable Long id) {
        emprestimoService.realizarDevolucao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoModel>> buscarTodosEmprestimos() {
        List<EmprestimoModel> emprestimos = emprestimoService.buscarTodosEmprestimos();
        return ResponseEntity.ok(emprestimos);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
        return ResponseEntity.noContent().build();
    }

}
