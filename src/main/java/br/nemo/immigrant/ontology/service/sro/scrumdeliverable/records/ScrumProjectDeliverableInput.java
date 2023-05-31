package br.nemo.immigrant.ontology.service.sro.scrumdeliverable.records;
import java.time.LocalDate;
public record ScrumProjectDeliverableInput( String name,String description,LocalDate startDate,LocalDate endDate,String url,String externalId,String internalId ) {
}
