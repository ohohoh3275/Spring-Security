import com.kotlin.jwt.security.service.JWTUserDetailService
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
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

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}
