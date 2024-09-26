package org.example.service;

import org.example.persistence.entity.Player;
import org.example.persistence.repository.IPlayerRepository;

import java.util.List;

public class PlayerServiceImpl implements IPlayerService{

    private IPlayerRepository playerRepository;

    public PlayerServiceImpl(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        return this.playerRepository.findById(id);
    }

    @Override
    public void save(Player player) {
        this.playerRepository.save(player);
    }

    @Override
    public void deleteById(Long id) {
        this.playerRepository.deleteById(id);
    }
}