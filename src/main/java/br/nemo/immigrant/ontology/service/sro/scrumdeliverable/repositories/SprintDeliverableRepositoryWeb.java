package br.nemo.immigrant.ontology.service.sro.scrumdeliverable.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.models.SprintDeliverable;
import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.repositories.SprintDeliverableRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sprintdeliverable", path = "sprintdeliverable")
public interface SprintDeliverableRepositoryWeb extends SprintDeliverableRepository {

}
