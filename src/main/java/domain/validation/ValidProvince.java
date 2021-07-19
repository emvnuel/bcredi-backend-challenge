package domain.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidProvinceValidator.class })
@Documented
public @interface ValidProvince {

    String message() default "Invalid province";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
