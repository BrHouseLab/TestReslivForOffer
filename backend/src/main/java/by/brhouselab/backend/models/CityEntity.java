package by.brhouselab.backend.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city")
public class CityEntity {
    private long id = -1;
    private String name = "";
    private String info = "";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (id != that.id) return false;
        if (!name.equals(that.name)) return false;
        return Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }
}
