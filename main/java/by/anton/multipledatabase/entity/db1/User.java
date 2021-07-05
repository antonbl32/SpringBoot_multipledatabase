package by.anton.multipledatabase.entity.db1;

import by.anton.multipledatabase.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
}
