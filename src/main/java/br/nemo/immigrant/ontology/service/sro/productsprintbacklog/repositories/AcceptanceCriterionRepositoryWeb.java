package br.nemo.immigrant.ontology.service.sro.productsprintbacklog.repositories;

import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.models.AcceptanceCriterion;
import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.repositories.AcceptanceCriterionRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "acceptancecriterion", path = "acceptancecriterion")
public interface AcceptanceCriterionRepositoryWeb extends AcceptanceCriterionRepository {

}
