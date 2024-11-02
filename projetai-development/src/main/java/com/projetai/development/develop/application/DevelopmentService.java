package com.projetai.development.develop.application;

import com.projetai.core.infra.notification.NotificationRepository;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketRepository;
import com.projetai.development.develop.application.dto.DeveloperDto;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.development.develop.application.dto.DevelopmentDto;
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

    @Autowired
    public DevelopmentService(DevelopmentRepository developmentRepository, DeveloperRepository developerRepository,
                              NotificationRepository<DeveloperEntity> notificationDeveloperRepository,
                              NotificationRepository<TechLeadEntity> notificationTechLeadRepository,
                              TicketRepository ticketRepository) {
        this.developmentRepository = developmentRepository;
        this.developerRepository = developerRepository;
        this.notificationDeveloperRepository = notificationDeveloperRepository;
        this.notificationTechLeadRepository = notificationTechLeadRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public DeveloperDto createDeveloper(DeveloperDto developerDto) {
        DeveloperEntity developer = Developer.dtoToEntity(developerDto);
        developer.setId(null);

        return Developer.dbEntityToDto(developerRepository.save(developer));
    }

    public void startDevelopment(DevelopmentDto developmentDto) {
        Optional<TicketEntity> ticketOp = ticketRepository.findById(developmentDto.ticketId());

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        Development development = new Development(developmentDto.developerId(), developmentDto.developmentType(),
                DevelopmentStatus.IN_PROGRESS, LocalDateTime.now(), ticketOp.get());

        developmentRepository.save(development.startDevelopment());
        //notificationRepository.save(development.makeNotification());
    }

    public void completeDevelopment(DevelopmentDto developmentDto) {
        Optional<DevelopmentEntity> developmentEntityOP = developmentRepository.findById(developmentDto.id());
        Optional<TicketEntity> ticketOp = ticketRepository.findById(developmentDto.ticketId());

        if (developmentEntityOP.isEmpty()) {
            throw new RuntimeException("Development not found");
        }

        if (ticketOp.isEmpty()) {
            throw new RuntimeException("Ticket not found");
        }

        Development development = new Development(developmentDto.id(), developmentDto.developmentType(),
                DevelopmentStatus.FINISHED, developmentDto.developerId(), ticketOp.get(),
                developmentEntityOP.get().getStartedTime(), LocalDateTime.now(), developmentDto.techLeadId());

        developmentRepository.save(development.completeDevelopment());

        notificationTechLeadRepository.save(development.makeNotificationToTechLead());
    }

    public void updateDevelopment(AdjustmentsDto adjustmentsDto) {
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

        developmentRepository.save(development.startDevelopment());

    }
}
