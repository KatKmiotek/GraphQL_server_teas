package com.learning.GraphQL.services;

import com.learning.GraphQL.models.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProducerService {

    Producer save(Producer producer);

    Page<Producer> findAll(Pageable pageable);

    Optional<Producer> findOne(Long id);

    void delete(Long id);
}
