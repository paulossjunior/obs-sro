package br.nemo.immigrant.ontology.service.sro.scrumprocess.records;
import java.time.LocalDate;
public record ScrumDevelopmentTaskInput( String name,String description,LocalDate startDate,LocalDate endDate,String url,String externalId,String internalId ) {
}
