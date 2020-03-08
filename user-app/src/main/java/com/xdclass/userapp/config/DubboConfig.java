package com.xdclass.userapp.config;

import org.apache.dubbo.config.MetadataReportConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * dubbo 元数据配置
 *
 * @author 梁庆德
 * @date 2020年02月08日 14:51
 */
@Configuration
public class DubboConfig
{
    @Bean
    public MetadataReportConfig metadataReportConfig()
    {
        MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://127.0.0.1:2181");
        return metadataReportConfig;
    }
}
