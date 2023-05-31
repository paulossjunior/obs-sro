package br.nemo.immigrant.ontology.service.sro.scrumdeliverable.controllers;

import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.models.ScrumProjectDeliverable;
import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.repositories.ScrumProjectDeliverableRepository;
import br.nemo.immigrant.ontology.service.sro.scrumdeliverable.records.ScrumProjectDeliverableInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ScrumProjectDeliverableController  {

  @Autowired
  ScrumProjectDeliverableRepository repository;

  @QueryMapping
  public List<ScrumProjectDeliverable> findAllScrumProjectDeliverables() {
    return repository.findAll();
  }

  @QueryMapping
  public ScrumProjectDeliverable findByIDScrumProjectDeliverable(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public ScrumProjectDeliverable createScrumProjectDeliverable(@Argument ScrumProjectDeliverableInput input) {
    ScrumProjectDeliverable instance = ScrumProjectDeliverable.builder().name(input.name()).
                                                                         description(input.description()).
                                                                         startDate(input.startDate()).
                                                                         endDate(input.endDate()).
                                                                         url(input.url()).
                                                                         externalId(input.externalId()).
                                                                         internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public ScrumProjectDeliverable updateScrumProjectDeliverable(@Argument Long id, @Argument ScrumProjectDeliverableInput input) {
    ScrumProjectDeliverable instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("ScrumProjectDeliverable not found");
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
  public void deleteScrumProjectDeliverable(@Argument Long id) {
    repository.deleteById(id);
  }

}
