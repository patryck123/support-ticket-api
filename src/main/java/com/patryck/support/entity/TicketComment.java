package com.patryck.support.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity @Table(name = "ticket_comments") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class TicketComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "ticket_id") private Ticket ticket;
    @Column(nullable = false) private String authorName;
    @Column(columnDefinition = "TEXT", nullable = false) private String content;
    @Builder.Default private Boolean isInternal = false;
    @Column(nullable = false, updatable = false) private LocalDateTime createdAt;
    @PrePersist protected void onCreate() { createdAt = LocalDateTime.now(); }
}
