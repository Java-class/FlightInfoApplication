package aero.aviation.flightinfoapplication.data.entity;

import aero.aviation.flightinfoapplication.data.enumeration.FlightType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-11 20:55
 */
@Entity
@Table(name = "flight")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlightEntity {
    @Id
    private String id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "flight_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date flightDate;

    @Column(name = "flight_type")
    @Enumerated(EnumType.STRING)
    private FlightType flightType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "source_airport_id", nullable = false)
    private AirportEntity sourceAirport;

    @OneToMany(mappedBy = "flight")
    private List<CargoEntity> cargoList;
}
