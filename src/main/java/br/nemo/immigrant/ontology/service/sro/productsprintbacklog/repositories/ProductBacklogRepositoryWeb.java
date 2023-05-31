package br.nemo.immigrant.ontology.service.sro.productsprintbacklog.repositories;

import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.models.ProductBacklog;
import br.nemo.immigrant.ontology.entity.sro.productsprintbacklog.repositories.ProductBacklogRepository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productbacklog", path = "productbacklog")
public interface ProductBacklogRepositoryWeb extends ProductBacklogRepository {

}
