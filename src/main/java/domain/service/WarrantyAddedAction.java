package domain.service;

import domain.model.LoanProposal;
import domain.model.Warranty;
import domain.repository.LoanProposalRepository;

public class WarrantyAddedAction implements Action {

    @Override
    public void process(IAbstractActionModel abstractActionModel) {
        Warranty warranty = (Warranty) abstractActionModel.toModel();
        LoanProposal loanProposal = LoanProposalRepository.findById(abstractActionModel.getProposalId());
        loanProposal.addWarranty(warranty);
    }
}
