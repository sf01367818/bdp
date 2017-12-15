package com.sf.bdp.marathon.handler;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sf.bdp.marathon.common.bean.Response;

/**
 * @author 01368020
 * @date 2017/11/1 11:30
 * @desc 统一异常处理类，处理参数验证异常
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {

  private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

  /**
   * 引入单个或几个参数验证的配置，不引入则无法校验单个或几个参数
   *
   * @return MethodValidationPostProcessor
   * @author 01368020
   */
  @Bean
  public MethodValidationPostProcessor methodValidationPostProcessor() {
    return new MethodValidationPostProcessor();
  }

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Response<Object> handle(ValidationException exception) {
    StringBuilder sb = new StringBuilder();
    Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) exception).getConstraintViolations();
    for (ConstraintViolation<?> item : constraintViolations) {
      sb.append("; " + item.getMessage());
    }
    String ret = sb.toString().replaceFirst("; ", "");
    logger.info("请求参数异常, " + ret);
    //统一返回错误信息给前端
    return Response.error(ret);
  }
}