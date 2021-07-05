package by.anton.multipledatabase.service;

import by.anton.multipledatabase.entity.db1.User;
import by.anton.multipledatabase.entity.db2.Department;
import by.anton.multipledatabase.repository.db2.DepartmentRepository;
import by.anton.multipledatabase.repository.db1.UserRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Data
@NoArgsConstructor
@Service
public class AllServices {

    private UserRepository userRepository;
    private DepartmentRepository departmentRepository;
    @Autowired
    public AllServices(UserRepository userRepository, DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }
    @PostConstruct
    public void addToBases(){
        User user=new User();
        user.setName("Anton");
        user.setPassword("1234");
        userRepository.save(user);
        Department department=new Department();
        department.setName("UN");
        department.setUserId(1);
        departmentRepository.save(department);
    }
}
