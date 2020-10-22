package com.supergo.goods.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet技术中的拦截器, 曾经是在web.xml中配置.
 * 现在看到的是servlet3.0中的注解配置
 * <filter></filter>
 * <filter-mapping></filter-mapping>
 * 配置监控拦截器
 * druid监控拦截器
 * @ClassName: DruidStatFilter
 * @author 16437
 * @date
 */
@WebFilter(filterName = "druidWebStatFilter",
        urlPatterns = "/*",
        initParams =
                // 忽略资源
                { @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")}
)
public class DruidStatFilter extends WebStatFilter {

}