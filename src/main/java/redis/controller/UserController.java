package redis.controller;

import com.lyentech.bdc.http.response.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.model.User;
import redis.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResultEntity save(@RequestBody User user){
        return ResultEntity.success(userService.saveUser(user));
    }

    @GetMapping("/selectOne")
    public ResultEntity selectOne(@RequestParam("id") Long id){
        return ResultEntity.success(userService.selectOne(id));
    }
}
