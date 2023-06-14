package aero.aviation.flightinfoapplication.data.entity;

import aero.aviation.flightinfoapplication.data.enumeration.CargoType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-11 22:07
 */
@Entity
@Table(name = "cargo")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CargoEntity {
    @Id
    private String id;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "cargo_type")
    @Enumerated(EnumType.STRING)
    private CargoType cargoType;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;
}
