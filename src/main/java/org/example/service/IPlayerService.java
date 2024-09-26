package org.example.service;

import org.example.persistence.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    Player findById(Long id);
    void save(Player player);
    void deleteById(Long id);
}
