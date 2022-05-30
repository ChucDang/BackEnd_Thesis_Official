package thud.luanvanofficial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thud.luanvanofficial.entity.User;
import thud.luanvanofficial.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailServiceIml implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
       Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        return user.orElseThrow(()->new UsernameNotFoundException("Username hoặc Password không hợp lệ"));
    }
}
