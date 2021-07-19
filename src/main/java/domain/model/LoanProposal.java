package domain.model;

import domain.validation.ValidLoan;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@ValidLoan
public class LoanProposal {

    private UUID id;

    @DecimalMin("30000.00")
    @DecimalMax("3000000.00")
    private BigDecimal value;

    @Min(24)
    @Max(180)
    private Integer numberOfMonthlyInstallments;

    @NotEmpty
    @Size(min = 1)
    private Set<@Valid Warranty> warranties = new HashSet<>();

    @NotEmpty
    @Size(min = 2)
    private Set<@Valid Proponent> proponents = new HashSet<>();

    public LoanProposal(UUID id, BigDecimal value, Integer numberOfMonthlyInstallments) {
        this.id = id;
        this.value = value;
        this.numberOfMonthlyInstallments = numberOfMonthlyInstallments;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Integer getNumberOfMonthlyInstallments() {
        return numberOfMonthlyInstallments;
    }

    public Set<Warranty> getWarranties() {
        return Collections.unmodifiableSet(warranties);
    }

    public Set<Proponent> getProponents() {
        return Collections.unmodifiableSet(proponents);
    }

    public void addWarranty(Warranty warranty) {
        this.warranties.add(warranty);
    }

    public void addProponent(Proponent proponent) {
        this.proponents.add(proponent);
    }

    public Proponent getMainProponent() {
        return this.proponents.stream().filter(Proponent::getMain).findFirst().get();
    }

    public Long getNumberOfMainProponents() {
        return this.proponents.stream().filter(Proponent::getMain).count();
    }

    public BigDecimal getMonthlyInstallmentsAmount() {
        return value.divide(BigDecimal.valueOf(numberOfMonthlyInstallments), RoundingMode.HALF_UP);
    }

    public BigDecimal sumOfAcceptWarranties() {
        return this.warranties.stream()
                .map(Warranty::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanProposal that = (LoanProposal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
