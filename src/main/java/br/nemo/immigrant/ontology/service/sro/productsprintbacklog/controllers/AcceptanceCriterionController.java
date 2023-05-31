package br.nemo.immigrant.ontology.service.sro.productsprintbacklog.controllers;

import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.models.AcceptanceCriterion;
import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.repositories.AcceptanceCriterionRepository;
import br.nemo.immigrant.ontology.service.sro.productsprintbacklog.records.AcceptanceCriterionInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AcceptanceCriterionController  {

  @Autowired
  AcceptanceCriterionRepository repository;

  @QueryMapping
  public List<AcceptanceCriterion> findAllAcceptanceCriterions() {
    return repository.findAll();
  }

  @QueryMapping
  public AcceptanceCriterion findByIDAcceptanceCriterion(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public AcceptanceCriterion createAcceptanceCriterion(@Argument AcceptanceCriterionInput input) {
    AcceptanceCriterion instance = AcceptanceCriterion.builder().createdtDate(input.createdtDate()).
                                                                 name(input.name()).
                                                                 description(input.description()).
                                                                 startDate(input.startDate()).
                                                                 endDate(input.endDate()).
                                                                 url(input.url()).
                                                                 externalId(input.externalId()).
                                                                 internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public AcceptanceCriterion updateAcceptanceCriterion(@Argument Long id, @Argument AcceptanceCriterionInput input) {
    AcceptanceCriterion instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("AcceptanceCriterion not found");
    }
    instance.setCreatedtDate(input.createdtDate());
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
  public void deleteAcceptanceCriterion(@Argument Long id) {
    repository.deleteById(id);
  }

}
