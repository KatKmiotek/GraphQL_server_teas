package com.learning.GraphQL.repositiories;

import com.learning.GraphQL.models.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
