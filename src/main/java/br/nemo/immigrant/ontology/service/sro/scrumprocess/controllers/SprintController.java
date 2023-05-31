package br.nemo.immigrant.ontology.service.sro.scrumprocess.controllers;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.Sprint;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.SprintRepository;
import br.nemo.immigrant.ontology.service.sro.scrumprocess.records.SprintInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SprintController  {

  @Autowired
  SprintRepository repository;

  @QueryMapping
  public List<Sprint> findAllSprints() {
    return repository.findAll();
  }

  @QueryMapping
  public Sprint findByIDSprint(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public Sprint createSprint(@Argument SprintInput input) {
    Sprint instance = Sprint.builder().name(input.name()).
                                       description(input.description()).
                                       startDate(input.startDate()).
                                       endDate(input.endDate()).
                                       url(input.url()).
                                       externalId(input.externalId()).
                                       internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public Sprint updateSprint(@Argument Long id, @Argument SprintInput input) {
    Sprint instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("Sprint not found");
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
  public void deleteSprint(@Argument Long id) {
    repository.deleteById(id);
  }

}
