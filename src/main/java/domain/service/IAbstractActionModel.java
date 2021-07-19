package domain.service;

import mensageria.EventAction;

import java.time.ZonedDateTime;
import java.util.UUID;

public interface IAbstractActionModel {

    UUID getEventId();
    EventAction getEventAction();
    ZonedDateTime getTimestamp();
    UUID getProposalId();
    Object toModel();
    void process();
}
