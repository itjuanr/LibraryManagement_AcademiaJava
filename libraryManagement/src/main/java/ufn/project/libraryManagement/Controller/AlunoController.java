package ufn.project.libraryManagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ufn.project.libraryManagement.Model.AlunoModel;
import ufn.project.libraryManagement.Service.AlunoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<AlunoModel>> buscarTodosAlunos() {
        List<AlunoModel> alunos = alunoService.buscarTodosAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoModel> buscarAlunoPorId(@PathVariable Long id) {
        Optional<AlunoModel> aluno = alunoService.buscarAlunoPorId(id);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoModel> salvarAluno(@RequestBody AlunoModel aluno) {
        AlunoModel novoAluno = alunoService.salvarAluno(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
