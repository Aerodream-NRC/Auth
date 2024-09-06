package SocialNetwork.Auth.Enums;

public enum Roles {

    USER(Names.USER),
    ADMIN(Names.ADMIN);

    public static class Names{
        public static final String USER = "User";
        public static final String ADMIN = "Admin";
    }
    private final String label;

    private Roles(String label) {
        this.label = label;
    }
    public String toString() {
        return this.label;
    }
}