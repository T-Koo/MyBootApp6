package jp.te4a.spring.boot.myapp11;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = InputValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface InputValid {
	String param();
	String message() default "input other than {param}.";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
