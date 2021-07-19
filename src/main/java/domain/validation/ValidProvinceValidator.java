package domain.validation;

import domain.model.Province;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidProvinceValidator implements ConstraintValidator<ValidProvince, Province> {
    @Override
    public void initialize(ValidProvince constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Province value, ConstraintValidatorContext context) {
        return value.isWarrantyAccepted();
    }
}
