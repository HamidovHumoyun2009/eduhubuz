package com.example.eduSpeciality;


import com.example.auth.UserRole;
import com.example.components.ApiResponse;
import com.example.exp.UnAuthorizedException;
import com.example.util.jwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/edu_speciality")

public class EduSpecialityController {

    @Autowired
    private EduSpecialityService eduSpecialityService;

    @PostMapping("/create")
    public HttpEntity<ApiResponse> create(HttpServletRequest request,
                                          @RequestBody EduSpecialtyDto dto) {
        if (jwtUtil.checkRole(request, UserRole.ADMIN,UserRole.MODERATOR)){
            return ResponseEntity.ok(eduSpecialityService.create(dto));
        }
        throw new UnAuthorizedException();
    }

    @PutMapping("/update-by-id/{id}")
    public HttpEntity<ApiResponse> updateById(HttpServletRequest request,
                                              @PathVariable int id,
                                              @RequestBody EduSpecialtyDto dto) {
        if (jwtUtil.checkRole(request, UserRole.ADMIN, UserRole.MODERATOR)) {
            return ResponseEntity.ok(eduSpecialityService.updateById(id, dto));
        }
        throw new UnAuthorizedException();
    }

    @DeleteMapping("/delete-by-id/{id}")
    public HttpEntity<ApiResponse> deleteById(HttpServletRequest request,
                                                    @PathVariable int id) {
        if (jwtUtil.checkRole(request, UserRole.ADMIN, UserRole.MODERATOR)) {
            return ResponseEntity.ok(eduSpecialityService.deleteById(id));
        }
        throw new UnAuthorizedException();
    }

    @GetMapping("/get-all")
    public HttpEntity<List<EduSpecialityEntity>> getAll() {
        return ResponseEntity.ok(eduSpecialityService.getAll());
    }

    @GetMapping("get-by-id/{id}")
    public HttpEntity<EduSpecialityEntity> getById(@PathVariable int id) {
        return ResponseEntity.ok(eduSpecialityService.getById(id));
    }

    @GetMapping("/get-by-name/{name}")
    public HttpEntity<List<EduSpecialityEntity>>getByPhone(@PathVariable String name) {
        return ResponseEntity.ok(eduSpecialityService.getByName(name));
    }

    @GetMapping("get-all-by/{eduCenterId}")
    public HttpEntity<List<EduSpecialityEntity>> getByPhone(@PathVariable int eduCenterId) {
        return ResponseEntity.ok(eduSpecialityService.getAllByEduCenterId(eduCenterId));
    }
}
