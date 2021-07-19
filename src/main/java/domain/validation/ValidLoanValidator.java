package domain.validation;

import domain.model.LoanProposal;
import domain.model.Proponent;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;

public class ValidLoanValidator implements ConstraintValidator<ValidLoan, LoanProposal> {

    @Override
    public void initialize(ValidLoan constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LoanProposal loan, ConstraintValidatorContext context) {
        //A soma do valor das garantias deve ser maior ou igual ao dobro do valor do empréstimo
        return isMainProponentUnique(loan)
                && isSumOfWarrantyGreaterThanOrEqualDoubleTheLoanAmount(loan)
                && isProponentIncomeCompatibleWithMonthlyInstallmentsAmount(loan);
    }

    private boolean isMainProponentUnique(LoanProposal loan) {
        return loan.getNumberOfMainProponents() == 1;
    }

    private boolean isSumOfWarrantyGreaterThanOrEqualDoubleTheLoanAmount(LoanProposal loan) {
        return loan.sumOfAcceptWarranties().compareTo(loan.getValue().multiply(BigDecimal.valueOf(2.0))) >= 0;
    }

    private boolean isProponentIncomeCompatibleWithMonthlyInstallmentsAmount(LoanProposal loan) {
        Proponent mainProponent = loan.getMainProponent();
        if (mainProponent.getAge() >= 18 && mainProponent.getAge() <= 24) {
            return mainProponent.getMonthlyIncome().compareTo(loan.getMonthlyInstallmentsAmount().multiply(BigDecimal.valueOf(4.0))) >= 0;
        }
        else if (mainProponent.getAge() > 24 && mainProponent.getAge() <= 50) {
            return mainProponent.getMonthlyIncome().compareTo(loan.getMonthlyInstallmentsAmount().multiply(BigDecimal.valueOf(3.0))) >= 0;
        }
        else if (mainProponent.getAge() > 50) {
            return mainProponent.getMonthlyIncome().compareTo(loan.getMonthlyInstallmentsAmount().multiply(BigDecimal.valueOf(2.0))) >= 0;
        }

        return false;
    }
}
