
import com.kotlin.jwt.security.service.JWTUserDetailService
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

// java 버전을 올렸더니 WebSerucityConfigurerAdapter은 deprecated 되었다고 한다.
@EnableWebSecurity
class SecurityConfig() : WebSecurityConfigurerAdapter() {

    // Q 생성자를 요런식으로 하면 되나..?
    val jwtUserDetailService: JWTUserDetailService = JWTUserDetailService()

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(jwtUserDetailService)
    }

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/auth")
            .permitAll()
            .anyRequest()
            .authenticated()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }

    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}
