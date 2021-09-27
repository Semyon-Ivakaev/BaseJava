package out.homework4;

import java.util.Random;

public class Data {
    Client[] clients = {
            new Entity(11, "ООО МОЯ ОБОРОНА", 1111111, 555555555),
            new Individual(1, "Иванов Иван Иванович",  "М",  1993, new Random().nextInt()),
            new Entity(12, "ОАО Петров Петр Петрович", new Random().nextInt(), new Random().nextLong()),
            new Individual(5, "Бонд Джеймс Дванулясемь", "М", 1985, new Random().nextInt()),
            new Entity(15, "ОО7 Бонд Джеймс Дванулясемь", new Random().nextInt(), new Random().nextLong()),
            new Individual(2, "Петров Петр Петрович", "М", 1900, new Random().nextInt()),
            new Individual(3, "Гага Леди Ивановна", "Ж", 1980, new Random().nextInt()),
            new Entity(16, "ООО Диджей Смэш Яволна", new Random().nextInt(), new Random().nextLong()),
            new Individual(4, "Сигал Стивен Владимирович", "М", 1960, new Random().nextInt()),
            new Individual(6, "Диджей Смэш Яволна", "М", 1980, new Random().nextInt()),
            new Entity(17, "ООО Баба Яга Костянаянога", new Random().nextInt(), new Random().nextLong()),
            new Entity(18, "ООО Капитан Джек Воробей", new Random().nextInt(), new Random().nextLong()),
            new Entity(11, "ООО МОЯ ОБОРОНА", 1111111, 555555555),
            new Individual(7, "Баба Яга Костянаянога", "Ж", 999, new Random().nextInt()),
            new Individual(8, "Кричащий Витас АААААААович", "М", 1999, new Random().nextInt()),
            new Entity(20, "ООО Кричащий Витас АААААААович", new Random().nextInt(), new Random().nextLong()),
            new Entity(13, "ООО Гага Леди Ивановна", new Random().nextInt(), new Random().nextLong()),
            new Entity(14, "АО Сигал Стивен Владимирович", new Random().nextInt(), new Random().nextLong()),
            new Individual(9, "Eminem Slim Shady", "М", 1983, new Random().nextInt()),
            new Individual(10, "Tupac Amaru Shakur", "М", 1971, new Random().nextInt())
    };

    /**
     * Не требуется, так как задание изменилось.
     */
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
