package com.projetai.core.infra.ticket;


import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    Page<TicketEntity> findByTicketStatusNot(TicketStatus ticketStatus, Pageable pageable);
}
