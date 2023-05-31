package br.nemo.immigrant.ontology.service.sro.stakeholders.repositories;

import br.nemo.immigrant.ontology.entity.sro.stakeholders.models.ScrumTeam;
import br.nemo.immigrant.ontology.entity.sro.stakeholders.repositories.ScrumTeamRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "scrumteam", path = "scrumteam")
public interface ScrumTeamRepositoryWeb extends ScrumTeamRepository {

}
