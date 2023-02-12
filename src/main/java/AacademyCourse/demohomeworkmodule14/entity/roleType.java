package AacademyCourse.demohomeworkmodule14.entity;

public enum roleType {
    ADMIN("Admin"),
    CLIENT("Client"),
    USER("User");

    public final String label;

    roleType(String label) {
        this.label = label;
    }
}
