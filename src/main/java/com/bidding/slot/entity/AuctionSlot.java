package com.bidding.slot.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AUCTION_SLOT")
public class AuctionSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auction_slot_slot_id_seq")
    @SequenceGenerator(name = "auction_slot_slot_id_seq", sequenceName = "auction_slot_slot_id_seq", allocationSize = 1)
    @Column(name = "slot_id")
    private Long slotId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "slot_name", nullable = false)
    private String slotName;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "slot_section", nullable = false)
    private Integer slotSection;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Long getSlotId() {
		return slotId;
	}



	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}



	public Long getProductId() {
		return productId;
	}



	public void setProductId(Long productId) {
		this.productId = productId;
	}



	public String getSlotName() {
		return slotName;
	}



	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}



	public LocalDateTime getStartTime() {
		return startTime;
	}



	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}



	public LocalDateTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}



	public Integer getSlotSection() {
		return slotSection;
	}



	public void setSlotSection(Integer slotSection) {
		this.slotSection = slotSection;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public AuctionSlot() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AuctionSlot(Long slotId, Long productId, String slotName, LocalDateTime startTime, LocalDateTime endTime,
			Integer slotSection, LocalDateTime createdAt) {
		super();
		this.slotId = slotId;
		this.productId = productId;
		this.slotName = slotName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.slotSection = slotSection;
		this.createdAt = createdAt;
	}



	@PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
