package SocialNetwork.Auth.Configurers;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements ConstraintValidator<ValidLogin, String> {
    private static final String LOGIN_PATTERN = "^[_A-Za-z0-9-]$";

    @Override
    public void initialize(ValidLogin constraintAnnotation) {
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext context){
        return (validateLogin(login));
    }

    private boolean validateLogin(String login) {
        Pattern pattern = Pattern.compile(LOGIN_PATTERN);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }
}
