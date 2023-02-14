package AacademyCourse.demohomeworkmodule14.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String street;

    @Column(name = "street_no")
    private String streetNumber;


    @ManyToOne()
    @JsonBackReference
    //@JoinColumn(name = "user_id", referencedColumnName = "id") //works without this
       private User user;

}
