package br.nemo.immigrant.ontology.service.sro.scrumprocess.controllers;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.Ceremony;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.CeremonyRepository;
import br.nemo.immigrant.ontology.service.sro.scrumprocess.records.CeremonyInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CeremonyController  {

  @Autowired
  CeremonyRepository repository;

  @QueryMapping
  public List<Ceremony> findAllCeremonys() {
    return repository.findAll();
  }

  @QueryMapping
  public Ceremony findByIDCeremony(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public Ceremony createCeremony(@Argument CeremonyInput input) {
    Ceremony instance = Ceremony.builder().name(input.name()).
                                           description(input.description()).
                                           startDate(input.startDate()).
                                           endDate(input.endDate()).
                                           url(input.url()).
                                           externalId(input.externalId()).
                                           internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public Ceremony updateCeremony(@Argument Long id, @Argument CeremonyInput input) {
    Ceremony instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("Ceremony not found");
    }
    instance.setName(input.name());
    instance.setDescription(input.description());
    instance.setStartDate(input.startDate());
    instance.setEndDate(input.endDate());
    instance.setUrl(input.url());
    instance.setExternalId(input.externalId());
    instance.setInternalId(input.internalId());
    repository.save(instance);
    return instance;
  }

  @MutationMapping
  public void deleteCeremony(@Argument Long id) {
    repository.deleteById(id);
  }

}
