package codegym.vn.demosecurity.service;

import codegym.vn.demosecurity.entity.UserRole;
import codegym.vn.demosecurity.repository.UserRepository;
import codegym.vn.demosecurity.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        codegym.vn.demosecurity.entity.User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        List<UserRole> roleList = userRoleRepository.findAllByUser(user);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (UserRole role: roleList) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
        }

        UserDetails userDetails = new User(username, user.getPassword(), grantedAuthorities);

        return userDetails;
    }
}
