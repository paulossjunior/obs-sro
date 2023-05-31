package br.nemo.immigrant.ontology.service.sro.productsprintbacklog.records;
import java.time.LocalDate;
public record ProductBacklogInput( LocalDate createdtDate,String name,String description,LocalDate startDate,LocalDate endDate,String url,String externalId,String internalId ) {
}
