package delivery.deliverybe.validators;

import delivery.deliverybe.custom_constraint.EmailConstraint;
import delivery.deliverybe.model.Driver;
import delivery.deliverybe.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<EmailConstraint, String> {

    @Autowired
    DriverService service;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Driver driver = service.getByEmail(s);
        System.out.println(driver+"This is it");
        return driver == null;
    }
}
