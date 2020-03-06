package com.damu.controller;

import com.damu.pojo.Department;
import com.damu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门控制器
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/hello")
    public String hello() {
        return "hello zhangke!";
    }

    @GetMapping("/list")
    public List<Department> getAllDepartment() {
        return deptService.getAllDepartment();
    }

    /**
     * 根据部门查询
     * @param dname
     * @return
     */
    @GetMapping("/list/deptname/{dname}")
    public List<Department> getDepartmentByName(@PathVariable String dname) {
        return deptService.getDepartmentByName(dname);
    }

    /**
     * 根据部门查询
     * @param location
     * @return
     */
    @GetMapping("/list/location/{location}")
    public List<Department> getDepartmentByLocation(@PathVariable String location) {
        return deptService.getDepartmentByLocation(location);
    }
}
