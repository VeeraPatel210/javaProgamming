
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
    String message() default "Field must not be blank";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank(message = "Username is required")
    @MaxLength(12)
    private String username;

    @NotBlank(message = "Email is required")
    @MaxLength(25)
    private String emailAddress;

    @NotBlank(message = "Referral code is required")
    @MaxLength(6)
    private String referralCode;

    SignupForm(String username, String emailAddress, String referralCode) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.referralCode = referralCode;
    }
}

class FormValidatorDemo {
    static List<String> validateForm(Object obj) {
        List<String> errors = new ArrayList<>();

        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);

            try {
                Object value = f.get(obj);
                String text = value == null ? "" : value.toString();

                if (f.isAnnotationPresent(NotBlank.class) && text.trim().isEmpty())
                    errors.add(f.getName() + ": " + f.getAnnotation(NotBlank.class).message());

                if (f.isAnnotationPresent(MaxLength.class) &&
                        text.length() > f.getAnnotation(MaxLength.class).value())
                    errors.add(f.getName() + ": Maximum length exceeded");

            } catch (Exception e) {
                errors.add("Validation error");
            }
        }

        return errors;
    }

    public static void main(String[] args) {
        SignupForm form = new SignupForm("", "verylongemailaddress@example.com", "WELCOME2026");
        List<String> errors = validateForm(form);

        if (errors.isEmpty())
            System.out.println("Valid form");
        else
            errors.forEach(System.out::println);
    }
}
