package lesson_15;

import lesson_15.models.Product;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Product product = new Product();
        product.setTitle("aa");

        Set<ConstraintViolation<Product>> constrs = validator.validate(product);

        for(ConstraintViolation<Product> constr: constrs ){

            StringBuilder stringBuilder = new StringBuilder("property: ");
            stringBuilder.append(constr.getPropertyPath());
            stringBuilder.append(" value: ");
            stringBuilder.append(constr.getInvalidValue());
            stringBuilder.append(" message: ");
            stringBuilder.append(constr.getMessage());

            System.out.println(stringBuilder.toString());
        }

    }

}
