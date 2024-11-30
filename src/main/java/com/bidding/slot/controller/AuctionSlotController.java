package com.bidding.slot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bidding.slot.entity.AuctionSlot;
import com.bidding.slot.dto.AvailableSlotDTO;
import com.bidding.slot.dto.SlotDuration;
import com.bidding.slot.service.AuctionSlotService;

import java.util.List;

@RestController
@RequestMapping("/auction-slots")
public class AuctionSlotController {

	@Autowired
    private AuctionSlotService auctionSlotService;

    @PostMapping
    public ResponseEntity<AuctionSlot> createAuctionSlot(@RequestBody AuctionSlot auctionSlot) {
        AuctionSlot createdSlot = auctionSlotService.createAuctionSlot(auctionSlot);
        return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
    }

    @GetMapping("/{slotId}")
    public ResponseEntity<AuctionSlot> getAuctionSlotById(@PathVariable Long slotId) {
        return auctionSlotService.getAuctionSlotById(slotId)
                .map(slot -> new ResponseEntity<>(slot, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{CategoryId}")
    public ResponseEntity<List<AuctionSlot>> getAuctionSlotsByCategoryId(@PathVariable String categoryCode) {
        List<AuctionSlot> slots = auctionSlotService.getAuctionSlotsByCategoryCode(categoryCode);
        return new ResponseEntity<>(slots, HttpStatus.OK);
    }

    @DeleteMapping("/{slotId}")
    public ResponseEntity<Void> deleteAuctionSlot(@PathVariable Long slotId) {
        auctionSlotService.deleteAuctionSlot(slotId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/availableSlot")
    public ResponseEntity<AvailableSlotDTO> getAvailableSlot(@RequestBody SlotDuration slotDuration){
    	AvailableSlotDTO availableSlotDTO = auctionSlotService.getAvaiSlotDTO(slotDuration);
    	return new ResponseEntity<>(availableSlotDTO,HttpStatus.OK);
    }
}
