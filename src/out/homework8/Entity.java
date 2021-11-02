package out.homework8;

import java.util.Objects;

public class Entity extends Client {
    private String name;
    private long ogrn;

    public Entity(int id) {
        super(id);
        this.name = createName("entity");
        this.ogrn = createOgrn();
    }

    public String getName() {
        return name;
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
