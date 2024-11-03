package elhanchir.mohamed.security.sec.services;

import elhanchir.mohamed.security.sec.entities.AppRole;
import elhanchir.mohamed.security.sec.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppRole addNewRole(AppRole appRole);
    AppUser addNewUser(AppUser appUser);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}
