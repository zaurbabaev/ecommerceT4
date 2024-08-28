package az.edu.itbrains.ecommerce.security;

import az.edu.itbrains.ecommerce.exception.UsernameNotFoundException;
import az.edu.itbrains.ecommerce.model.UserEntity;
import az.edu.itbrains.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("Username is empty");
        }

        UserEntity findUser = userRepository.findByEmail(username); // bizim username email-dir
        if (findUser == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        return new User(findUser.getEmail(),
                findUser.getPassword(),
                roles);
    }

}
