package gic.i4c.GicCafe.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Invoice {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    private String drink_order_ids;

    private Integer table_id;

    private Float price;

    @CreationTimestamp
    private LocalDateTime created_at;

    private String note;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDrink_order_ids() {
        return this.drink_order_ids;
    }

    public void setDrink_order_ids(String drink_order_ids) {
        this.drink_order_ids = drink_order_ids;
    }

    public Integer getTable_id() {
        return this.table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
