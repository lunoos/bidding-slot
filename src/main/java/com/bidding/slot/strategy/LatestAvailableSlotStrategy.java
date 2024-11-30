package com.bidding.slot.strategy;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.slot.entity.Config;
import com.bidding.slot.dto.AvailableSlotDTO;
import com.bidding.slot.dto.SlotDuration;
import com.bidding.slot.service.ConfigService;
import com.bidding.slot.service.FactoryService;
import com.bidding.slot.util.Constants;

@Service
public class LatestAvailableSlotStrategy implements AuctionSlotStrategy  {
	
	@Autowired
	private ConfigService configService;
	
	@Autowired
	private FactoryService factoryService;

	@Override
	public AvailableSlotDTO getAvailableSlot(SlotDuration slotDuration) {
		// TODO Auto-generated method stub
		//List<Config> configListAvlSlt = configService.getConfigByCode(Constants.AVL_SLOT_CONFIG_CODE);
		List<Config> configListBufTime = configService.getConfigByCode(Constants.BUFF_SLOT_CONFIG_CODE);
		
		//String strTime = configListAvlSlt.get(0).getConfigValue();
		Long buffTimeInMin = Long.parseLong(configListBufTime.get(0).getConfigValue());
        
        // Define the formatter with the exact 2
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss a");
        //LocalDateTime zonedDateTime = ZonedDateTime.parse(strTime).toLocalDateTime();
        // Parse the string into LocalDateTime
        //LocalDateTime convertedTime = LocalDateTime.parse(strTime, formatter);
        LocalDateTime convertedTime = LocalDateTime.now();
        LocalDateTime currentTime = LocalDateTime.now();
        
        LocalDateTime currentTimePlusMin = currentTime.plusMinutes(buffTimeInMin);
        
        LocalDateTime startTime = currentTimePlusMin;
        
        if (convertedTime.isAfter(currentTimePlusMin)) 
        	startTime  = convertedTime;
        
        
        LocalDateTime endTime = startTime.plusMinutes(slotDuration.getVal());
        AvailableSlotDTO availableSlotDTO =  factoryService.getAvailalbleSlotDTO();
        availableSlotDTO.setStartTime(startTime);
        availableSlotDTO.setEndTime(endTime);
		return availableSlotDTO;
	}

	@Override
	public String getName() {
		return "latestAvailableSlotStrategy";
	}

}
