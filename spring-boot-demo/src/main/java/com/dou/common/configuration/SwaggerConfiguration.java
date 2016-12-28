package com.dou.common.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8080/swagger-ui.html
 * @Description:利用 Swagger 生成api文档,如果我们想修改swagger-ui.html样式，
 * 我们可以将swagger-ui的架包拷贝到public目录下面自己修改swagger-ui.html里面内容
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Value("${system.enableSwagger}")
	private String enableSwagger;
	
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
		.groupName("test")
		.enable(isEnable())
		.apiInfo(apiInfo())
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.dou.web"))
		.paths(PathSelectors.any())
		.build();
		
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
		.title("Spring Boot中使用Swagger2构建RESTful APIs")
		.description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
		.termsOfServiceUrl("http://blog.didispace.com/")
		.contact("程序员：豆留江")
		.version("1.0")
		.build();
	}
	
	public Boolean isEnable(){
		return  "true".equals(enableSwagger);
	}
}
