package out.homework4;

import java.util.Random;

public class Data {
    Individual[] individual = {new Individual(1, "Иванов Иван Иванович", "М",  20),
            new Individual(2, "Петров Петр Петрович", "М", 23),
            new Individual(3, "Гага Леди Ивановна", "Ж", 29),
            new Individual(4, "Сигал Стивен Владимирович", "М", 56),
            new Individual(5, "Бонд Джеймс Дванулясемь", "М", 25),
            new Individual(6, "Диджей Смэш Яволна", "М", 35),
            new Individual(7, "Баба Яга Костянаянога", "Ж", 77),
            new Individual(8, "Кричащий Витас АААААААович", "М", 41),
            new Individual(1, "Иванов Иван Иванович", "М",  20),
            new Individual(10,"Капитан Джек Воробей", "М", 35)};

    Entity[] entity = {new Entity(11, "ООО МОЯ ОБОРОНА", 1111111, 555555555),
            new Entity(12, "ОАО Петров Петр Петрович", new Random().nextInt(), new Random().nextLong()),
            new Entity(13, "ООО Гага Леди Ивановна", new Random().nextInt(), new Random().nextLong()),
            new Entity(14, "АО Сигал Стивен Владимирович", new Random().nextInt(), new Random().nextLong()),
            new Entity(15, "ОО7 Бонд Джеймс Дванулясемь", new Random().nextInt(), new Random().nextLong()),
            new Entity(16, "ООО Диджей Смэш Яволна", new Random().nextInt(), new Random().nextLong()),
            new Entity(17, "ООО Баба Яга Костянаянога", new Random().nextInt(), new Random().nextLong()),
            new Entity(18, "ООО Капитан Джек Воробей", new Random().nextInt(), new Random().nextLong()),
            new Entity(11, "ООО МОЯ ОБОРОНА", 1111111, 555555555),
            new Entity(20, "ООО Кричащий Витас АААААААович", new Random().nextInt(), new Random().nextLong()),
    };
}
