package alexandr.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "cars")
public class Car {
    @Id
    @Column(name = "cars_number")
    private String number;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "year_of_manufacture")
    private int year;

    @JsonIgnore
    @Column(name = "create_data")
    private LocalDateTime create;
    {
        this.create = LocalDateTime.now();
    }

    public Car(String number, String model, String color, int year) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%s with number %s color %s released in %d", model, number, color, year);
    }
}
