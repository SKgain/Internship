package question10;

public class User {
    String role;
    String email;
    String password;

    public User(String role, String email, String password) {
        if (!role.equals("admin")) {
            throw new IllegalArgumentException("Invalid role");
        }
        if (!email.contains("@")) {
            throw  new IllegalArgumentException("Invalid email");
        }
        if (!password.contains("*") && !(password.length() < 8)) {
            throw  new IllegalArgumentException("password is not strong, must be at least 8 characters and contain *");
        }
        else
        {
            this.role = role;
            this.email = email;
            this.password = password;
        }
    }

    public void display() {
        System.out.println("Role: " + role);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
}
