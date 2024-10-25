package ait.cohort46.person.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Embeddable
public class Address implements Serializable {
    private String street;
    private String city;
    private int building;
}
