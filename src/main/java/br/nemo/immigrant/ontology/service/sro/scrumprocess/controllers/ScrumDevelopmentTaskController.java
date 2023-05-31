package br.nemo.immigrant.ontology.service.sro.scrumprocess.controllers;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.ScrumDevelopmentTask;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.ScrumDevelopmentTaskRepository;
import br.nemo.immigrant.ontology.service.sro.scrumprocess.records.ScrumDevelopmentTaskInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ScrumDevelopmentTaskController  {

  @Autowired
  ScrumDevelopmentTaskRepository repository;

  @QueryMapping
  public List<ScrumDevelopmentTask> findAllScrumDevelopmentTasks() {
    return repository.findAll();
  }

  @QueryMapping
  public ScrumDevelopmentTask findByIDScrumDevelopmentTask(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public ScrumDevelopmentTask createScrumDevelopmentTask(@Argument ScrumDevelopmentTaskInput input) {
    ScrumDevelopmentTask instance = ScrumDevelopmentTask.builder().name(input.name()).
                                                                   description(input.description()).
                                                                   startDate(input.startDate()).
                                                                   endDate(input.endDate()).
                                                                   url(input.url()).
                                                                   externalId(input.externalId()).
                                                                   internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public ScrumDevelopmentTask updateScrumDevelopmentTask(@Argument Long id, @Argument ScrumDevelopmentTaskInput input) {
    ScrumDevelopmentTask instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("ScrumDevelopmentTask not found");
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
  public void deleteScrumDevelopmentTask(@Argument Long id) {
    repository.deleteById(id);
  }

}
