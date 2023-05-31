package br.nemo.immigrant.ontology.service.sro.scrumprocess.controllers;

import br.nemo.immigrant.ontology.entity.sro.scrumprocess.models.ProductBacklogDefinition;
import br.nemo.immigrant.ontology.entity.sro.scrumprocess.repositories.ProductBacklogDefinitionRepository;
import br.nemo.immigrant.ontology.service.sro.scrumprocess.records.ProductBacklogDefinitionInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductBacklogDefinitionController  {

  @Autowired
  ProductBacklogDefinitionRepository repository;

  @QueryMapping
  public List<ProductBacklogDefinition> findAllProductBacklogDefinitions() {
    return repository.findAll();
  }

  @QueryMapping
  public ProductBacklogDefinition findByIDProductBacklogDefinition(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public ProductBacklogDefinition createProductBacklogDefinition(@Argument ProductBacklogDefinitionInput input) {
    ProductBacklogDefinition instance = ProductBacklogDefinition.builder().name(input.name()).
                                                                           description(input.description()).
                                                                           startDate(input.startDate()).
                                                                           endDate(input.endDate()).
                                                                           url(input.url()).
                                                                           externalId(input.externalId()).
                                                                           internalId(input.internalId()).build();

    return repository.save(instance);
  }

  @MutationMapping
  public ProductBacklogDefinition updateProductBacklogDefinition(@Argument Long id, @Argument ProductBacklogDefinitionInput input) {
    ProductBacklogDefinition instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("ProductBacklogDefinition not found");
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
  public void deleteProductBacklogDefinition(@Argument Long id) {
    repository.deleteById(id);
  }

}
