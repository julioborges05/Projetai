package com.projetai.quality.ticket.infra.user.dev;


import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.UserInterface;
import jakarta.persistence.*;


@Entity(name = "Dev")
public class DevEntity extends UserEntity implements UserInterface {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    private boolean isAvailable;

    public DevEntity() {}

    public DevEntity(Dev dev) {
        this.id = dev.getId();
        this.name = dev.getName();
    }

    @Override
    public Long getId() {
        return id;
    }
}
