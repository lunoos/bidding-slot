package com.bidding.slot.strategy;

import com.bidding.slot.dto.AvailableSlotDTO;
import com.bidding.slot.dto.SlotDuration;

public interface AuctionSlotStrategy {

	public AvailableSlotDTO getAvailableSlot(SlotDuration slotDuration);
	
	public String getName();
}
