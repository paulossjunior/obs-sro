package br.nemo.immigrant.ontology.service.sro.scrumprocess.repositories;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.Ceremony;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.CeremonyRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ceremony", path = "ceremony")
public interface CeremonyRepositoryWeb extends CeremonyRepository {

}
