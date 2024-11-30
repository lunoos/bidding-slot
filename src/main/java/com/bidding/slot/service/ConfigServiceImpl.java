package com.bidding.slot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.slot.entity.Config;
import com.bidding.slot.exception.ConfigFetchException;
import com.bidding.slot.repository.ConfigRepository;

@Service
public class ConfigServiceImpl implements ConfigService{

	@Autowired
	private  ConfigRepository configRepository;


    public Optional<Config> getConfigById(Long configId) {
        return configRepository.findById(configId);
    }

    public List<Config> getConfigByCode(String configCode) {
    	List<Config> list = configRepository.findByConfigCode(configCode).orElseThrow(() -> new ConfigFetchException("Error fetching the config value"));
        return list;
    }

}
