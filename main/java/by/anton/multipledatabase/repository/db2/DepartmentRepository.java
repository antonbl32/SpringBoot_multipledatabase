package by.anton.multipledatabase.repository.db2;

import by.anton.multipledatabase.entity.db2.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
