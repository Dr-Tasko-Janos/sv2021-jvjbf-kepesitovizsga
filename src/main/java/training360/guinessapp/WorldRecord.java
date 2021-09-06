package training360.guinessapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String description;

    private double value;

    private String unitOfMeasure;

    private LocalDate dateOfRecord;

    private Long recorderId;

    public WorldRecord(String description, double value, String unitOfMeasure, LocalDate dateOfRecord, Long recorderId) {
        this.description = description;
        this.value = value;
        this.unitOfMeasure = unitOfMeasure;
        this.dateOfRecord = dateOfRecord;
        this.recorderId = recorderId;
    }
}
