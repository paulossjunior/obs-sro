package br.nemo.immigrant.ontology.service.sro.scrumprocess.controllers;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.ScrumProcess;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.ScrumProcessRepository;
import br.nemo.immigrant.ontology.service.sro.scrumprocess.records.ScrumProcessInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ScrumProcessController  {

  @Autowired
  ScrumProcessRepository repository;

  @QueryMapping
  public List<ScrumProcess> findAllScrumProcesss() {
    return repository.findAll();
  }

  @QueryMapping
  public ScrumProcess findByIDScrumProcess(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public ScrumProcess createScrumProcess(@Argument ScrumProcessInput input) {
    ScrumProcess instance = ScrumProcess.builder().name(input.name()).
                                                   description(input.description()).
                                                   startDate(input.startDate()).
                                                   endDate(input.endDate()).
                                                   url(input.url()).
                                                   externalId(input.externalId()).
                                                   internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public ScrumProcess updateScrumProcess(@Argument Long id, @Argument ScrumProcessInput input) {
    ScrumProcess instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("ScrumProcess not found");
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
  public void deleteScrumProcess(@Argument Long id) {
    repository.deleteById(id);
  }

}
