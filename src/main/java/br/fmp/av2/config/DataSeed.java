package br.fmp.av2.config;

import br.fmp.av2.model.UserAccount;
import br.fmp.av2.repository.UserAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeed {

    @Bean
    CommandLineRunner seedUsers(UserAccountRepository repo, PasswordEncoder encoder) {
        return args -> {
            String email = "admin@fmp.br";
            if (!repo.existsByEmail(email)) {
                String hash = encoder.encode("123456"); // senha: 123456
                repo.save(new UserAccount(email, hash, "ROLE_ADMIN"));
                System.out.println("[seed] Criado usuário: " + email + " / senha=123456");
            }
        };
    }
}
