package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    @Test
    public void compareToTest() {
        AviaSouls AviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Красноярск", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Омск", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Санкт-Петербург", 5_000, 10_00, 12_00);
        AviaSouls.add(ticket1);
        AviaSouls.add(ticket2);
        AviaSouls.add(ticket3);
        AviaSouls.add(ticket4);
        AviaSouls.add(ticket5);

        Ticket[] expected = {ticket5, ticket1, ticket2, ticket3, ticket4};
        Ticket[] actual = AviaSouls.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceTest() {
        AviaSouls AviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Краснодар", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Краснодар", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Краснодар", 5_000, 10_00, 12_00);
        AviaSouls.add(ticket1);
        AviaSouls.add(ticket2);
        AviaSouls.add(ticket3);
        AviaSouls.add(ticket4);
        AviaSouls.add(ticket5);
        String from = "Москва";
        String to = "Краснодар";

        Ticket[] expected = {ticket5, ticket1, ticket2,};
        Ticket[] actual = AviaSouls.search(from, to);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByTimeTest() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Москва", "Саратов", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Саратов", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Саратов", 5_000, 10_00, 12_00);
        AviaSouls AviaSouls = new AviaSouls();
        AviaSouls.add(ticket1);
        AviaSouls.add(ticket2);
        AviaSouls.add(ticket3);
        AviaSouls.add(ticket4);
        AviaSouls.add(ticket5);
        String from = "Москва";
        String to = "Саратов";

        Ticket[] expected = {ticket5, ticket2, ticket1,};
        Ticket[] actual = AviaSouls.searchAndSortBy(from, to, timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
