package br.nemo.immigrant.ontology.service.sro.stakeholders.controllers;

import br.nemo.immigrant.ontology.entity.sro.stakeholders.models.Person;
import br.nemo.immigrant.ontology.entity.sro.stakeholders.repositories.PersonRepository;
import br.nemo.immigrant.ontology.service.sro.stakeholders.records.PersonInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PersonController  {

  @Autowired
  PersonRepository repository;

  @QueryMapping
  public List<Person> findAllPersons() {
    return repository.findAll();
  }

  @QueryMapping
  public Person findByIDPerson(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public Person createPerson(@Argument PersonInput input) {
    Person instance = Person.builder().email(input.email()).
                                       name(input.name()).
                                       description(input.description()).
                                       startDate(input.startDate()).
                                       endDate(input.endDate()).
                                       url(input.url()).
                                       externalId(input.externalId()).
                                       internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public Person updatePerson(@Argument Long id, @Argument PersonInput input) {
    Person instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("Person not found");
    }
    instance.setEmail(input.email());
    instance.setName(input.name());
    instance.setDescription(input.description());
    instance.setStartDate(input.startDate());
    instance.setEndDate(input.endDate());
    instance.setUrl(input.url());
    instance.setExternalId(input.externalId());
    instance.setInternalId(input.internalId());
    repository.save(instance);
    return instance;
  }

  @MutationMapping
  public void deletePerson(@Argument Long id) {
    repository.deleteById(id);
  }

}
