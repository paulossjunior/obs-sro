package br.nemo.immigrant.ontology.service.sro.productsprintbacklog.repositories;

import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.models.UserStory;
import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.repositories.UserStoryRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userstory", path = "userstory")
public interface UserStoryRepositoryWeb extends UserStoryRepository {

}
