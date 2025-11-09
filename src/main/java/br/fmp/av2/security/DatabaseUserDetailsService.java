package br.fmp.av2.security;

import br.fmp.av2.model.UserAccount;
import br.fmp.av2.repository.UserAccountRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    private final UserAccountRepository repo;

    public DatabaseUserDetailsService(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount ua = repo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return new User(ua.getEmail(), ua.getSenhaHash(),
                List.of(new SimpleGrantedAuthority(ua.getRole())));
    }
}
