package com.ckwl.likemoney.order.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.front.view.MyOrderQueryView;
import com.ckwl.likemoney.front.view.OrderDetailFrontQueryView;
import com.ckwl.likemoney.order.dao.IOrderDaoImp;
import com.ckwl.likemoney.order.dao.IOrderDetailDaoImp;
import com.ckwl.likemoney.order.dao.imp.OrderDaoImp;
import com.ckwl.likemoney.order.dao.imp.OrderDetailDaoImp;
import com.ckwl.likemoney.order.entity.OrderDetail;
import com.ckwl.likemoney.order.service.IOrderDetailService;
import com.ckwl.likemoney.order.view.OrderDetailConditionView;
import com.ckwl.likemoney.order.view.OrderDetailQueryView;

public class OrderDetailServiceImp implements IOrderDetailService{
private IOrderDetailDaoImp OrderDetailDao = new OrderDetailDaoImp(); 

	/**代理*/
	@MyTransaction(readOnly=false)
	public void insert(OrderDetail OrderDetail) {		
		
		OrderDetailDao.insert(OrderDetail);
	}

	@MyTransaction(readOnly=false)
	public void delete(OrderDetail OrderDetail) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		OrderDetailDao.delete(OrderDetail);
	}

	@MyTransaction(readOnly=false)
	public void update(OrderDetail OrderDetail) {
		// TODO Auto-generated method stub
//		IOrderDaoImp OrderDao2=(IOrderDaoImp) DaoImpProxyFactory.getProxyInstance(OrderDao);
		OrderDetailDao.update(OrderDetail);
	}


	
	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<OrderDetailQueryView> list(OrderDetailConditionView OrderDetailConditionView) {
		// TODO Auto-generated method stub
		return OrderDetailDao.list(OrderDetailConditionView);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<OrderDetailFrontQueryView> list(String order_id) {
		// TODO Auto-generated method stub
		return OrderDetailDao.list(order_id);
	}
	
	@MyTransaction(readOnly=true)
	// 根据订单详情id查询OrderDetailFrontQueryView
	@Override
	public OrderDetailFrontQueryView listByDetailId(String orderDetailId){
		
		return OrderDetailDao.listByDetailId(orderDetailId);
	}
	
	@MyTransaction(readOnly=false)
	public ArrayList<OrderDetailFrontQueryView> listView(String order_id){
		 ArrayList<OrderDetailFrontQueryView> listOrderDetailFrontQueryView= new ArrayList<OrderDetailFrontQueryView>();
		 ArrayList<OrderDetailFrontQueryView> listOrderDetailFrontQueryView2 = this.list(order_id);
		 for (OrderDetailFrontQueryView OrderDetailFrontQueryView2 : listOrderDetailFrontQueryView2) {
			 OrderDetailFrontQueryView OrderDetailFrontQueryView=new OrderDetailFrontQueryView();

				OrderDetailFrontQueryView.setProduct_sku_code(OrderDetailFrontQueryView2.getProduct_sku_code());
				OrderDetailFrontQueryView
						.setProduct_sku_realPrice(OrderDetailFrontQueryView2.getProduct_sku_realPrice());
				OrderDetailFrontQueryView.setOrder_detail_amount(OrderDetailFrontQueryView2.getOrder_detail_amount());
				OrderDetailFrontQueryView.setOrder_detail_evaluate_time(OrderDetailFrontQueryView2.getOrder_detail_evaluate_time());
				OrderDetailFrontQueryView.setOrder_id(order_id);
				OrderDetailFrontQueryView.setOrder_code(OrderDetailFrontQueryView2.getOrder_code());
				OrderDetailFrontQueryView.setOrder_date(OrderDetailFrontQueryView2.getOrder_date());
				OrderDetailFrontQueryView.setOrder_sum_money(OrderDetailFrontQueryView2.getOrder_sum_money());
				OrderDetailFrontQueryView.setAddress_phone(OrderDetailFrontQueryView2.getAddress_phone());
				OrderDetailFrontQueryView.setAddress_name(OrderDetailFrontQueryView2.getAddress_name());
				OrderDetailFrontQueryView.setProduct_sku_img_small(OrderDetailFrontQueryView2.getProduct_sku_img_small());
				OrderDetailFrontQueryView.setProduct_sku_img_mid(OrderDetailFrontQueryView2.getProduct_sku_img_mid());
				OrderDetailFrontQueryView.setOrder_paydate(OrderDetailFrontQueryView2.getOrder_paydate());
				OrderDetailFrontQueryView.setAddress_consignee(OrderDetailFrontQueryView2.getAddress_consignee());
				
				
				
				OrderDetailFrontQueryView.setDataDictonary_detail_label_send(OrderDetailFrontQueryView2.getDataDictonary_detail_label_send());
				OrderDetailFrontQueryView.setDataDictonary_detail_label_logistics(OrderDetailFrontQueryView2.getDataDictonary_detail_label_logistics());
				OrderDetailFrontQueryView.setDataDictonary_detail_label_receive(OrderDetailFrontQueryView2.getDataDictonary_detail_label_receive());
				OrderDetailFrontQueryView.setDataDictonary_detail_label_evaluate(OrderDetailFrontQueryView2.getDataDictonary_detail_label_evaluate());
				OrderDetailFrontQueryView.setDataDictonary_detail_label_out(OrderDetailFrontQueryView2.getDataDictonary_detail_label_out());
				OrderDetailFrontQueryView
						.setDataDictonary_detail_label_order_status(OrderDetailFrontQueryView2.getDataDictonary_detail_label_order_status());
				OrderDetailFrontQueryView.setOrder_detail_outTime(OrderDetailFrontQueryView2.getOrder_detail_outTime());

				OrderDetailFrontQueryView.setOrder_detail_logistics_time(OrderDetailFrontQueryView2.getOrder_detail_logistics_time());
				OrderDetailFrontQueryView.setOrder_detail_receive_time(OrderDetailFrontQueryView2.getOrder_detail_receive_time());
			 IOrderDaoImp OrderDao = new OrderDaoImp(); 

			 ArrayList<MyOrderQueryView> listMyOrder= OrderDao.list(order_id) ;
			 OrderDetailFrontQueryView.setListMyOrder(listMyOrder);
			 
			 listOrderDetailFrontQueryView.add(OrderDetailFrontQueryView);
		}
		 
		 return listOrderDetailFrontQueryView ;
		
		
	}
}
