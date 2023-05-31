package br.nemo.immigrant.ontology.service.sro.scrumdeliverable.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.models.Deliverable;
import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.repositories.DeliverableRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "deliverable", path = "deliverable")
public interface DeliverableRepositoryWeb extends DeliverableRepository {

}
