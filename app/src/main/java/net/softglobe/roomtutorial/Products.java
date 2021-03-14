package net.softglobe.roomtutorial;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Products {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String name;
    @ColumnInfo
    String description;
    @ColumnInfo
    int price;

    public Products(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
