package elhanchir.mohamed.security.sec.web;

import elhanchir.mohamed.security.sec.entities.AppRole;
import elhanchir.mohamed.security.sec.entities.AppUser;
import elhanchir.mohamed.security.sec.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private AccountService accountService;

    @GetMapping("/users")
    public List<AppUser> users() {
        return accountService.listUsers();
    }

    @PostMapping("/users")
    public AppUser saveUser(@RequestBody AppUser appUser) {
        return accountService.addNewUser(appUser);
    }

    @PostMapping("/roles")
    public AppRole saveRole(@RequestBody AppRole appRole) {
        return accountService.addNewRole(appRole);
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleToUserForm form) {
        accountService.addRoleToUser(form.getUsername(), form.getRoleName());
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}