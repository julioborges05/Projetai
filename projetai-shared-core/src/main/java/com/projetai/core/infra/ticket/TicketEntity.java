package com.projetai.core.infra.ticket;

import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "ticket")
public class TicketEntity {

    @Id
    @SequenceGenerator(name = "ticket_id_seq", sequenceName = "ticket_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "ticket_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    @Column(name = "client_id")
    private Long clientId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TicketType ticketType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TicketStatus ticketStatus;

    @Column(name = "contact_id")
    private Long contactId;

    @Column(name = "dev_id")
    private Long devId;

    public TicketEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public Long getDevId() {
        return devId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setDevId(Long devId){
        this.devId = devId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(title, that.title)
                && Objects.equals(description, that.description)
                && Objects.equals(clientId, that.clientId)
                && Objects.equals(ticketType, that.ticketType)
                && ticketStatus == that.ticketStatus
                && Objects.equals(contactId, that.contactId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, clientId, ticketType, ticketStatus, contactId);
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", clientId=" + clientId +
                ", ticketType='" + ticketType + '\'' +
                ", ticketStatus=" + ticketStatus +
                ", contactId=" + contactId +
                '}';
    }

}