package mode1;

import api.MainMenu;

import java.util.regex.Pattern;

public class Customer {
    String firstName;
    String lastName;
    String email;

    public Customer(){}
    public Customer(String firstName,String lastName,String email) throws IllegalArgumentException {
        this.validateEmail();
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        /**if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("The email address you typed in is invalid,pleas type in again.");

        }*/
    }
    public String getEmail() {
        return email;
    }
    public void validateEmail() {
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (!pattern.matcher(this.email).matches()) {
            throw new IllegalArgumentException("The email must be a valid email address");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    /**public String getEmailRegex() {
        return emailRegex;
    }

    public void setEmailRegex(String emailRegex) {
        this.emailRegex = emailRegex;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }*/

    @Override
    public String toString(){
        return "The customer's first name is : "+firstName+" ,last name is ："+lastName
                +" ,email is : "+email+"\n";
    }
}
