package ait.cohort46.person.dao;

import ait.cohort46.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person[] getByAddress_City(String city);
    Person[] getByBirthDateBetween(LocalDate from, LocalDate to);
    Person[] getByName(String name);
}
