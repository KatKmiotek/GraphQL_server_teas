package com.learning.GraphQL.resolvers;

import com.learning.GraphQL.models.Producer;
import com.learning.GraphQL.models.Tea;
import com.learning.GraphQL.services.ProducerService;
import com.learning.GraphQL.services.TeaService;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLMutationResolver;


@Component
public class EntityMutationResolver implements GraphQLMutationResolver{
    private final TeaService teaService;
    private final ProducerService producerService;

    public EntityMutationResolver(TeaService teaService, ProducerService producerService) {
        this.teaService = teaService;
        this.producerService = producerService;
    }

    public Producer addProducer(String name, String location) throws Exception{
        Producer teaProducer = new Producer(name, location);
        return producerService.save(teaProducer);
    }
    public Tea addTea(String name, String type, double price, Long producerId)throws Exception{
        Tea newTea = new Tea(name, type, price);
        newTea.setProducer(producerService.findOne(producerId).get());
        return teaService.save(newTea);
    }
}
