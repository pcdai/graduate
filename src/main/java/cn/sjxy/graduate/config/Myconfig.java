package cn.sjxy.graduate.config;

import cn.sjxy.graduate.component.InterceptorConfig;
import cn.sjxy.graduate.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** 一些页面跳转的逻辑
 * @author dpc
 *
 */
@Configuration
public class Myconfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {


    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/success");
    }
}
