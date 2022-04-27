package uz.pdp.homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.homework1.entity.templete.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Trafics extends AbstractEntity {

    private String trafficName;

    private Double trafficSum;

    //tarifga  otish summasi
    private Double trafficNds;

    private String description;

    @ManyToMany
    private List<User> user;

    private boolean active;
}
