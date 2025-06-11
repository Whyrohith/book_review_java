package Book.Reviews.Book.reviews.Services;

import Book.Reviews.Book.reviews.Entity.MyUserDetails;
import Book.Reviews.Book.reviews.Entity.Users;
import Book.Reviews.Book.reviews.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;


    public CustomUserDetailsService (UserRepository userRepo){
        this.userRepository = userRepo;
    }

    Collection<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    @Override
    public UserDetails loadUserByUsername(String userName){
        Users user = userRepository.findByName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("username is not found" + userName));

        return new MyUserDetails(user);
    }
}
