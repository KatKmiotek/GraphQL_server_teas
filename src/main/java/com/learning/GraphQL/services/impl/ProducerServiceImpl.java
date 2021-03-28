package com.learning.GraphQL.services.impl;

import com.learning.GraphQL.models.Producer;
import com.learning.GraphQL.models.Tea;
import com.learning.GraphQL.repositiories.ProducerRepository;
import com.learning.GraphQL.repositiories.TeaRepository;
import com.learning.GraphQL.services.ProducerService;
import com.learning.GraphQL.services.TeaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {
    private final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceImpl.class);
    private final ProducerRepository producerRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public Producer save(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public Page<Producer> findAll(Pageable pageable) {
        return producerRepository.findAll(pageable);
    }

    @Override
    public Optional<Producer> findOne(Long id) {
        return producerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        producerRepository.deleteById(id);
    }
}
