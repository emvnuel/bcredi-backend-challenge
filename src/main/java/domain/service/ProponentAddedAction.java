package domain.service;

import domain.model.LoanProposal;
import domain.model.Proponent;
import domain.repository.LoanProposalRepository;

public class ProponentAddedAction implements Action {

    @Override
    public void process(IAbstractActionModel abstractActionModel) {
        Proponent proponent = (Proponent) abstractActionModel.toModel();
        LoanProposal loanProposal = LoanProposalRepository.findById(abstractActionModel.getProposalId());
        loanProposal.addProponent(proponent);
    }
}
