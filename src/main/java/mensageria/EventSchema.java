package mensageria;

import domain.model.Province;
import mensageria.dto.AbstractActionModel;
import mensageria.dto.ProponentCreate;
import mensageria.dto.ProposalCreate;
import mensageria.dto.WarrantyCreate;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

public enum EventSchema {

    PROPOSAL {
        @Override
        public AbstractActionModel toDTO(String message) {
            String[] spliced = message.split(",");
            String event_id = spliced[0];
            String event_schema = spliced[1];
            String event_action = spliced[2];
            String event_timestamp = spliced[3];
            String proposal_id = spliced[4];
            String proposal_loan_value = spliced[5];
            String proposal_number_of_monthly_installment = spliced[6];

            return new ProposalCreate(
                UUID.fromString(event_id),
                EventAction.valueOf("PROPOSAL_"+event_action.toUpperCase()),
                ZonedDateTime.parse(event_timestamp),
                UUID.fromString(proposal_id),
                new BigDecimal(proposal_loan_value),
                Integer.valueOf(proposal_number_of_monthly_installment)
            );
        }
    },
    WARRANTY {

        @Override
        public AbstractActionModel toDTO(String message) {

            String[] spliced = message.split(",");
            String event_id = spliced[0];
            String event_schema = spliced[1];
            String event_action = spliced[2];
            String event_timestamp = spliced[3];
            String proposal_id = spliced[4];
            String warranty_id = spliced[5];
            String warranty_value = spliced[6];
            String warranty_province = spliced[7];

            return new WarrantyCreate(
                    UUID.fromString(event_id),
                    EventAction.valueOf("WARRANTY_"+event_action.toUpperCase()),
                    ZonedDateTime.parse(event_timestamp),
                    UUID.fromString(proposal_id),
                    UUID.fromString(warranty_id),
                    new BigDecimal(warranty_value),
                    Province.valueOf(warranty_province.toUpperCase())
            );
        }
    },
    PROPONENT {
        @Override
        public AbstractActionModel toDTO(String message) {
            String[] spliced = message.split(",");
            String event_id = spliced[0];
            String event_schema = spliced[1];
            String event_action = spliced[2];
            String event_timestamp = spliced[3];
            String proposal_id = spliced[4];
            String proponent_id = spliced[5];
            String proponent_name = spliced[6];
            String proponent_age = spliced[7];
            String proponent_monthly_income = spliced[8];
            String proponent_is_main = spliced[9];

            return new ProponentCreate(
                    UUID.fromString(event_id),
                    EventAction.valueOf("PROPONENT_"+event_action.toUpperCase()),
                    ZonedDateTime.parse(event_timestamp),
                    UUID.fromString(proposal_id),
                    UUID.fromString(proponent_id),
                    proponent_name,
                    Integer.valueOf(proponent_age),
                    new BigDecimal(proponent_monthly_income),
                    Boolean.valueOf(proponent_is_main)
            );
        }
    };

    static EventSchema ofMessage(String message) {
        String[] splicedMessage = message.split(",");
        return valueOf(splicedMessage[1].toUpperCase());
    }


    public abstract AbstractActionModel toDTO(String message);
}
