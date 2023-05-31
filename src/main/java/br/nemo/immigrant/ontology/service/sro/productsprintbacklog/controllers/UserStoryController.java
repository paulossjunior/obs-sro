package br.nemo.immigrant.ontology.service.sro.productsprintbacklog.controllers;

import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.models.UserStory;
import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.repositories.UserStoryRepository;
import br.nemo.immigrant.ontology.service.sro.productsprintbacklog.records.UserStoryInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserStoryController  {

  @Autowired
  UserStoryRepository repository;

  @QueryMapping
  public List<UserStory> findAllUserStorys() {
    return repository.findAll();
  }

  @QueryMapping
  public UserStory findByIDUserStory(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public UserStory createUserStory(@Argument UserStoryInput input) {
    UserStory instance = UserStory.builder().importance(input.importance()).
                                             effort(input.effort()).
                                             createdDate(input.createdDate()).
                                             updateDate(input.updateDate()).
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
  public UserStory updateUserStory(@Argument Long id, @Argument UserStoryInput input) {
    UserStory instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("UserStory not found");
    }
    instance.setImportance(input.importance());
    instance.setEffort(input.effort());
    instance.setCreatedDate(input.createdDate());
    instance.setUpdateDate(input.updateDate());
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
  public void deleteUserStory(@Argument Long id) {
    repository.deleteById(id);
  }

}
