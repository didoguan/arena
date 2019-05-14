package com.deepspc.arena.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

import com.deepspc.arena.config.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 数据源配置
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "arena.muti-datasource", name = "open", havingValue = "false", matchIfMissing = true)
@EnableTransactionManagement
@MapperScan(basePackages = {"com.deepspc.arena.modular.*.mapper"})
public class SingleDataSourceConfig {


}

