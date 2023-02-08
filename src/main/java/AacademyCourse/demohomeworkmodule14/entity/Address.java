package AacademyCourse.demohomeworkmodule14.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String street;
    @Column(name = "street_no")
    private String streetNumber;
    @ManyToOne
    private User user;
}
