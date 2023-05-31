package br.nemo.immigrant.ontology.service.sro.scrumdeliverable.controllers;

import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.models.Deliverable;
import br.nemo.immigrant.ontology.entity.sro.scrumdeliverable.repositories.DeliverableRepository;
import br.nemo.immigrant.ontology.service.sro.scrumdeliverable.records.DeliverableInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DeliverableController  {

  @Autowired
  DeliverableRepository repository;

  @QueryMapping
  public List<Deliverable> findAllDeliverables() {
    return repository.findAll();
  }

  @QueryMapping
  public Deliverable findByIDDeliverable(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public Deliverable createDeliverable(@Argument DeliverableInput input) {
    Deliverable instance = Deliverable.builder().name(input.name()).
                                                 description(input.description()).
                                                 startDate(input.startDate()).
                                                 endDate(input.endDate()).
                                                 url(input.url()).
                                                 externalId(input.externalId()).
                                                 internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public Deliverable updateDeliverable(@Argument Long id, @Argument DeliverableInput input) {
    Deliverable instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("Deliverable not found");
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
  public void deleteDeliverable(@Argument Long id) {
    repository.deleteById(id);
  }

}
