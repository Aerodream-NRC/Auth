package SocialNetwork.Auth.Configurers;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements ConstraintValidator<ValidLogin, String> {
    private Pattern pattern;
    private Matcher matcher;
    private static final String LOGIN_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";

    @Override
    public void initialize(ValidLogin constraintAnnotation) {
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext context){
        return (validateEmail(login));
    }

    private boolean validateEmail(String login) {
        pattern = Pattern.compile(LOGIN_PATTERN);
        matcher = pattern.matcher(login);
        return matcher.matches();
    }
}
