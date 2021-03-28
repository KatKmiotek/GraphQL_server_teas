package com.learning.GraphQL.services;

import com.learning.GraphQL.models.Tea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TeaService {

    Tea save(Tea tea);

    Page<Tea> findAll(Pageable pageable);

    Optional<Tea> findOne(Long id);

    void delete(Long id);
}
