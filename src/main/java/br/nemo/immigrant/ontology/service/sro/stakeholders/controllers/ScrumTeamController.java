package br.nemo.immigrant.ontology.service.sro.stakeholders.controllers;

import br.nemo.immigrant.ontology.entity.sro.stakeholders.models.ScrumTeam;
import br.nemo.immigrant.ontology.entity.sro.stakeholders.repositories.ScrumTeamRepository;
import br.nemo.immigrant.ontology.service.sro.stakeholders.records.ScrumTeamInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ScrumTeamController  {

  @Autowired
  ScrumTeamRepository repository;

  @QueryMapping
  public List<ScrumTeam> findAllScrumTeams() {
    return repository.findAll();
  }

  @QueryMapping
  public ScrumTeam findByIDScrumTeam(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public ScrumTeam createScrumTeam(@Argument ScrumTeamInput input) {
    ScrumTeam instance = ScrumTeam.builder().name(input.name()).
                                             description(input.description()).
                                             startDate(input.startDate()).
                                             endDate(input.endDate()).
                                             url(input.url()).
                                             externalId(input.externalId()).
                                             internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public ScrumTeam updateScrumTeam(@Argument Long id, @Argument ScrumTeamInput input) {
    ScrumTeam instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("ScrumTeam not found");
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
  public void deleteScrumTeam(@Argument Long id) {
    repository.deleteById(id);
  }

}
