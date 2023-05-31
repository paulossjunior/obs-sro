package br.nemo.immigrant.ontology.service.sro.scrumdeliverable.controllers;

import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.models.SprintDeliverable;
import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.repositories.SprintDeliverableRepository;
import br.nemo.immigrant.ontology.service.sro.scrumdeliverable.records.SprintDeliverableInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SprintDeliverableController  {

  @Autowired
  SprintDeliverableRepository repository;

  @QueryMapping
  public List<SprintDeliverable> findAllSprintDeliverables() {
    return repository.findAll();
  }

  @QueryMapping
  public SprintDeliverable findByIDSprintDeliverable(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public SprintDeliverable createSprintDeliverable(@Argument SprintDeliverableInput input) {
    SprintDeliverable instance = SprintDeliverable.builder().name(input.name()).
                                                             description(input.description()).
                                                             startDate(input.startDate()).
                                                             endDate(input.endDate()).
                                                             url(input.url()).
                                                             externalId(input.externalId()).
                                                             internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public SprintDeliverable updateSprintDeliverable(@Argument Long id, @Argument SprintDeliverableInput input) {
    SprintDeliverable instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("SprintDeliverable not found");
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
  public void deleteSprintDeliverable(@Argument Long id) {
    repository.deleteById(id);
  }

}
