package mensageria.dto;

import domain.model.Proponent;
import mensageria.EventAction;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public class ProponentCreate extends AbstractActionModel {

    private UUID proponentId;
    private String name;
    private Integer age;
    private BigDecimal monthlyIncome;
    private Boolean isMain;

    public ProponentCreate(UUID eventId,
                           EventAction action,
                           ZonedDateTime timestamp,
                           UUID proposalId,
                           UUID proponentId,
                           String name,
                           Integer age,
                           BigDecimal monthlyIncome,
                           Boolean isMain) {
        super(eventId, action, timestamp, proposalId);
        this.proponentId = proponentId;
        this.name = name;
        this.age = age;
        this.monthlyIncome = monthlyIncome;
        this.isMain = isMain;
    }

    public Proponent toModel() {
        return new Proponent(this.proponentId, this.name, this.age, this.monthlyIncome, this.isMain);
    }
}
