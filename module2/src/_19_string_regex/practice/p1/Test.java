package _19_string_regex.practice.p1;

public class Test {
    public static final String[] validEmail = new String[] { "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
    public static final String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String[] args) {
        Validation validation= new Validation();
        for (String email : validEmail) {
            boolean isvalid = validation.isEmail(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = validation.isEmail(email);
            System.out.println("Email is " + email +" is valid: "+ isvalid);
        }
    }
}
