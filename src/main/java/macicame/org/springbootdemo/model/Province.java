package macicame.org.springbootdemo.model;

import macicame.org.springbootdemo.model.base.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Province extends Identifiable {

    @Column(length = 2, nullable = false, unique = true)
    private String initials;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
