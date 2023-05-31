package br.nemo.immigrant.ontology.service.sro.stakeholders.repositories;

import br.nemo.immigrant.ontology.entity.sro.stakeholders.models.teammembership;
import br.nemo.immigrant.ontology.entity.sro.stakeholders.repositories.teammembershipRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "teammembership", path = "teammembership")
public interface teammembershipRepositoryWeb extends teammembershipRepository {

}
