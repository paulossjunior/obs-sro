package br.nemo.immigrant.ontology.service.sro.stakeholders.repositories;

import br.nemo.immigrant.ontology.entity.sro.stakeholders.models.Person;
import br.nemo.immigrant.ontology.entity.sro.stakeholders.repositories.PersonRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepositoryWeb extends PersonRepository {

}
