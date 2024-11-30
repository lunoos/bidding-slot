package com.bidding.slot.service;

import java.util.List;
import java.util.Optional;

import com.bidding.slot.entity.Config;

public interface ConfigService {

	public Optional<Config> getConfigById(Long configId);

    public List<Config> getConfigByCode(String configCode);
    
}
