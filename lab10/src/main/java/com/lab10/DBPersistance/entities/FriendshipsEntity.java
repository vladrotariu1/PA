package com.lab10.DBPersistance.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "friendships")
public class FriendshipsEntity {

    @EmbeddedId
    @Column(name = "friendship")
    private Key friendship;

    public Key getFriendship() {
        return friendship;
    }

    public int getUser1Id() { return friendship.getId_1(); }

    public int getUser2Id() { return friendship.getId_2(); }

    public void setFriendship(int id_1, int id_2) {
        this.friendship = new Key(id_1, id_2);
    }

    @Override
    public String toString() {
        return "FriendshipsEntity{" +
                "friendship=" + friendship +
                '}';
    }
}

@Embeddable
class Key implements Serializable {
    private int id_1;
    private int id_2;

    public Key(){}

    public Key(int id_1, int id_2) {
        this.id_1 = id_1;
        this.id_2 = id_2;
    }

    public int getId_1() {
        return id_1;
    }

    public void setId_1(int id_1) {
        this.id_1 = id_1;
    }

    public int getId_2() {
        return id_2;
    }

    public void setId_2(int id_2) {
        this.id_2 = id_2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return id_1 == key.id_1 && id_2 == key.id_2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_1, id_2);
    }

    @Override
    public String toString() {
        return "Key{" +
                "id_1=" + id_1 +
                ", id_2=" + id_2 +
                '}';
    }
}
