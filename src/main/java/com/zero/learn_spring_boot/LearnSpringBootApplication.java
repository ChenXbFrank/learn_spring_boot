package com.zero.learn_spring_boot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class LearnSpringBootApplication {

	/**
	 * 使用fastJson的方式一     需要  extends WebMvcConfigurationSupport
	 * 1.需要先定义一个convert转换消息的对象
	 * 2.添加fastJson的配置信息，比如：是否要格式化返回的json数据
	 * 3.在convert中添加配置信息
	 * 4.将convert添加到converts当中
	 * @param converters
	 */
	/*public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		//1.需要先定义一个convert转换消息对象
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		//2.添加fastJson的配置信息，比如：是否要格式化返回的json数据
		FastJsonConfig fastConfig=new FastJsonConfig();
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastConfig);
		//4.将convert添加到converts当中
		converters.add(fastConverter);
	}*/

	/**
	 * 这种方式不需要 extends WebMvcConfigurationSupport
	 * 在这里使用@Bean注入 使用fastJson方式二
	 */
	@Bean
	public HttpMessageConverters fastJsonConverters() {
		//1.需要先定义一个convert转换消息对象
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		//2.添加fastJson的配置信息，比如：是否要格式化返回的json数据
		FastJsonConfig fastConfig=new FastJsonConfig();
		fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		//3.在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastConfig);
		//4.将convert添加到converts当中
		HttpMessageConverter<?> converter=fastConverter;
		return new HttpMessageConverters(converter);
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}


}
