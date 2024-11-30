package com.bidding.slot.service;

import org.springframework.stereotype.Service;

import com.bidding.slot.dto.AvailableSlotDTO;

@Service
public class FactoryServiceImpl implements FactoryService{

	@Override
	public AvailableSlotDTO getAvailalbleSlotDTO() {
		return new AvailableSlotDTO();
	}

}
