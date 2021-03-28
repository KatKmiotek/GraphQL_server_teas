package com.learning.GraphQL.web;

import com.learning.GraphQL.models.Producer;
import com.learning.GraphQL.services.ProducerService;
import com.learning.GraphQL.services.TeaService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProducerResource {

    private Logger LOGGER = LoggerFactory.getLogger(ProducerResource.class);

    private final ProducerService producerService;

    public ProducerResource(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/producers")
    public ResponseEntity<Producer> createProducer(@Valid @RequestBody Producer producer){
        LOGGER.info("REST request to save a producer : {}", producer);
        try{
            if(producer.getId() != null){
                throw new ApiException("Problem with already existing ID", "PRIMARY KEY will be set by application");
            }
            Producer result = producerService.save(producer);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/producers")
    public ResponseEntity<Producer> updateProducer(@Valid @RequestBody Producer producer) throws URISyntaxException {
        LOGGER.info("REST request to update producer : {}", producer);

        try {
            if (producer.getId() == null) {
                throw new ApiException("A producer must have an ID to update",
                        "PRIMARY KEY is required to update an entity");
            }
            Producer result = producerService.save(producer);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/producers")
    public ResponseEntity<List<Producer>> getAllProducers(Pageable pageable) {
        LOGGER.info("REST request to get a page of producers");
        Page<Producer> page = producerService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/producers/{id}")
    public ResponseEntity<Producer> getProducer(@PathVariable Long id) {
        LOGGER.info("REST request to get producer : {}", id);
        Optional<Producer> producer = producerService.findOne(id);
        if (producer.isPresent()) {
            return new ResponseEntity<>(producer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/producers/{id}")
    public ResponseEntity<Void> deleteProducer(@PathVariable Long id) {
        LOGGER.info("REST request to delete producer : {}", id);

        try {
            producerService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}

