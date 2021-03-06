package com.baoxina.web.annotation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baoxina.web.po.Items;

//使用Controller标识 它是一个控制器
@Controller
public class ItemsController_Annotation {

	// @RequestMapping实现 对findItems方法和url进行映射，一个方法对应一个url
	// 一般建议将url和方法写成一样
	@RequestMapping("/findItems.action")
	public ModelAndView findItems() throws Exception {
		// 调用service查找 数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();
		// 向list中填充静态数据

		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图(配置了视图路径的前缀和后缀，直接写逻辑视图名就行了)
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}
}
