package out.homework4;

import java.util.Objects;

public class Individual extends Client{
    private String fio;
    private String sex;
    private int age;

    public Individual(int id, String fio, String sex, int age) {
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.age = age;
    }

    public String getFio() {
        return fio;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual that = (Individual) o;
        return id == that.id && age == that.age && fio.equals(that.fio) && sex.equals(that.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, sex, age);
    }
}
