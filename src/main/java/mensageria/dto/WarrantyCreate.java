package mensageria.dto;

import domain.model.Province;
import domain.model.Warranty;
import mensageria.EventAction;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public class WarrantyCreate extends AbstractActionModel {

    private UUID id;
    private BigDecimal value;
    private Province province;


    public WarrantyCreate(UUID eventId, EventAction action, ZonedDateTime timestamp, UUID proposalId, UUID id, BigDecimal value, Province province) {
        super(eventId, action, timestamp, proposalId);
        this.id = id;
        this.value = value;
        this.province = province;
    }

    public Warranty toModel() {
        return new Warranty(this.id, this.value, this.province);
    }
}
