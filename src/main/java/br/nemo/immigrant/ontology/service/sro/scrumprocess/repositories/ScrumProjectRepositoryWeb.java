package br.nemo.immigrant.ontology.service.sro.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.ScrumProject;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.ScrumProjectRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "scrumproject", path = "scrumproject")
public interface ScrumProjectRepositoryWeb extends ScrumProjectRepository {

}
