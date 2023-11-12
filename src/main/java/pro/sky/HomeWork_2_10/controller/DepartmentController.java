package pro.sky.HomeWork_2_10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pro.sky.Homework_29.model.Employee;
import ru.pro.sky.Homework_29.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllByDep(@RequestParam(required = false) Integer dep){
        return dep == null ?
                ResponseEntity.ok(service.getAll())
                :
                ResponseEntity.ok(service.getAllByDepartment(dep));

    }

    @GetMapping("/min-salary")
    public Employee getMin(@RequestParam int dep){
        return service.getMin(dep);
    }

    @GetMapping("/max-salary")
    public Employee getMax(@RequestParam int dep){
        return service.getMax(dep);

    }


}
