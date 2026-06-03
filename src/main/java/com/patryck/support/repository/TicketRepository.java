package com.patryck.support.repository;
import com.patryck.support.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByStatus(TicketStatus status);
    List<Ticket> findByPriority(TicketPriority priority);
    List<Ticket> findByRequesterEmail(String email);
    List<Ticket> findByAssignedTo(String agent);
    Optional<Ticket> findByTicketNumber(String ticketNumber);
    List<Ticket> findByCategory(TicketCategory category);
}
