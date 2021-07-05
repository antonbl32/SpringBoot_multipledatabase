package by.anton.multipledatabase.repository.db1;

import by.anton.multipledatabase.entity.db1.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
