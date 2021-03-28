package com.learning.GraphQL.web;

import com.learning.GraphQL.models.Tea;
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
public class TeaResource {

    private Logger LOGGER = LoggerFactory.getLogger(TeaResource.class);

    private final TeaService teaService;

    public TeaResource(TeaService teaService) {
        this.teaService = teaService;
    }

    @PostMapping("/teas")
    public ResponseEntity<Tea> createTea(@Valid @RequestBody Tea tea){
        LOGGER.info("REST request to save a tea : {}", tea);
        try{
           if(tea.getId() != null){
               throw new ApiException("Problem with already existing ID", "PRIMARY KEY will be set by application");
           }
           Tea result = teaService.save(tea);
           return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/teas")
    public ResponseEntity<Tea> updateTea(@Valid @RequestBody Tea tea) throws URISyntaxException {
        LOGGER.info("REST request to update tea : {}", tea);

        try {
            if (tea.getId() == null) {
                throw new ApiException("A tea must have an ID to update",
                        "PRIMARY KEY is required to update an entity");
            }
            Tea result = teaService.save(tea);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }

    }

    @GetMapping("/teas")
    public ResponseEntity<List<Tea>> getAllTeas(Pageable pageable) {
        LOGGER.info("REST request to get a page of teas");
        Page<Tea> page = teaService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }

    @GetMapping("/teas/{id}")
    public ResponseEntity<Tea> getTea(@PathVariable Long id) {
        LOGGER.info("REST request to get tea : {}", id);
        Optional<Tea> tea = teaService.findOne(id);
        if (tea.isPresent()) {
            return new ResponseEntity<>(tea.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/teas/{id}")
    public ResponseEntity<Void> deleteTea(@PathVariable Long id) {
        LOGGER.info("REST request to delete tea : {}", id);

        try {
            teaService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
