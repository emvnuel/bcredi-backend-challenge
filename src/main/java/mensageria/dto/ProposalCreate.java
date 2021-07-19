package mensageria.dto;

import domain.model.LoanProposal;
import mensageria.EventAction;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ProposalCreate extends AbstractActionModel {

    private BigDecimal value;
    private Integer numberOfMonthlyInstallments;

    public ProposalCreate(UUID eventId, EventAction action, ZonedDateTime timestamp, UUID proposalId, BigDecimal value, Integer numberOfMonthlyInstallments) {
        super(eventId, action, timestamp, proposalId);
        this.value = value;
        this.numberOfMonthlyInstallments = numberOfMonthlyInstallments;
    }

    public LoanProposal toModel() {
        return new LoanProposal(this.proposalId, this.value, this.numberOfMonthlyInstallments);
    }
}
