package com.example.educational_center;

import com.example.auth.UserRole;
import com.example.components.ApiResponse;
import com.example.eduSpeciality.EduSpecialityEntity;
import com.example.exp.UnAuthorizedException;
import com.example.util.jwtUtil;
import jakarta.persistence.OneToMany;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/educational-center")

public class EduController {

    @Autowired
    private EduService eduService;

    @PostMapping("/create")
    public HttpEntity<ApiResponse> create(HttpServletRequest request,
                                          @RequestBody EduDTO dto) {
        if (jwtUtil.checkRole(request, UserRole.ADMIN, UserRole.MODERATOR)) {
            return ResponseEntity.ok(eduService.create(dto));
        }
        throw new UnAuthorizedException();
    }

    @PutMapping("/update-by-id/{id}")
    public HttpEntity<ApiResponse> updateById(HttpServletRequest request,
                                              @PathVariable int id,
                                              @RequestBody EduDTO dto) {
        if (jwtUtil.checkRole(request, UserRole.ADMIN, UserRole.MODERATOR)) {
            return ResponseEntity.ok(eduService.updateById(id, dto));
        }
        throw new UnAuthorizedException();
    }

    @DeleteMapping("/delete-by-id/{id}")
    public HttpEntity<ApiResponse> deleteSchoolById(HttpServletRequest request,
                                                    @PathVariable int id) {
        if (jwtUtil.checkRole(request, UserRole.ADMIN, UserRole.MODERATOR)) {
            return ResponseEntity.ok(eduService.deleteById(id));
        }
        throw new UnAuthorizedException();
    }

    @GetMapping("/get-all")
    public HttpEntity<List<EduDTO>> getAll() {
        return ResponseEntity.ok(eduService.getAll());
    }

    @GetMapping("get-by-id/{id}")
    public HttpEntity<EduDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(eduService.getById(id));
    }

    @GetMapping("/get-by-name/{name}")
    public HttpEntity<List<EduDTO>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(eduService.getByName(name));
    }

    @GetMapping("/get-by-address/{address}")
    public HttpEntity<List<EduDTO>> getByAddress(@PathVariable String address) {
        return ResponseEntity.ok(eduService.getByAddress(address));
    }

    @GetMapping("/get-types")
    public HttpEntity<EduCenterType[]> getTypes() {
        return ResponseEntity.ok(EduCenterType.values());
    }
}
