public class UserService {
    public void registerUser(String name, String email) {
        // Logic to save user to the database
    }

    public User getUserProfile(String email) {
        // Logic to fetch user profile from database
        return new User(name, email);
    }
}
