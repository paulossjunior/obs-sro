package br.nemo.immigrant.ontology.service.sro.productsprintbacklog.repositories;

import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.models.SprintBacklog;
import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.repositories.SprintBacklogRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sprintbacklog", path = "sprintbacklog")
public interface SprintBacklogRepositoryWeb extends SprintBacklogRepository {

}
