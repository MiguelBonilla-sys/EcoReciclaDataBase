package com.example.EcoApp.EcoRecicla.Repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.EcoApp.EcoRecicla.Models.User;
import java.util.*;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}