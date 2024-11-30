package com.bidding.slot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bidding.slot.entity.AuctionSlot;

import java.util.List;

public interface AuctionSlotRepository extends JpaRepository<AuctionSlot, Long> {
    
	 @Query(value = "select * from auction_slot a inner join products b on a.product_id = b.product_id where b.category_code = :categoryCode", nativeQuery = true)
	List<AuctionSlot> findByCategoryCode(String categoryCode);
}