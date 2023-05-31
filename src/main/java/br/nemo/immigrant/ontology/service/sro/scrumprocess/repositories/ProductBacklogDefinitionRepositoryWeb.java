package br.nemo.immigrant.ontology.service.sro.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.ProductBacklogDefinition;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.ProductBacklogDefinitionRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productbacklogdefinition", path = "productbacklogdefinition")
public interface ProductBacklogDefinitionRepositoryWeb extends ProductBacklogDefinitionRepository {

}
