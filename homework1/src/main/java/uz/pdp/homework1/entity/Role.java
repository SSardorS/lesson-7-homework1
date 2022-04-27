package uz.pdp.homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.homework1.config.AuditingListener;
import uz.pdp.homework1.entity.enums.Permission;
import uz.pdp.homework1.entity.templete.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(value = AuditingListener.class)
public class Role extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    @ElementCollection
    private List<Permission> roleList;

    @Column(columnDefinition = "text")
    private String description;




}
