package by.anton.multipledatabase.entity.db2;

import by.anton.multipledatabase.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dept")
public class Department extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "user_id")
    private int userId;
}
