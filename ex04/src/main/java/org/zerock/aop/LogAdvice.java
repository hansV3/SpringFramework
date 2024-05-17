package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component // 스프링에서 빈으로 인식하기 위해 사용
public class LogAdvice {
	
	@Before("execution(* org.zerock.service.SampleService*.*(..)")
	//맨앞의 *는 접근제한자 맨뒤의 *.* 는 클래스이름과 메서드이름을 의미
	public void logBefore() {
		
		log.info("=================================");
	}

}
