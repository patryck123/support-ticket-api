package com.patryck.support.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity @Table(name = "tickets") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, unique = true) private String ticketNumber;
    @Column(nullable = false) private String title;
    @Column(columnDefinition = "TEXT", nullable = false) private String description;
    @Column(nullable = false) private String requesterName;
    @Column(nullable = false) private String requesterEmail;
    @Enumerated(EnumType.STRING) @Builder.Default private TicketStatus status = TicketStatus.OPEN;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private TicketPriority priority;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private TicketCategory category;
    private String assignedTo;
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.EAGER) private List<TicketComment> comments;
    private LocalDateTime resolvedAt;
    @Column(nullable = false, updatable = false) private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @PrePersist protected void onCreate() {
        createdAt = LocalDateTime.now(); updatedAt = LocalDateTime.now();
        ticketNumber = "TKT-" + System.currentTimeMillis();
    }
    @PreUpdate protected void onUpdate() { updatedAt = LocalDateTime.now(); }
}
