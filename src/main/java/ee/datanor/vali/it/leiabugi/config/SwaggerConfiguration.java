package ee.datanor.vali.it.leiabugi.config;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Slf4j
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


  @Bean
  public Docket viesApi() {
    Docket docket = new Docket( DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
      .apis( RequestHandlerSelectors.basePackage("ee.datanor.vali.it.leiabugi.controller") ).build()
      .directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
      .useDefaultResponseMessages(false);

    return docket;
  }

  private ApiInfo apiInfo() {
    return new ApiInfo("Vali IT", "Vali IT", "1.0", "",
      "", "", "");
  }


}
