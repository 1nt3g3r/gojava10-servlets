package com.first.servlet.domain;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number")
    private long number;

    @Column(name = "money")
    private int money;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return (int) (number ^ (number >>> 32));
    }
}
