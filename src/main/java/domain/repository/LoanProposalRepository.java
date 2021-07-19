package domain.repository;

import domain.model.LoanProposal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class LoanProposalRepository {

    private static List<LoanProposal> loanProposals = new ArrayList<>();

    public static void save(LoanProposal loanProposal) {
        loanProposals.add(loanProposal);
    }

    public static LoanProposal findById(UUID id) {
        return loanProposals.stream().filter(loanProposal -> loanProposal.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public static List<LoanProposal> findAll() {
        return Collections.unmodifiableList(loanProposals);
    }

    public static void clear() {
        loanProposals = new ArrayList<>();
    }
}
