package spring.edu.pe.controladores.configuracion;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/css/**", "/imagenes/**", "/js/**", "/", "/principal", "/home", "/inicio", "/logeo", "/login","/rest/**")
		.permitAll()
		.antMatchers("/peliculas/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/peliculas/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/peliculas/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/peliculas/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/peliculas/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		.antMatchers("/funciones/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/funciones/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/funciones/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/funciones/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/funciones/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
	
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
		.and().logout()
		.permitAll();

	}

}
