package org.magiceagle.filexpress.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "a_id")
    private User a;

    @ManyToOne
    @JoinColumn(name = "b_id")
    private User b;

    private Date created;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getA() {
        return a;
    }

    public void setA(User a) {
        this.a = a;
    }

    public User getB() {
        return b;
    }

    public void setB(User b) {
        this.b = b;
    }

    public void setCreated(Date now) {
        this.created = now;
    }

    public Date getCreated() {
        return created;
    }
}
