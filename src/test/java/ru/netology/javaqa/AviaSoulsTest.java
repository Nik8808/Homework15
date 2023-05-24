package ru.netology.javaqa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    @Test
    public void compareToTest() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Красноярск", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Омск", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Санкт-Петербург", 5_000, 10_00, 12_00);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket5, ticket1, ticket2, ticket3, ticket4};
        Ticket[] actual = aviaSouls.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void sortByPriceMultipleTest() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Краснодар", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Краснодар", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Краснодар", 5_000, 10_00, 12_00);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        String from = "Москва";
        String to = "Краснодар";

        Ticket[] expected = {ticket5, ticket1, ticket2,};
        Ticket[] actual = aviaSouls.search(from, to);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceTest() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Челябинск", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Норильск", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Омск", 5_000, 10_00, 12_00);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        String from = "Москва";
        String to = "Норильск";

        Ticket[] expected = {ticket2};
        Ticket[] actual = aviaSouls.search(from, to);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceNotFoundTest() {
        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Челябинск", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Калининград", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Омск", 5_000, 10_00, 12_00);
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        String from = "Москва";
        String to = "Чита";

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search(from, to);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByTimeMultipleTest() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Москва", "Саратов", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Саратов", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Саратов", 5_000, 10_00, 12_00);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        String from = "Москва";
        String to = "Саратов";

        Ticket[] expected = {ticket5, ticket2, ticket1,};
        Ticket[] actual = aviaSouls.searchAndSortBy(from, to, timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void sortByTimeOneTest() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Москва", "Сочи", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Иркутск", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Ростов-на-Дону", 5_000, 10_00, 12_00);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        String from = "Москва";
        String to = "Иркутск";

        Ticket[] expected = {ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy(from, to, timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void sortByTimeFoundTest() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("Москва", "Екатеринбург", 10_000, 10_00, 17_00);
        Ticket ticket2 = new Ticket("Москва", "Иркутск", 20_000, 10_00, 15_00);
        Ticket ticket3 = new Ticket("Москва", "Новосибирск", 50_000, 10_00, 19_00);
        Ticket ticket4 = new Ticket("Москва", "Владивосток", 70_000, 10_00, 21_00);
        Ticket ticket5 = new Ticket("Москва", "Саратов", 5_000, 10_00, 12_00);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        String from = "Москва";
        String to = "Пятигорск";

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy(from, to, timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
