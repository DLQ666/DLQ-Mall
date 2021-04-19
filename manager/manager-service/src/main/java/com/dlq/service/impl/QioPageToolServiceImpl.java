package com.dlq.service.impl;

import com.dlq.mapper.*;
import com.dlq.pojo.*;
import com.dlq.service.QioPageToolService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import pagetool.Pages;

/**
 * @author Qiqoo dai lian qi 2019年4月7日
 * @version v1.5
 * 分页工具实现类 QioPageToolServiceImpl 
 * 方法名及参数为pagesRows(int pageNum, intpageRows)
 */
@Service
public class QioPageToolServiceImpl implements QioPageToolService {

	@Autowired
	private QioItemMapper oitemMapper;

	@Autowired
	private QioBrandMapper obrandMapper;
	
	@Autowired
	private QioModelMapper oModelMapper;
	
	@Autowired
	private QioCategoryMapper oCategoryMapper;
	
	@Autowired
	private QioOrderShopMapper oOrderShopMapper;
	
	@Autowired
	private QioContentMapper oContentMapper;
	
	@Autowired
	private QioUserMapper oUserMapper;
	
	@Autowired
	private QioItemsMapper qioItemsMapper;
	
	@Autowired
	private QioOrderItemMapper qioOrderItemMapper;

	/**
	 * 商品列表分页pagesRows
	 */
	@Override
	public Pages pagesRows(int pageNum, int pageRows) {

		PageHelper.startPage(pageNum, pageRows);

		Page<QioItem> pagetool = (Page<QioItem>) oitemMapper.selectByExample(null);

		Pages result = new Pages(pagetool.getTotal(), pagetool.getResult());
		return result;

	}
	/**
	 * 品牌列表分页pagesRows2
	 */
	@Override
	public Pages pagesRows2(int pageNum, int pageRows) {
		PageHelper.startPage(pageNum, pageRows);

		Page<QioBrand> pagetool = (Page<QioBrand>) obrandMapper.selectByExample(null);

		Pages result = new Pages(pagetool.getTotal(), pagetool.getResult());
		return result;
	}
	/**
	 * 型号列表分页pagesRows3
	 */
	@Override
	public Pages pagesRows3(int pageNum, int pageRows) {
		PageHelper.startPage(pageNum, pageRows);
		
		Page<QioModel> pagetool=(Page<QioModel>)  oModelMapper.selectByExample(null);
		Pages result = new Pages(pagetool.getTotal(), pagetool.getResult());
		return result;
	}
	
	/**
	 * 分类列表分页pagesRows4
	 */
	@Override
	public Pages pagesRows4(int pageNum, int pageRows) {
		PageHelper.startPage(pageNum, pageRows);
		
		Page<QioCategory> pagetool=(Page<QioCategory>)  oCategoryMapper.selectByExample(null);
		Pages result = new Pages(pagetool.getTotal(), pagetool.getResult());
		return result;
	}
	
	@Override
	public Pages pagesRows5(int pageNum, int pageRows) {
		PageHelper.startPage(pageNum, pageRows);
		
		Page<QioOrderShop> pagetool=(Page<QioOrderShop>)  oOrderShopMapper.selectByExample(null);
		Pages result = new Pages(pagetool.getTotal(), pagetool.getResult());
		return result;
	}
	
	@Override
	public Pages pagesRows6(int pageNum, int pageRows) {
		PageHelper.startPage(pageNum, pageRows);
		
		Page<QioContent> pagetool=(Page<QioContent>)  oContentMapper.selectByExample(null);
		Pages result = new Pages(pagetool.getTotal(), pagetool.getResult());
		return result;
	}
	
	@Override
	public Pages pagesRows7(int pageNum, int pageRows) {
		PageHelper.startPage(pageNum, pageRows);
		
		Page<QioUser> pagetool=(Page<QioUser>)  oUserMapper.selectByExample(null);
		Pages result = new Pages(pagetool.getTotal(), pagetool.getResult());
		return result;
	}
	
	@Override
	public Pages pagesRows8(int pageNum, int pageRows) {
		PageHelper.startPage(pageNum, pageRows);
		Page<QioOrderItem> pagetool=(Page<QioOrderItem>)  qioOrderItemMapper.selectByExample(null);
		Pages result = new Pages(pagetool.getTotal(), pagetool.getResult());
		return result;
	}
	
}
