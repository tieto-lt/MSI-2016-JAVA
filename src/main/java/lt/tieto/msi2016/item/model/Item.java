package lt.tieto.msi2016.item.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Item {

    private Long id;

    @NotNull
    private String name;

    @Min(0)
    private Integer quantity;

    @NotNull
    @Pattern(regexp="\\d*x\\d*")
    private String size;

    public Item() {
    }

    public Item(Long id, String name, Integer quantity, String size) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("quantity", quantity)
                .append("size", size)
                .toString();
    }
}