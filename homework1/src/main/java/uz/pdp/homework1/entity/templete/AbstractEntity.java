package uz.pdp.homework1.entity.templete;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import uz.pdp.homework1.entity.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MapKeyColumn(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @MapKeyColumn(nullable = false, updatable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;


    @CreatedBy
//    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Long createdBy;


    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User updatedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
