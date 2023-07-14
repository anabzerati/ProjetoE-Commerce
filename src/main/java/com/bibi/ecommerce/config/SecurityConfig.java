package com.bibi.ecommerce.config;

import com.bibi.ecommerce.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginDAO loginDAO;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // Páginas que qualquer usuário pode acessar
                .antMatchers("/resources/**", "static/**", "/plugins/**", "/", "/index", "/sobre").permitAll()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
                /* Páginas que começam com admin só o usuário com role ADMIN pode acessar. */
                .antMatchers("/admin/**").hasRole("ADMIN")
                /* Páginas que começam com cliente ou usuário só o usuário com role CLIENTE pode acessar. */
                .antMatchers("/cliente/**", "/usuario/**").hasRole("CLIENTE")
                // As rotas de login e de cadastro só são permitidas se o usuário não estiver logado
                .antMatchers("/login", "/cadastro/**").anonymous()
                // Qualquer outra rota só será permitida se o usuário estiver autenticado
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                /* Quando realiza o logout redireciona para a index. */
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index");
    }

    /**
     * Informa ao Spring Security qual classe implementa a interface UserDetailService (para realização do login) e
     * qual ferramenta de criptografia de senhas será utilizada.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginDAO).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER");
    }
}