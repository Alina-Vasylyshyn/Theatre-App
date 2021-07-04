package theatre.spring.controller;

import java.util.Locale;
import java.util.Set;
import theatre.spring.model.Role;
import theatre.spring.model.User;
import theatre.spring.service.RoleService;
import theatre.spring.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InjectController {
    private final RoleService roleService;
    private final UserService userService;

    public InjectController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/")
    private String welcome(Authentication authentication) {
        return String.format("Hello, %s!", authentication.getName().substring(0,
                authentication.getName().indexOf('@')).toUpperCase(Locale.ROOT));
    }

    @GetMapping("/inject")
    public String injectData() {
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN.name());
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setName(Role.RoleName.USER.name());
        roleService.add(userRole);

        User bob = new User();
        bob.setEmail("bob@gmail.com");
        bob.setPassword("1234");
        bob.setRoles(Set.of(adminRole));
        userService.add(bob);

        User alice = new User();
        alice.setEmail("alice@gmail.com");
        alice.setPassword("5632");
        alice.setRoles(Set.of(userRole));
        userService.add(alice);
        return "Done!";
    }
}
