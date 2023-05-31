package br.nemo.immigrant.ontology.service.sro.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.Sprint;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.SprintRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sprint", path = "sprint")
public interface SprintRepositoryWeb extends SprintRepository {

}
