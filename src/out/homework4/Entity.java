package out.homework4;

import java.util.Objects;

public class Entity extends Client{
    private String name;
    private int inn;
    private long ogrn;

    public Entity(int id, String name, int inn, long ogrn) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.ogrn = ogrn;
    }

    public String getName() {
        return name;
    }

    public int getInn() {
        return inn;
    }

    public long getOgrn() {
        return ogrn;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inn=" + inn +
                ", ogrn=" + ogrn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id && inn == entity.inn && ogrn == entity.ogrn && Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, inn, ogrn);
    }
}
