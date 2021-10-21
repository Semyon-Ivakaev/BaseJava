package out.homework4;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public abstract class Client {
    protected int id;
    protected int inn;

    public Client(int id) {
        this.id = id;
        this.inn = createInn();
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public void setInn(int value) {
        this.inn = value;
    }

    public int getInn() {
        return inn;
    }

    public String createName(String typeClient) {
        if ("entity".equals(typeClient)) {
            String[] type = new String[]{"ОАО", "ООО", "АО", "ИП"};
            String name = RandomStringUtils.randomAlphabetic(15);
            return String.format("%s %s", type[new Random().nextInt(type.length)], name);
        } else {
            return RandomStringUtils.randomAlphabetic(15);
        }
    }

    String createSex() {
        String[] sex = new String[]{"М", "Ж"};
        return sex[new Random().nextInt(1)];
    }

    public int createYear() {
        return new Random().nextInt(2021);
    }

    public int createInn() {
        return new Random().nextInt();
    }

    public long createOgrn() {
        return new Random().nextLong();
    }
}
