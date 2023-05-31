package br.nemo.immigrant.ontology.service.sro.scrumdeliverable.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.models.ScrumProjectDeliverable;
import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.repositories.ScrumProjectDeliverableRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "scrumprojectdeliverable", path = "scrumprojectdeliverable")
public interface ScrumProjectDeliverableRepositoryWeb extends ScrumProjectDeliverableRepository {

}
