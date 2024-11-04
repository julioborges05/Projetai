package com.projetai.development.develop.application;

import com.projetai.core.infra.comment.CommentRepository;
import com.projetai.core.infra.notification.NotificationRepository;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketRepository;
import com.projetai.development.develop.application.dto.CommentDto;
import com.projetai.development.develop.application.dto.DeveloperDto;
import com.projetai.development.develop.application.dto.DevelopmentDto;
import com.projetai.development.develop.application.dto.EstimatedHoursDto;
import com.projetai.development.develop.domain.comment.Comment;
import com.projetai.development.develop.domain.development.Development;
import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import com.projetai.development.develop.domain.development.type.DevelopmentType;
import com.projetai.development.develop.infra.development.DevelopmentEntity;
import com.projetai.development.develop.infra.development.DevelopmentRepository;
import com.projetai.development.refinement.infra.user.techLead.TechLeadEntity;
import com.projetai.development.utils.application.dto.AdjustmentsDto;
import com.projetai.development.utils.domain.user.developer.Developer;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.developer.DeveloperRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DevelopmentService {

    private final DevelopmentRepository developmentRepository;
    private final DeveloperRepository developerRepository;

    private final NotificationRepository<DeveloperEntity> notificationDeveloperRepository;

    private final NotificationRepository<TechLeadEntity> notificationTechLeadRepository;

    private final TicketRepository ticketRepository;

    private final CommentRepository commentRepository;

    @Autowired
    public DevelopmentService(DevelopmentRepository developmentRepository, DeveloperRepository developerRepository,
                              NotificationRepository<DeveloperEntity> notificationDeveloperRepository,
                              NotificationRepository<TechLeadEntity> notificationTechLeadRepository,
                              TicketRepository ticketRepository, CommentRepository commentRepository) {
        this.developmentRepository = developmentRepository;
        this.developerRepository = developerRepository;
        this.notificationDeveloperRepository = notificationDeveloperRepository;
        this.notificationTechLeadRepository = notificationTechLeadRepository;
        this.ticketRepository = ticketRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public DeveloperDto createDeveloper(DeveloperDto developerDto) {
        DeveloperEntity developer = Developer.dtoToEntity(developerDto);
        developer.setId(null);

        return Developer.dbEntityToDto(developerRepository.save(developer));
    }

    @Transactional
    public void addEstimatedHours(EstimatedHoursDto estimatedHoursDto) {
        Optional<TicketEntity> ticketOp = ticketRepository.findById(estimatedHoursDto.ticketId());

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        Development development = new Development(estimatedHoursDto.developerId(), ticketOp.get(),
                estimatedHoursDto.estimatedHours());

        developmentRepository.save(development.addEstimatedHours());

    }

    @Transactional
    public void startDevelopment(DevelopmentDto developmentDto) {
        Optional<TicketEntity> ticketOp = ticketRepository.findById(developmentDto.ticketId());
        Optional<DevelopmentEntity> developmentEntityOP = developmentRepository.findById(developmentDto.id());

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        if (developmentEntityOP.isEmpty()) {
            throw new RuntimeException("Development not found");
        }

        Development development = new Development(developmentEntityOP.get().getId(),
                developmentEntityOP.get().getDeveloperId(), developmentDto.developmentType(),
                DevelopmentStatus.IN_PROGRESS, LocalDateTime.now(), ticketOp.get(), developmentEntityOP.get().getEstimatedHours());

        developmentRepository.save(development.startDevelopment());
    }

    @Transactional
    public void addDetailsToTicket(CommentDto commentDto) {
        Optional<TicketEntity> ticketOp = ticketRepository.findById(commentDto.ticketId());

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        Comment comment = new Comment(commentDto.message(), ticketOp.get(), commentDto.userId());

        commentRepository.save(comment.addComment());

    }

    @Transactional
    public void completeDevelopment(DevelopmentDto developmentDto) {
        Optional<DevelopmentEntity> developmentEntityOP = developmentRepository.findById(developmentDto.id());
        Optional<TicketEntity> ticketOp = ticketRepository.findById(developmentDto.ticketId());

        if (developmentEntityOP.isEmpty()) {
            throw new RuntimeException("Development not found");
        }

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        Development development = new Development(developmentEntityOP.get().getId(), developmentEntityOP.get().getType(),
                DevelopmentStatus.FINISHED, developmentDto.developerId(), ticketOp.get(),
                developmentEntityOP.get().getStartedTime(), developmentDto.finishedTime(), developmentDto.techLeadId(),
                developmentEntityOP.get().getEstimatedHours());

        developmentRepository.save(development.completeDevelopment());

        notificationTechLeadRepository.save(development.makeNotificationToTechLead());
    }

    @Transactional
    public void makeAdjustments(AdjustmentsDto adjustmentsDto) {
       Optional<DeveloperEntity> developerOp = developerRepository.findById(adjustmentsDto.developerId());
        Optional<TicketEntity> ticketOp = ticketRepository.findById(adjustmentsDto.ticketId());

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        if (developerOp.isEmpty()) {
            throw new RuntimeException("Developer not found");
        }

        Development development = new Development(adjustmentsDto.developerId(), DevelopmentType.NECESSARY_ADJUSTMENTS,
                DevelopmentStatus.ON_HOLD, LocalDateTime.now(), ticketOp.get(), adjustmentsDto.techLeadId());

        notificationDeveloperRepository.save(development.makeNotificationToDev(adjustmentsDto.necessaryAdjustments(), developerOp.get()));

        developmentRepository.save(development.makeAdjustments());

    }
}
