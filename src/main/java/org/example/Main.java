package org.example;

import org.example.persistence.entity.Player;
import org.example.persistence.repository.IPlayerRepository;
import org.example.persistence.repository.PlayerRepositoryImpl;
import org.example.service.IPlayerService;
import org.example.service.PlayerServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        IPlayerRepository playerRepository = new PlayerRepositoryImpl();

        IPlayerService playerService = new PlayerServiceImpl(playerRepository);

        System.out.println(playerService.findAll());

        System.out.println(playerService.findById(1L));

      playerRepository.deleteById(2L);

        Player player = new Player(9L,"Luis Diaz","Liverpool","Delantero");
        playerService.save(player);

        System.out.println(playerService.findAll());



    }
}