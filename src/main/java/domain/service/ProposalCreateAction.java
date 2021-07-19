package domain.service;

import domain.model.LoanProposal;
import domain.repository.LoanProposalRepository;

public class ProposalCreateAction implements Action {

    @Override
    public void process(IAbstractActionModel abstractActionModel) {
        LoanProposal loanProposal = (LoanProposal) abstractActionModel.toModel();
        LoanProposalRepository.save(loanProposal);
    }
}
