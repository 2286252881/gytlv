package com.process.exception;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.process.result.ExceptionResultInfo;
import com.process.result.ResultInfo;

public class ExceptionResolverCustom implements HandlerExceptionResolver {

	private static final Logger LOGGER = Logger.getLogger(ExceptionResolverCustom.class);

	private HttpMessageConverter<ExceptionResultInfo> jsonMessageConverter;

	public HttpMessageConverter<ExceptionResultInfo> getJsonMessageConverter() {
		return jsonMessageConverter;
	}

	public void setJsonMessageConverter(HttpMessageConverter<ExceptionResultInfo> jsonMessageConverter) {
		this.jsonMessageConverter = jsonMessageConverter;
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		// 1.输出异常信息,根据异常信息进行处理
		LOGGER.info("捕获出现的异常信息================================");
		LOGGER.info(ex);
		LOGGER.info("捕获出现的异常信息================================");
		// 2.获取出现异常的方法(执行该异常的方法)
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		if (null == handlerMethod) {
			String view = "/exception/globException";
			// 5.2:存储异常信息
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("exceptionResultInfo", "请求出错!");
			modelAndView.setViewName(view);
			return modelAndView;
		}
		Method method = handlerMethod.getMethod();
		// 3.判断是否返回json(只要方法上包含responseBody注解，就表示返回json):查找方法是否包含@ResponseBody注解
		ResponseBody responseBody = AnnotationUtils.findAnnotation(method, ResponseBody.class);
		// 3.1如果是返回json异常
		if (responseBody != null) {
			return resolveJsonException(request, response, handler, ex);// 直接在显示页面中显示异常信息。
		}
		// 4.把异常信息强转为自定异常
		ExceptionResultInfo exceptionResultInfo = resoverExceptionCustom(ex);
		// 5.没有包含@responseBody注解(正常情况下返回指定modelandview页面,如果有异常也在方法中捕获了，返回的异常就是自定义的异常)。
		// 5.1:指定异常页面
		String view = "/exception/globException";

		int messageCode = exceptionResultInfo.getResultInfo().getMessageCode();
		if (messageCode == 106) {
			view = "/public/login";
		}
		// 5.2:存储异常信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exceptionResultInfo", exceptionResultInfo.getResultInfo().getMessage());
		modelAndView.setViewName(view);
		return modelAndView;
	}

	// 异常信息解析方法
	private ExceptionResultInfo resoverExceptionCustom(Exception ex) {
		ResultInfo resultInfo = null;
		if (ex instanceof ExceptionResultInfo) {
			ExceptionResultInfo exceptionResultInfo = (ExceptionResultInfo) ex;
			resultInfo = exceptionResultInfo.getResultInfo();
		} else {
			resultInfo = new ResultInfo();
			resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
			resultInfo.setMessage("未知异常!");
		}
		return new ExceptionResultInfo(resultInfo);
	}

	// 如果有@responsebody注解，将不是json的异常信息转json
	private ModelAndView resolveJsonException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		ExceptionResultInfo exceptionResultInfo = resoverExceptionCustom(ex);
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
		try {
			jsonMessageConverter.write(exceptionResultInfo, MediaType.APPLICATION_JSON, outputMessage);
		} catch (HttpMessageNotWritableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
}