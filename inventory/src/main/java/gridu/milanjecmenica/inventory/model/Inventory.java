package gridu.milanjecmenica.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "product_availability")
@Data
public class Inventory {
    
    @Id
    @Column(name = "uniq_id")
    private String id;

    @NotNull
    private int inventory;

}
