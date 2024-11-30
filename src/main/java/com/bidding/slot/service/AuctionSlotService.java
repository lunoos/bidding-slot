package com.bidding.slot.service;

import java.util.List;
import java.util.Optional;

import com.bidding.slot.entity.AuctionSlot;
import com.bidding.slot.dto.AvailableSlotDTO;
import com.bidding.slot.dto.SlotDuration;

public interface AuctionSlotService {

	public AuctionSlot createAuctionSlot(AuctionSlot auctionSlot);

    public Optional<AuctionSlot> getAuctionSlotById(Long slotId) ;

    public List<AuctionSlot> getAuctionSlotsByCategoryCode(String CategoryCode);

    public void deleteAuctionSlot(Long slotId);
    
    public AvailableSlotDTO getAvaiSlotDTO(SlotDuration duration);
    
}
