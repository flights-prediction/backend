package com.backend.aiplane.domain.like.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserIdAndFlightInfoId(Long userId, Long flightInfoId);

    List<Like> findAllByUserId(Long userId);
}
