package com.learning.GraphQL.repositiories;

import com.learning.GraphQL.models.Tea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeaRepository extends JpaRepository<Tea, Long> {
}
