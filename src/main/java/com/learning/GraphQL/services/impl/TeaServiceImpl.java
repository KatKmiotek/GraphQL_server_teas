package com.learning.GraphQL.services.impl;

import com.learning.GraphQL.models.Tea;
import com.learning.GraphQL.repositiories.TeaRepository;
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
public class TeaServiceImpl implements TeaService {
    private final Logger LOGGER = LoggerFactory.getLogger(TeaServiceImpl.class);
    private final TeaRepository teaRepository;

    public TeaServiceImpl(TeaRepository teaRepository) {
        this.teaRepository = teaRepository;
    }

    @Override
    public Tea save(Tea tea){
        LOGGER.info("request to save a tea");
        return teaRepository.save(tea);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Tea> findAll(Pageable pageable) {
        LOGGER.info("Request to get all teas");
        return teaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Tea> findOne(Long id) {
        LOGGER.info("Request to get a tea : {}", id);
        return teaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Deleting a tea : {}", id);
        teaRepository.deleteById(id);
    }
}

