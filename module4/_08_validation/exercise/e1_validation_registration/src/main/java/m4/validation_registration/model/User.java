package m4.validation_registration.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class User implements Validator {
    @NotEmpty(message = "Last Name is mandatory")
    @Size(min = 5, max = 45, message = "Last Name have to length from 5 to 45")
    private String lastName;

    @NotEmpty(message = "First Name is mandatory")
    @Size(min = 5, max = 45, message = "First Name have to length from 5 to 45")
    private String firstName;

    @NotNull(message = "{user.age.notNull}")
    @Min(value =18, message = "Age is greater than 17")
    private Integer age;

    private String phoneNumber;

    private String email;

    public User() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phoneNumber = user.getPhoneNumber();
        String email = user.getEmail();

        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "user.phoneNumber.notEmpty");
        if (phoneNumber.length() != 10){
            errors.rejectValue("phoneNumber", "300", "phone number have to 10 digits");
        }

        ValidationUtils.rejectIfEmpty(errors, "email", "301", "email not be a empty");
        if (!email.matches("(\\S.*\\S)(@)(\\S.*\\S)(.\\S[a-z]{2,3})")){
            errors.rejectValue("email", "302", "email is invalid format");
        }
    }
}
