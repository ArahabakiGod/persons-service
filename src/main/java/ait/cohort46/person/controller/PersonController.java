package ait.cohort46.person.controller;

import ait.cohort46.person.dto.AddressDto;
import ait.cohort46.person.dto.CityPopulationDto;
import ait.cohort46.person.dto.PersonDto;
import ait.cohort46.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping("/person")
    public boolean addPerson(@RequestBody PersonDto person) {
        return personService.addPerson(person);
    }

    @GetMapping("/person/{id}")
    public PersonDto findPerson(@PathVariable int id) {
        return personService.findPerson(id);
    }

    @GetMapping("/person/city/{city}")
    public PersonDto[] findByCity(@PathVariable String city) {
        return personService.findByCity(city);
    }

    @GetMapping("/person/ages/{ageFrom}/{ageTo}")
    public PersonDto[] findByAges(@PathVariable int ageFrom, @PathVariable int ageTo) {
        return personService.findByAges(ageFrom, ageTo);
    }

    @GetMapping("/person/name/{name}")
    public PersonDto[] findByName(@PathVariable String name) {
        return personService.findByName(name);
    }

    @PatchMapping("/person/{id}/name/{name}")
    public PersonDto updateName(@PathVariable int id, @PathVariable String name) {
        return personService.updateName(id, name);
    }

    @PatchMapping("/person/{id}/address")
    public PersonDto updateAddresses(@PathVariable int id, @RequestBody AddressDto address) {
        return personService.updateAddresses(id, address);
    }

    @GetMapping("/person/population/city")
    public Iterable<CityPopulationDto> getCityPopulation() {
        return personService.getCityPopulation();
    }

    @DeleteMapping("/person/{id}")
    public PersonDto deletePerson(@PathVariable int id) {
        return personService.deletePerson(id);
    }
}
