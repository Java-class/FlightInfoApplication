package aero.aviation.flightinfoapplication.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Mostafa Anbarmoo
 * @project FlightInfoApplication
 * @created 2023-06-11 20:52
 */
@Entity
@Table(name = "airport")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AirportEntity {
    @Id
    private String id;
    private String code;
    private String name;
    private String address;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sourceAirport")
    private List<FlightEntity> flightList;
}
