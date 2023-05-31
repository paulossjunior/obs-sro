package br.nemo.immigrant.ontology.service.sro.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.ScrumDevelopmentTask;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.ScrumDevelopmentTaskRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "scrumdevelopmenttask", path = "scrumdevelopmenttask")
public interface ScrumDevelopmentTaskRepositoryWeb extends ScrumDevelopmentTaskRepository {

}
