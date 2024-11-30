package com.bidding.slot.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.bidding.slot.entity.AuctionSlot;
import com.bidding.slot.dto.AvailableSlotDTO;
import com.bidding.slot.dto.SlotDuration;
import com.bidding.slot.repository.AuctionSlotRepository;
import com.bidding.slot.strategy.AuctionSlotStrategy;

@ExtendWith(MockitoExtension.class)
class AuctionSlotServiceImplTest {

    @Mock
    private AuctionSlotRepository auctionSlotRepository;

    @Mock
    private Map<String, AuctionSlotStrategy> auctionStatMap;

    @Mock
    private AuctionSlotStrategy mockStrategy;

    @InjectMocks
    private AuctionSlotServiceImpl auctionSlotService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(auctionSlotService, "auctionSlotStrategy", "testStrategy");
    }

    @Test
    void testCreateAuctionSlot() {
        AuctionSlot slot = new AuctionSlot();
        when(auctionSlotRepository.save(slot)).thenReturn(slot);

        AuctionSlot result = auctionSlotService.createAuctionSlot(slot);

        assertNotNull(result);
        verify(auctionSlotRepository).save(slot);
    }

    @Test
    void testGetAuctionSlotById() {
        Long slotId = 1L;
        AuctionSlot slot = new AuctionSlot();
        when(auctionSlotRepository.findById(slotId)).thenReturn(Optional.of(slot));

        Optional<AuctionSlot> result = auctionSlotService.getAuctionSlotById(slotId);

        assertTrue(result.isPresent());
        assertEquals(slot, result.get());
    }

    @Test
    void testGetAuctionSlotsByCategoryCode() {
        String categoryCode = "ELEC";
        List<AuctionSlot> slots = Arrays.asList(new AuctionSlot(), new AuctionSlot());
        when(auctionSlotRepository.findByCategoryCode(categoryCode)).thenReturn(slots);

        List<AuctionSlot> result = auctionSlotService.getAuctionSlotsByCategoryCode(categoryCode);

        assertEquals(2, result.size());
        verify(auctionSlotRepository).findByCategoryCode(categoryCode);
    }

    @Test
    void testDeleteAuctionSlot() {
        Long slotId = 1L;
        
        auctionSlotService.deleteAuctionSlot(slotId);

        verify(auctionSlotRepository).deleteById(slotId);
    }

    @Test
    void testGetAvaiSlotDTO() {
        SlotDuration duration = new SlotDuration();
        AvailableSlotDTO expectedDto = new AvailableSlotDTO();

        when(auctionStatMap.get("testStrategy")).thenReturn(mockStrategy);
        when(mockStrategy.getAvailableSlot(duration)).thenReturn(expectedDto);

        AvailableSlotDTO result = auctionSlotService.getAvaiSlotDTO(duration);

        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(auctionStatMap).get("testStrategy");
        verify(mockStrategy).getAvailableSlot(duration);
    }
}
