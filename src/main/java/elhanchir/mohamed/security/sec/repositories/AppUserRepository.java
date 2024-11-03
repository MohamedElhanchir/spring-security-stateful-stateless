package elhanchir.mohamed.security.sec.repositories;

import elhanchir.mohamed.security.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
