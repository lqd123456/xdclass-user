package com.xdclass.userapp.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 连接池配置
 * 浏览器 访问 http://localhost:8091/druid
 *
 * @author 梁庆德onond
 * @Date 2020/2/5 0:06
 */
@Configuration
public class DruidConfig
{
    @Value("${druid.login.user_name}")
    private String userName;

    @Value("${druid.login.password}")
    private String password;

    /**
     * 加载配置文件 里面的数据源信息
     *
     * @author 梁庆德
     * @date 2020年02月05日 0:17
     * @param
     * @return
     */
    @Bean(name = "default_datasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource()
    {
        return new DruidDataSource();
    }

    /**
     * 配置登录后台的账号和密码
     *
     * @author 梁庆德
     * @date 2020年02月05日 0:19
     * @param
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet()
    {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<>(3);

        // 用户名
        initParameters.put("loginUsername", userName);
        // 密码
        initParameters.put("loginPassword", password);
        // 禁用HTML页面上的“Reset All”功能
        initParameters.put("resetEnable", "false");
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    /**
     * 配置过滤器
     *
     * @author 梁庆德
     * @date 2020年02月05日 0:20
     * @param
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
