package com.projetai.development.refinement.domain.refinement;

import java.time.LocalDateTime;

public class Refinement {

    private boolean isApproved;

    private String necessaryAdjustments;

    private String techLeadUsername;

    private LocalDateTime spendedTime;

    public void makeTicketApproved() {
        this.isApproved = true;
    }

    public void makeTicketRepproved() {
        this.isApproved = true;
    }
}
