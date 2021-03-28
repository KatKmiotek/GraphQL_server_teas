package com.learning.GraphQL.data;

import com.learning.GraphQL.models.Producer;
import com.learning.GraphQL.models.Tea;
import com.learning.GraphQL.services.ProducerService;
import com.learning.GraphQL.services.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner {
    @Autowired
    TeaService teaService;
    @Autowired
    ProducerService producerService;





    @Override
    public void run(ApplicationArguments args) throws Exception {
        Producer producer1 = new Producer("Lipton", "London");
        producerService.save(producer1);
        Tea tea1 = new Tea("Green Tea", "green tea", 2.99);
        teaService.save(tea1);
    }
}
