package nathan.redis.service;

import lombok.AllArgsConstructor;
import nathan.redis.db.entity.Users;
import nathan.redis.db.repo.UsersRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    // 快取 key 為 users::id
    @Cacheable(value = "users", key = "#id")
    public Optional<Users> getUserById(Long id) {
        System.out.println("--- DB Query: 正在從 PostgreSQL 讀取 ID 為 " + id + " 的資料 ---");
        return usersRepository.findById(id);
    }
}
