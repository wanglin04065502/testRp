package com.fuyin.logistics.modules.sys.controller;

import com.fuyin.logistics.modules.KdGoldAPIDemo;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 系统页面视图
 */
@Controller
public class SysPageController {

	/**
	 * 页面跳转
	 * @param module
	 * @param function
	 * @param url
	 * @return
	 */
	@RequestMapping("/{module}/{function}/{url}.html")
	public String page(@PathVariable("module") String module, @PathVariable("function") String function,
			@PathVariable("url") String url) {
		return "/" + module + "/" + function + "/" + url + ".html";
	}

	/**
	 * 404页面
	 * @return
	 */
	@RequestMapping("/error/404")
	public String notFoundPage() {
		return "/error/404.html";
	}

	/**
	 * 403页面
	 * @return
	 */
	@RequestMapping("/error/403")
	public String noAuthPage() {
		return "/error/403.html";
	}

	/**
	 * 500页面
	 * @return
	 */
	@RequestMapping("/error/500")
	public String sysError() {
		return "/error/500.html";
	}

	/**
	 * 系统首页
	 * @return
	 */
	@RequestMapping("/dashboard")
//	public String main() {
//		return "/system/dashboard.html";
//	}
	public String main() {
		return "/base/area/list.html";
	}

	/**
	 * 快递电子面单测试
	 * @return
	 */
	@RequestMapping("/kuaidi")
	public String kuaidi() {
		return "/kuaidi.html";
	}

	/**
	 * 快递电子面单测试
	 * @return
	 */
	@RequestMapping("/dzmd")
	public String dzmd(Map<String,Object> map, HttpServletRequest request) throws Exception {
		String kdname =  request.getParameter("kdname");
		String name =  request.getParameter("name");
		String mobile =  request.getParameter("mobile");
		KdGoldAPIDemo kdGoldAPIDemo = new KdGoldAPIDemo();
		String result = kdGoldAPIDemo.orderOnlineByJson(kdname,name,mobile);
		JSONObject jsonObj = new JSONObject(result);
		String PrintTemplate = (String) jsonObj.get("PrintTemplate");
//		System.out.println(PrintTemplate);
		map.put("PrintTemplate",PrintTemplate);
		return "/dzmd.html";
	}
}
