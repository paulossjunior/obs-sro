package br.nemo.immigrant.ontology.service.sro.productsprintbacklog.controllers;

import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.models.ProductBacklog;
import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.repositories.ProductBacklogRepository;
import br.nemo.immigrant.ontology.service.sro.productsprintbacklog.records.ProductBacklogInput;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductBacklogController  {

  @Autowired
  ProductBacklogRepository repository;

  @QueryMapping
  public List<ProductBacklog> findAllProductBacklogs() {
    return repository.findAll();
  }

  @QueryMapping
  public ProductBacklog findByIDProductBacklog(@Argument Long id) {
    return repository.findById(id).orElse(null);
  }

  /* https://github.com/danvega/graphql-books
  Usar isso para relacao entre os conceitos https://www.danvega.dev/blog/2023/03/20/graphql-mutations/
  */

  @MutationMapping
  public ProductBacklog createProductBacklog(@Argument ProductBacklogInput input) {
    ProductBacklog instance = ProductBacklog.builder().createdtDate(input.createdtDate()).
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
  public ProductBacklog updateProductBacklog(@Argument Long id, @Argument ProductBacklogInput input) {
    ProductBacklog instance = repository.findById(id).orElse(null);
    if(instance == null) {
        throw new RuntimeException("ProductBacklog not found");
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
  public void deleteProductBacklog(@Argument Long id) {
    repository.deleteById(id);
  }

}
