package AacademyCourse.demohomeworkmodule14.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String phone;
    @Column(name = "e-mail")
    private String email;
    private Instant createdAt;
    @OneToMany(mappedBy  = "user", fetch = FetchType.LAZY)
    private Set<Address> addresses;
}
