package me.craicic.mvc.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Secret {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salt_seq")
    @SequenceGenerator(name = "salt_seq", sequenceName = "salt_sequence", initialValue = 200, allocationSize = 1)
    private Integer id;

    @OneToOne
    private AppUser user;

    @Column(nullable = false)
    private String salt;
}
