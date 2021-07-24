package com.example.zoodemo.repositories;

import com.example.zoodemo.entities.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageRepository extends JpaRepository<Cage, Long> {
}
