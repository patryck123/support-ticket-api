package com.patryck.support.controller;
import com.patryck.support.entity.*;
import com.patryck.support.repository.TicketRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
@RestController @RequestMapping("/api/tickets") @RequiredArgsConstructor
@Tag(name = "Suporte", description = "Sistema de chamados de suporte técnico")
public class TicketController {
    private final TicketRepository repo;
    @PostMapping @Operation(summary = "Abrir novo chamado")
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) { return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(ticket)); }
    @GetMapping public ResponseEntity<List<Ticket>> findAll() { return ResponseEntity.ok(repo.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Ticket> findById(@PathVariable Long id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/number/{number}") public ResponseEntity<Ticket> findByNumber(@PathVariable String number) { return repo.findByTicketNumber(number).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/status/{status}") public ResponseEntity<List<Ticket>> byStatus(@PathVariable TicketStatus status) { return ResponseEntity.ok(repo.findByStatus(status)); }
    @GetMapping("/priority/{priority}") public ResponseEntity<List<Ticket>> byPriority(@PathVariable TicketPriority priority) { return ResponseEntity.ok(repo.findByPriority(priority)); }
    @GetMapping("/requester/{email}") public ResponseEntity<List<Ticket>> byRequester(@PathVariable String email) { return ResponseEntity.ok(repo.findByRequesterEmail(email)); }
    @GetMapping("/agent/{agent}") public ResponseEntity<List<Ticket>> byAgent(@PathVariable String agent) { return ResponseEntity.ok(repo.findByAssignedTo(agent)); }
    @PatchMapping("/{id}/status") @Operation(summary = "Atualizar status do chamado")
    public ResponseEntity<Ticket> updateStatus(@PathVariable Long id, @RequestParam TicketStatus status) {
        return repo.findById(id).map(t -> {
            t.setStatus(status);
            if (status == TicketStatus.RESOLVED) t.setResolvedAt(LocalDateTime.now());
            return ResponseEntity.ok(repo.save(t));
        }).orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/{id}/assign") @Operation(summary = "Atribuir chamado a agente")
    public ResponseEntity<Ticket> assign(@PathVariable Long id, @RequestParam String agent) {
        return repo.findById(id).map(t -> { t.setAssignedTo(agent); t.setStatus(TicketStatus.IN_PROGRESS); return ResponseEntity.ok(repo.save(t)); }).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/comments") @Operation(summary = "Adicionar comentário ao chamado")
    public ResponseEntity<Ticket> addComment(@PathVariable Long id, @RequestBody TicketComment comment) {
        return repo.findById(id).map(t -> {
            comment.setTicket(t);
            t.getComments().add(comment);
            return ResponseEntity.ok(repo.save(t));
        }).orElse(ResponseEntity.notFound().build());
    }
}
