package com.gytlv.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.commons.utils.ResourcesUtil;
import com.gytlv.base.baseEntity.TUser;
import com.process.context.Config;
import com.process.result.ResultUtil;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 校验用户
		HttpSession session = request.getSession();
		TUser loginUser = (TUser) session.getAttribute("loginUser");
		if (loginUser != null) {
			// 用户登录放行
			return true;
		}
		// 没有登录，如果操作的是公共页面，放行
		List<String> open_urls = ResourcesUtil.gekeyList(Config.ANONYMOUS_ACTIONS);
		String url = request.getRequestURI();
		for (String open_url : open_urls) {
			if (url.indexOf(open_url) > 0) {
				return true;
			}
		}
		// 抛出未登录异常
		ResultUtil.throwExcepion(ResultUtil.createWarning(Config.MESSAGE, 106, null));
		return false;
	}

	/**
	 * 进入action方法，返回modelandview之前执行 使用场景：统一返回数据处理，比如要显示的菜单
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	/**
	 * action方法执行完成后 统一进行日志记录，监控action执行时间
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
