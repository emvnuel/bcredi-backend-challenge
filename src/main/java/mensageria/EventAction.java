package mensageria;

import domain.model.Proponent;
import domain.service.*;

public enum EventAction {

    PROPOSAL_CREATED(EventSchema.PROPOSAL, new ProposalCreateAction()),
    PROPOSAL_UPDATED(EventSchema.PROPOSAL, null),
    PROPOSAL_DELETED(EventSchema.PROPOSAL, null),
    WARRANTY_ADDED(EventSchema.WARRANTY, new WarrantyAddedAction()),
    WARRANTY_UPDATED(EventSchema.WARRANTY, null),
    WARRANTY_REMOVED(EventSchema.WARRANTY, null),
    PROPONENT_ADDED(EventSchema.PROPONENT, new ProponentAddedAction()),
    PROPONENT_UPDATED(EventSchema.PROPONENT, null),
    PROPONENT_REMOVED(EventSchema.PROPONENT, null);

    private final EventSchema actionType;
    private final Action action;

    EventAction(EventSchema actionType, Action action) {
        this.actionType = actionType;
        this.action = action;
    }

    public EventSchema getActionType() {
        return actionType;
    }

    public void process(IAbstractActionModel model) {
        action.process(model);
    }
}
