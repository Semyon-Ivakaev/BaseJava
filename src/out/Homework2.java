package out;

import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        String[][] clients = {{"Иванов Иван Иванович", "М", "20"}, {"Петров Петр Петрович", "М", "23"},
                {"Гага Леди Ивановна", "Ж", "29"}, {"Сигал Стивен Владимирович", "М", "56"},
                {"Бонд Джеймс Дванулясемь", "М", "25"}, {"Диджей Смэш Яволна", "М", "35"},
                {"Баба Яга Костянаянога", "Ж", "77"}, {"Кричащий Витас АААААААович", "М", "41"},
                {"Никтов Никто Никтовович", "М", "1"}, {"Капитан Джек Воробей", "М", "35"}};

        for (int i = 0; i < clients.length; i++) {
            if (clients[i][1].equals("М")) {
                for (int j = i + 1; j < clients.length; j++) {
                    if (Integer.parseInt(clients[i][2]) > Integer.parseInt(clients[j][2])) {
                        String[] client = clients[i];
                        clients[i] = clients[j];
                        clients[j] = client;
                    }
                }
            }
        }

        for (String[] el: clients) {
            if (el[1].equals("М")) {
                System.out.println(Arrays.toString(el));
            }
        }
    }
}
