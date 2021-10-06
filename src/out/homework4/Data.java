package out.homework4;

import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.Charset;
import java.util.Random;


public class Data implements ClientsGenerator {
    Client[] clients = null;

    public void createClientsArray(int countClients) {
        clients = new Client[countClients];

        for (int i = 0; i < countClients; i++) {
            clients[i] = generateClient(i);
        }
    }

    @Override
    public Client generateClient(int id) {
        String name = null;
        int inn = createInn();
        if (id % 2 == 0) {
            name = createName("entity");
            long ogrn = createOgrn();
            return new Entity(id, name, inn, ogrn);
        } else {
            name = createName("individual");
            String sex = createSex();
            int year = createYear();
            return new Individual(id, name, sex, year, inn);
        }
    }

    private String createName(String typeClient) {
        if ("entity".equals(typeClient)) {
            String[] type = new String[]{"ОАО", "ООО", "АО", "ИП"};
            String name = RandomStringUtils.randomAlphabetic(15);
            return String.format("%s %s", type[new Random().nextInt(type.length)], name);
        } else {
            return RandomStringUtils.randomAlphabetic(15);
        }
    }

    private String createSex() {
        String[] sex = new String[]{"М", "Ж"};
        return sex[new Random().nextInt(1)];
    }

    private int createYear() {
        return new Random().nextInt(2021);
    }

    private int createInn() {
        return new Random().nextInt();
    }

    private long createOgrn() {
        return new Random().nextLong();
    }
}
