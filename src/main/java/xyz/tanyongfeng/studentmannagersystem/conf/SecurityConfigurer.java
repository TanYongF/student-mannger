package xyz.tanyongfeng.studentmannagersystem.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import xyz.tanyongfeng.studentmannagersystem.model.RestResult;
import xyz.tanyongfeng.studentmannagersystem.pojo.Teacher;
import xyz.tanyongfeng.studentmannagersystem.tools.ResponseUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Describe: 类描述
 * @Author: tyf
 * @CreateTime: 2021/11/15
 **/
@Configuration
@EnableWebSecurity
/*开启方法权限认证*/
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

//    private final TigerLogoutSuccessHandler logoutSuccessHandler = new TigerLogoutSuccessHandler("/login");

    public static final String[] NO_AUTH_LIST={
            "/login",
            "/register",
            "/static/**",
            "/img/**",
            "/css/**",
            "/js/**"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter(
                        "username").permitAll()
                //失败处理
                .failureHandler((req, resp, e) -> ResponseUtil.restResponse(resp, HttpStatus.FORBIDDEN, RestResult.error(403, e.getMessage())))
                //成功处理
                .successHandler((req ,resp, e)-> ResponseUtil.restResponse(resp, HttpStatus.OK,
                        RestResult.success(login(resp))))
                .permitAll()
                .and().exceptionHandling()
                //请求登录处理，改变默认跳转登录页
                .authenticationEntryPoint((req, resp, e) -> resp.sendRedirect("/login"))
                //没有权限访问
                .accessDeniedHandler((req, resp, e) -> ResponseUtil.restResponse(resp, HttpStatus.FORBIDDEN, RestResult.error(403, "抱歉，你当前的身份无权访问")))
                //设置最大一人同时登陆
                .and().sessionManagement().maximumSessions(1)
                .expiredSessionStrategy(s -> ResponseUtil.restResponse(s.getResponse(), HttpStatus.FORBIDDEN, RestResult.error(499, "您的账号在别的地方登录，当前登录已失效")))
                .and()
                //设置登出
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("JSESSIONID").permitAll()
                .and().authorizeRequests().antMatchers(NO_AUTH_LIST).permitAll()
                .antMatchers("/*.svg","/*.png","/*.js","/*.css").permitAll()
                .and().authorizeRequests().anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public Teacher login(HttpServletResponse response){
        Teacher user = (Teacher) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setPassword("*******");
        try {
            response.sendRedirect("/index");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}