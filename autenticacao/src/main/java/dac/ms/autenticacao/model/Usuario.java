package dac.ms.autenticacao.model;
import lombok.Data;

import java.util.List;

import javax.swing.Spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

//import io.jsonwebtoken.lang.Collections;
import java.util.Collections; // Garante o acesso ao método singletonList
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private String senha;  // Será criptografada

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;  // PACIENTE ou FUNCIONARIO

    // Retorna as roles no formato List<String> (ex: ["ROLE_PACIENTE"])
    public List<String> getRoles() {
        return Collections.singletonList("ROLE_" + this.tipo.name());
    }

}
