package com.projetai.development.refinement.application.refinement;

import com.projetai.core.infra.notification.NotificationRepository;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketRepository;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.development.develop.application.DevelopmentService;
import com.projetai.development.develop.application.dto.DeveloperDto;
import com.projetai.development.refinement.application.dto.RefinementDto;
import com.projetai.development.refinement.application.dto.TechLeadDto;
import com.projetai.development.refinement.domain.refinement.Refinement;
import com.projetai.development.refinement.domain.user.TechLead;
import com.projetai.development.refinement.infra.refinement.RefinementEntity;
import com.projetai.development.refinement.infra.refinement.RefinementRepository;
import com.projetai.development.refinement.infra.user.techLead.TechLeadEntity;
import com.projetai.development.refinement.infra.user.techLead.TechLeadRepository;
import com.projetai.development.utils.application.dto.AdjustmentsDto;
import com.projetai.development.utils.domain.user.developer.Developer;
import com.projetai.development.utils.exceptions.RefinementNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RefinementService {

    private final RefinementRepository refinementRepository;

    private final TicketRepository ticketRepository;

    private final DevelopmentService developmentService;

    private final NotificationRepository<SupportEntity> notificationRepository;

    private final TechLeadRepository techLeadRepository;

    public RefinementService(RefinementRepository refinementRepository, TicketRepository ticketRepository,
                             DevelopmentService developmentService,
                             NotificationRepository<SupportEntity> notificationRepository,
                             TechLeadRepository techLeadRepository) {
        this.refinementRepository = refinementRepository;
        this.ticketRepository = ticketRepository;
        this.developmentService = developmentService;
        this.notificationRepository = notificationRepository;
        this.techLeadRepository = techLeadRepository;
    }

    @Transactional
    public TechLeadDto createTechLead(TechLeadDto techLeadDto) {
        TechLeadEntity techLead = TechLead.dtoToEntity(techLeadDto);
        techLead.setId(null);

        return TechLead.dbEntityToDto(techLeadRepository.save(techLead));
    }

    @Transactional
    public void startRefinement(RefinementDto refinementDto) {
        Optional<TicketEntity> ticketOp = ticketRepository.findById(refinementDto.ticketId());

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        Refinement refinement = new Refinement(refinementDto.techLeadId(), refinementDto.developerId(),
                LocalDateTime.now(), ticketOp.get(), refinementDto.supportId());

        refinementRepository.save(refinement.startRefinement());

    }

    @Transactional
    public void completeRefinement(RefinementDto refinementDto) {
        Optional<RefinementEntity> refinementEntityOp = refinementRepository.findById(refinementDto.id());
        Optional<TicketEntity> ticketOp = ticketRepository.findById(refinementDto.ticketId());

        if (refinementEntityOp.isEmpty()) {
            throw new RefinementNotFoundException("Refinement not found");
        }

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        Refinement refinement = new Refinement(refinementDto.isApproved(), refinementDto.necessaryAdjustments(),
                refinementEntityOp.get().getTechLeadId(), refinementEntityOp.get().getDeveloperId(),
                refinementEntityOp.get().getStartedTime(), LocalDateTime.now(), ticketOp.get(), refinementDto.supportId());

        if (!refinementDto.isApproved()) {
            AdjustmentsDto adjustmentsDto = new AdjustmentsDto(refinementDto.developerId(), ticketOp.get().getId(),
                    refinementEntityOp.get().getNecessaryAdjustments(), refinementDto.techLeadId());

            developmentService.updateDevelopment(adjustmentsDto);
        } else {
            notificationRepository.save(refinement.makeNotificationToSupport());
        }

        refinementRepository.save(refinement.completeRefinement());

    }
}
