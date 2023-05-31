package br.nemo.immigrant.ontology.service.sro.stakeholders.controllers;

import br.nemo.immigrant.ontology.entity.sro.stakeholders.models.teammembership;
import br.nemo.immigrant.ontology.entity.sro.stakeholders.repositories.teammembershipRepository;
import br.nemo.immigrant.ontology.service.sro.stakeholders.records.teammembershipInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class teammembershipController  {

  @Autowired
  teammembershipRepository repository;

  @QueryMapping
  public List<teammembership> findAllteammemberships() {
    return repository.findAll();
  }

  @QueryMapping
  public teammembership findByIDteammembership(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public teammembership createteammembership(@Argument teammembershipInput input) {
    teammembership instance = teammembership.builder().name(input.name()).
                                                       description(input.description()).
                                                       startDate(input.startDate()).
                                                       endDate(input.endDate()).
                                                       url(input.url()).
                                                       externalId(input.externalId()).
                                                       internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public teammembership updateteammembership(@Argument Long id, @Argument teammembershipInput input) {
    teammembership instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("teammembership not found");
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
  public void deleteteammembership(@Argument Long id) {
    repository.deleteById(id);
  }

}
