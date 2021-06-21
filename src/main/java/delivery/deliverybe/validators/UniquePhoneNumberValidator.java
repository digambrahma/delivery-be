package delivery.deliverybe.validators;

import delivery.deliverybe.custom_constraint.PhoneConstraint;
import delivery.deliverybe.model.Driver;
import delivery.deliverybe.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePhoneNumberValidator implements ConstraintValidator<PhoneConstraint, String> {

    @Autowired
    DriverService driverService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Driver driver = driverService.getByPhone(s);
        return driver == null;
    }
}
