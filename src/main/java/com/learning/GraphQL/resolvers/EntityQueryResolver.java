package com.learning.GraphQL.resolvers;

import com.learning.GraphQL.models.Producer;
import com.learning.GraphQL.models.Tea;
import com.learning.GraphQL.services.ProducerService;
import com.learning.GraphQL.services.TeaService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.Optional;


@Component
public class EntityQueryResolver implements GraphQLQueryResolver{
    private final TeaService teaService;
    private final ProducerService producerService;

    public EntityQueryResolver(TeaService teaService, ProducerService producerService) {
        this.teaService = teaService;
        this.producerService = producerService;
    }

    public Producer getProducerById(Long id){
        try{
            Optional<Producer> producer = producerService.findOne(id);
            if(producer.isPresent()){
                return producer.get();
            }
        } catch (Exception e){

        }
        return null;
    }

    public Tea getTeaById(Long id){
        try {
            Optional<Tea> tea = teaService.findOne(id);
            if(tea.isPresent()){
                return tea.get();
            }
        }catch (Exception e){

        }
        return null;
    }
    public Iterable<Tea> findAllTeas(Pageable pageable){
        try {
            return teaService.findAll(pageable);
        }
        catch (Exception e){

        }
        return null;
    }
}
