package nathan.redis.controller;

import lombok.AllArgsConstructor;
import nathan.redis.db.entity.Users;
import nathan.redis.db.repo.UsersRepository;
import nathan.redis.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class TestController {

    private final UsersRepository usersRepository;
    private final UsersService usersService;

    @GetMapping("/get")
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Users> getUser(@PathVariable Long id) {
        return usersService.getUserById(id);
    }

    @PostMapping("/insert")
    public Users insertUsers(@RequestBody Users users) {
        return usersRepository.save(users);
    }
}
