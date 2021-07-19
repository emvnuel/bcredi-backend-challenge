package mensageria.dto;

import mensageria.EventAction;
import domain.service.IAbstractActionModel;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public abstract class AbstractActionModel implements IAbstractActionModel {

    protected UUID eventId;
    protected EventAction eventActionAction;
    protected ZonedDateTime timestamp;
    protected UUID proposalId;

    protected AbstractActionModel(UUID eventId, EventAction action, ZonedDateTime timestamp, UUID proposalId) {
        this.eventId = eventId;
        this.eventActionAction = action;
        this.timestamp = timestamp;
        this.proposalId = proposalId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public EventAction getEventAction() {
        return eventActionAction;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public UUID getProposalId() {
        return proposalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractActionModel that = (AbstractActionModel) o;
        return Objects.equals(eventId, that.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }

    @Override
    public void process() {
        this.eventActionAction.process(this);
    }

    public abstract Object toModel();

}
