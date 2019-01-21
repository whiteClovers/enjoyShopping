package com.ckwl.likemoney.order.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.order.entity.OrderEvaluate;
import com.ckwl.likemoney.order.view.OrderEvaluateConditionView;
import com.ckwl.likemoney.order.view.OrderEvaluateQueryView;

public interface IOrderEvaluateDaoImp {
	public void insert(OrderEvaluate OrderEvaluate);
	public void delete(OrderEvaluate OrderEvaluate);
	public void update(OrderEvaluate OrderEvaluate);

	public ArrayList<OrderEvaluateQueryView> list(OrderEvaluateConditionView OrderEvaluateConditionView) ;

}
