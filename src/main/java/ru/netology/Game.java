package ru.netology;

import java.util.HashMap;

public class Game {

    protected HashMap<String, Player> playerList = new HashMap<>();

    public HashMap<String, Player> getPlayersList() {
        return playerList;
    }
    public void register(Player player) {
        playerList.put(player.getName(), player);

    }


    public Player findByName(String name) {
        for (String playerName : playerList.keySet()) {
            if (playerName == name) {
        return playerList.get(name);
            }
        }
        throw new NotRegisteredException("This player" + name + "was not registered");
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}


//   Доработайте прошлую задачу, заменив коллекцию списка игроков на мапу (HashMap) для быстрого поиска информации
//   об игроке по его имени. Создайте Pull Request этой ветки к основной, но не применяйте его. Убедитесь что все
//   тесты проходят, CI работает на вашей ветке.


/*
    Сам же турнир описывается классом Game с методами:
        register(Player player) - метод регистрации игрока; если игрок не зарегистрирован, то он не сможет
        играть в турнире. Вам нужно хранить всех зарегистрированных игроков в поле класса Game в виде
        списка.
        round(String playerName1, String playerName2) - метод соревнования между двумя игроками.
        Если хотя бы один из игроков незарегистрирован, должно выкинуться исключение NotRegisteredException
        (сами создайте его класс). Обратите внимание, что игроки передаются методу через имя - полную
        информацию об игроке нужно будет найти в коллекции зарегистрированных игроков (см. аналог в виде
        findById из прошлых дз). Выигрывает тот игрок, у которого больше strength (сила); если сила
        одинаковая, то будет ничья. Метод должен возвращать одно число - 0 в случае ничьи, 1 в случае
        победы первого игрока и 2 в случае победы второго игрока.
*/