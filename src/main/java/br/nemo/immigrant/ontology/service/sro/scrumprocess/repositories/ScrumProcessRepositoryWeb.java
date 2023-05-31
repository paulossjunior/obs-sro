package br.nemo.immigrant.ontology.service.sro.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.ScrumProcess;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.ScrumProcessRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "scrumprocess", path = "scrumprocess")
public interface ScrumProcessRepositoryWeb extends ScrumProcessRepository {

}
