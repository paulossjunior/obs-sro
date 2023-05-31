package br.nemo.immigrant.ontology.service.sro.stakeholders.records;
import java.time.LocalDate;
public record PersonInput( String email,String name,String description,LocalDate startDate,LocalDate endDate,String url,String externalId,String internalId ) {
}
