package com.bidding.slot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidding.slot.entity.Config;

import java.util.List;
import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Config, Long> {
    Optional<List<Config>> findByConfigCode(String configCode);
}
