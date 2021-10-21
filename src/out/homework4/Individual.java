package out.homework4;

import java.util.Objects;

public class Individual extends Client{
    private String fio;
    private int year;
    private String sex;


    public Individual(int id) {
        super(id);
        this.fio = createName("individual");
        this.year = createYear();
        this.sex = createSex();
    }

    public String getFio() {
        return fio;
    }

    public int getYear() {
        return year;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", year=" + year + '\'' +
                ", sex='" + sex + '\'' +
                ", inn=" + inn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Individual that = (Individual) o;
        return id == that.id && year == that.year && fio.equals(that.fio) && sex.equals(that.sex) && inn == that.inn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, year, sex, inn);
    }
}
