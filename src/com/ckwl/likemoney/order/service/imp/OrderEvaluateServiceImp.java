package com.ckwl.likemoney.order.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.order.dao.IOrderEvaluateDaoImp;
import com.ckwl.likemoney.order.dao.imp.OrderEvaluateDaoImp;
import com.ckwl.likemoney.order.entity.Order;
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.entity.OrderEvaluate;
import com.ckwl.likemoney.order.service.IOrderEvaluateService;
import com.ckwl.likemoney.order.view.OrderEvaluateConditionView;
import com.ckwl.likemoney.order.view.OrderEvaluateQueryView;
import com.ckwl.likemoney.user.entity.UserCustomer;

public class OrderEvaluateServiceImp implements IOrderEvaluateService {
	private IOrderEvaluateDaoImp OrderEvaluateDao = new OrderEvaluateDaoImp(); 
	
	@MyTransaction(readOnly=false)
	@Override
	public void insert(OrderEvaluate OrderEvaluate) {
		// TODO Auto-generated method stub
		OrderEvaluateDao.insert(OrderEvaluate);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(OrderEvaluate OrderEvaluate) {
		// TODO Auto-generated method stub
		OrderEvaluateDao.delete(OrderEvaluate);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(OrderEvaluate OrderEvaluate) {
		// TODO Auto-generated method stub
		OrderEvaluateDao.update(OrderEvaluate);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<OrderEvaluateQueryView> list(OrderEvaluateConditionView OrderEvaluateConditionView) {
		// TODO Auto-generated method stub
		return OrderEvaluateDao.list(OrderEvaluateConditionView);
	}

}
