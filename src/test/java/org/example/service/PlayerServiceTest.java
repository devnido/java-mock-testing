package org.example.service;

import org.example.DataProvider;
import org.example.persistence.entity.Player;
import org.example.persistence.repository.IPlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.example.DataProvider.playerListMock;
import static org.example.DataProvider.playerMock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private IPlayerRepository playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;


    @Test
    public void testFindAll(){

        // when
        when(this.playerRepository.findAll()).thenReturn(playerListMock());

        List<Player> result = this.playerService.findAll();

        // then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Lionel Messi", result.get(0).getName());
        assertEquals("Inter Miami", result.get(0).getTeam());
        assertEquals("Delantero", result.get(0).getPosition());
        verify(this.playerRepository).findAll();
    }

    @Test
    public void testFindById(){
        // Given
        Long id = 1L;

        // When
        when(this.playerRepository.findById( anyLong() )).thenReturn(playerMock());
        Player player = this.playerService.findById(id);

        // Then
        assertNotNull(player);
        assertEquals("Lionel Messi", player.getName());
        assertEquals("Inter Miami", player.getTeam());
        assertEquals("Delantero", player.getPosition());
        verify(this.playerRepository).findById( anyLong() );
    }

    @Test
    public void testSave(){
        // Given
        Player player = DataProvider.newPlayerMock();

        // When
        this.playerService.save(player);

        // Then
        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(this.playerRepository).save( any(Player.class) );
        verify(this.playerRepository).save( playerArgumentCaptor.capture() );
        assertEquals(10L, playerArgumentCaptor.getValue().getId());
        assertEquals("Luiz Diaz", playerArgumentCaptor.getValue().getName());
    }

    @Test
    void testDeleteById(){
        // Given
        Long id = 1L;

        // When
        this.playerService.deleteById(id);

        // Then
        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepository).deleteById( anyLong() );
        verify(this.playerRepository).deleteById( longArgumentCaptor.capture() );
        assertEquals(1L, longArgumentCaptor.getValue());
    }
}
