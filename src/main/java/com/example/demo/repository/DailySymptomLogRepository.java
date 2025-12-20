package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface AppUserRepository {
    Optional<AppUser> findByEmail(String email);
    AppUser save(AppUser user);
}
