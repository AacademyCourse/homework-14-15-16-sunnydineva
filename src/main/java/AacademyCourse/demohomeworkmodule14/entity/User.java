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

    @Column
    private Instant createdAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set <Address> addresses;

    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
             joinColumns = {@JoinColumn (name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    Set<Role> roles;
}
