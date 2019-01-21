package com.ckwl.likemoney.product.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.ckwl.likemoney.cart.entity.Cart;
import com.ckwl.likemoney.frame.db.BaseDao;
import com.ckwl.likemoney.frame.db.DbUtil;
import com.ckwl.likemoney.frame.util.StringUtil;
import com.ckwl.likemoney.product.dao.IProductSkuDaoImp;
import com.ckwl.likemoney.product.entity.ProductSku;
import com.ckwl.likemoney.product.service.IProductSkuService;
import com.ckwl.likemoney.product.view.ProductSkuConditionView;
import com.ckwl.likemoney.product.view.ProductSkuQueryView;

public class ProductSkuDaoImp extends BaseDao implements IProductSkuDaoImp {
	public void insert(ProductSku ProductSku) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "insert into pro_product_sku(product_sku_id,product_id,color_id,size_id,product_sku_amount,product_sku_price,product_sku_img,product_sku_stock,product_shelf_status,product_sku_realPrice,product_sku_img_big,product_sku_img_small,product_sku_img_mid,product_stock_max,product_stock_min,evaluate_id,product_sku_code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + ProductSku.toString());
			preparedStatement = super.prepareStatement(sql);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			int parameterIndex = 1;

			preparedStatement.setObject(parameterIndex++, uuid);
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_id());
			preparedStatement.setObject(parameterIndex++, ProductSku.getColor_id());
			preparedStatement.setObject(parameterIndex++, ProductSku.getSize_id());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_amount());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_price());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_img());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_stock());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_shelf_status());

			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_realPrice());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_img_big());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_img_small());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_img_mid());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_stock_max());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_stock_min());
			preparedStatement.setObject(parameterIndex++, ProductSku.getEvaluate_id());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_code());
			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int count = preparedStatement.executeUpdate();

			System.out.println("影响行数" + count);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void delete(ProductSku ProductSku) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "delete from pro_product_sku_sku where product_sku_id=?";
			System.out.println("delete sql:" + sql);
			System.out.println("delete sql param:" + ProductSku.toString());
			preparedStatement = super.prepareStatement(sql);
			preparedStatement.setObject(1, ProductSku.getProduct_sku_id());
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public void update(ProductSku ProductSku) {
		PreparedStatement preparedStatement = null;

		try {
			String sql = "update  pro_product_sku set product_id=?,color_id=?,size_id=?,product_sku_amount=?,product_sku_price=?,product_sku_img=?,product_sku_stock=?,product_shelf_status=?,product_sku_realPrice=?,product_sku_img_big=?,product_sku_img_small=?,product_sku_img_mid=?,product_stock_max=?,product_stock_min=?,evaluate_id=?,product_sku_code=? where product_sku_id=?";
			System.out.println("update sql:" + sql);
			System.out.println("update sql param:" + ProductSku.toString());
			preparedStatement = super.prepareStatement(sql);
			int parameterIndex = 1;

			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_id());
			preparedStatement.setObject(parameterIndex++, ProductSku.getColor_id());
			preparedStatement.setObject(parameterIndex++, ProductSku.getSize_id());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_amount());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_price());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_img());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_stock());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_stock());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_shelf_status());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_realPrice());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_img_big());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_img_small());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_img_mid());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_stock_max());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_stock_min());
			preparedStatement.setObject(parameterIndex++, ProductSku.getEvaluate_id());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_code());
			preparedStatement.setObject(parameterIndex++, ProductSku.getProduct_sku_id());

			DbUtil.getSetpreparedStatement().add(preparedStatement);
			int row = preparedStatement.executeUpdate();

			System.out.println("影响行数：" + row);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	@Override
	public ArrayList<ProductSkuQueryView> list(ProductSkuConditionView ProductSkuConditionView) {
		// TODO Auto-generated method stub
		ArrayList<ProductSkuQueryView> listProductSkuQueryView = new ArrayList<ProductSkuQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			ArrayList<ProductSkuQueryView> listProduct = new ArrayList<ProductSkuQueryView>();
			StringBuilder sql = new StringBuilder();
			sql.append(" select pro_product_sku.* , pro_size.size_name ,pro_product.product_code , ");
			sql.append(" ord_evaluate.evaluate_amount,pro_color.color_name ,");
			sql.append(" bas_datadictonary_detail_shelf.dataDictonary_detail_label as product_shelf_status_label,");
			sql.append(" bas_datadictonary_detail_stock.dataDictonary_detail_label as product_sku_stock_label");
			sql.append(" from pro_product_sku ");

			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_shelf");
			sql.append(" on pro_product_sku.product_shelf_status = bas_datadictonary_detail_shelf.dataDictonary_detail_code");
			sql.append(" join bas_datadictonary_detail as bas_datadictonary_detail_stock");
			sql.append(" on pro_product_sku.product_sku_stock = bas_datadictonary_detail_stock.dataDictonary_detail_code");

			sql.append(" JOIN pro_size");
			sql.append(" on pro_product_sku.size_id = pro_size.size_id");
			sql.append(" JOIN pro_product");
			sql.append(" on pro_product_sku.product_id = pro_product.product_id");
			sql.append(" JOIN ord_evaluate");
			sql.append(" on pro_product_sku.evaluate_id = ord_evaluate.evaluate_id");
			sql.append(" JOIN pro_color");
			sql.append(" on pro_product_sku.color_id = pro_color.color_id");

			sql.append(" WHERE bas_datadictonary_detail_shelf.dataDictonary_code = 'product_shelf_status'");
			sql.append(" and bas_datadictonary_detail_stock.dataDictonary_code = 'product_sku_stock'");

			if (!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code())) {
				sql.append(" and pro_product.product_code like ?");
			}

			if (!StringUtil.isEmpty(ProductSkuConditionView.getEvaluate_amount())) {
				sql.append(" and ord_evaluate.evaluate_amount like ?");
			}

			// if(!StringUtil.isEmpty(ProductSkuConditionView.getProduct_sku_price())){
			// sql.append(" and pro_product_sku.product_sku_price like ?") ;
			// }
			//

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code()))
				preparedStatement.setObject(parameterIndex++, "%" + ProductSkuConditionView.getProduct_code() + "%");

			if (!StringUtil.isEmpty(ProductSkuConditionView.getEvaluate_amount()))
				preparedStatement.setObject(parameterIndex++, "%" + ProductSkuConditionView.getEvaluate_amount() + "%");
			//
			// if(!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code()))
			// preparedStatement.setObject(parameterIndex++ ,
			// "%"+ProductSkuConditionView.getProduct_code()+ "%");
			resultSet = preparedStatement.executeQuery();
			// DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {
				ProductSkuQueryView ProductSkuQueryView = new ProductSkuQueryView();
				String product_sku_id = resultSet.getString("product_sku_id");
				String product_id = resultSet.getString("product_id");
				String product_code = resultSet.getString("product_code");
				String product_sku_code = resultSet.getString("product_sku_code");
				String color_id = resultSet.getString("color_id");
				String color_name = resultSet.getString("color_name");
				String size_id = resultSet.getString("size_id");
				String size_name = resultSet.getString("size_name");
				String product_sku_amount = resultSet.getString("product_sku_amount");
				String product_sku_price = resultSet.getString("product_sku_price");
				
				String product_sku_stock = resultSet.getString("product_sku_stock");
				String product_shelf_status = resultSet.getString("product_shelf_status");
				
				// 状态字段
				String product_sku_stock_label = resultSet.getString("product_sku_stock_label");
				String product_shelf_status_label = resultSet.getString("product_shelf_status_label");
				
				String product_sku_realPrice = resultSet.getString("product_sku_realPrice");
				String product_sku_img_big = resultSet.getString("product_sku_img_big");
				String product_sku_img_small = resultSet.getString("product_sku_img_small");
				String product_sku_img_mid = resultSet.getString("product_sku_img_mid");
				String product_stock_max = resultSet.getString("product_stock_max");
				String product_stock_min = resultSet.getString("product_stock_min");

				String evaluate_id = resultSet.getString("evaluate_id");
				String evaluate_amount = resultSet.getString("evaluate_amount");

				ProductSkuQueryView.setProduct_sku_id(product_sku_id);
				ProductSkuQueryView.setProduct_id(product_id);
				ProductSkuQueryView.setProduct_code(product_code);
				ProductSkuQueryView.setColor_name(color_name);
				ProductSkuQueryView.setColor_id(color_id);
				ProductSkuQueryView.setSize_id(size_id);
				ProductSkuQueryView.setSize_name(size_name);
				ProductSkuQueryView.setProduct_sku_amount(product_sku_amount);
				ProductSkuQueryView.setProduct_shelf_status(product_shelf_status);
				
				ProductSkuQueryView.setProduct_sku_stock_label(product_sku_stock_label);
				ProductSkuQueryView.setProduct_shelf_status_label(product_shelf_status_label);
				
				ProductSkuQueryView.setProduct_sku_price(StringUtil.stringToBigdecimal(product_sku_price));
				ProductSkuQueryView.setProduct_sku_img(product_sku_img_mid);
				ProductSkuQueryView.setProduct_sku_stock(product_sku_stock);
				ProductSkuQueryView.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));

				ProductSkuQueryView.setProduct_sku_img_big(product_sku_img_big);

				ProductSkuQueryView.setProduct_sku_img_small(product_sku_img_small);

				ProductSkuQueryView.setProduct_sku_img_mid(product_sku_img_mid);
				ProductSkuQueryView.setProduct_stock_max(product_stock_max);
				ProductSkuQueryView.setProduct_stock_min(product_stock_min);
				ProductSkuQueryView.setEvaluate_id(evaluate_id);
				ProductSkuQueryView.setEvaluate_amount(evaluate_amount);
				ProductSkuQueryView.setProduct_sku_code(product_sku_code);

				//
				// System.out.println("identity:" + id + "code:" + code +
				// "address_id:" + address_id + "customer_id:"
				// + customer_id + "ProductSku_date:" + ProductSku_date +
				// "ProductSku_status:"
				// + ProductSku_status + "ProductSku_sum_money:" +
				// ProductSku_sum_money + "ProductSku_paydate:"
				// + ProductSku_paydate);

				listProductSkuQueryView.add(ProductSkuQueryView);
			}
			return listProductSkuQueryView;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	}

	@Override
	public ArrayList<ProductSkuQueryView> list(String product_sku_id) {
		ArrayList<ProductSkuQueryView> listProductSkuQueryView = new ArrayList<ProductSkuQueryView>();

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT pro_product_sku.* ,color_name,size_name,product_name,product_introduce FROM pro_product_sku");
			
			sql.append(" join pro_product");
			sql.append(" on pro_product_sku.product_id = pro_product.product_id");
			
			sql.append(" join pro_color");
			sql.append(" on pro_product_sku.color_id = pro_color.color_id");
			
			sql.append(" join pro_size");
			sql.append(" on pro_product_sku.size_id = pro_size.size_id");
			
			sql.append(" WHERE pro_product_sku.product_sku_id=?");
			
			preparedStatement = super.prepareStatement(sql.toString());
			
			int parameterIndex = 1;

			preparedStatement.setObject(parameterIndex++, product_sku_id);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductSkuQueryView productSkuQueryView = new ProductSkuQueryView();

				productSkuQueryView.setProduct_sku_id(resultSet.getString("product_sku_id"));
				
				productSkuQueryView.setProduct_sku_amount(resultSet.getString("product_sku_amount"));
				productSkuQueryView.setColor_name(resultSet.getString("color_name"));
				productSkuQueryView.setSize_name(resultSet.getString("size_name"));
				productSkuQueryView.setProduct_sku_img_small(resultSet.getString("product_sku_img_big"));
				
//				productSkuQueryView.setBigType(resultSet.getString("classfiy_big_name"));
				productSkuQueryView.setProduct_sku_img_big(resultSet.getString("product_sku_img_big"));
				productSkuQueryView.setProduct_introduce(resultSet.getString("product_introduce"));
				productSkuQueryView.setProduct_name(resultSet.getString("product_name"));
				
				productSkuQueryView.setProduct_sku_price(StringUtil.stringToBigdecimal(resultSet.getString("product_sku_price")));
				
				listProductSkuQueryView.add(productSkuQueryView);
				
				System.out.println(productSkuQueryView.toString());
			}
			return listProductSkuQueryView;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	}

	@Override
	public ArrayList<ProductSkuQueryView> list1(ProductSkuConditionView ProductSkuConditionView) {

		// TODO Auto-generated method stub
		ArrayList<ProductSkuQueryView> listProductSkuQueryView1 = new ArrayList<ProductSkuQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select pro_product_sku.* , pro_size.size_name ,pro_product.product_code , ");
			sql.append(" ord_evaluate.evaluate_amount,pro_color.color_name ,");
			sql.append(" bas_datadictonary_detail_shelf.dataDictonary_detail_label as product_shelf_status_label,");
			sql.append(" bas_datadictonary_detail_stock.dataDictonary_detail_label as product_sku_stock_label");
			sql.append(" from pro_product_sku ");

			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_shelf");
			sql.append(
					" on pro_product_sku.product_shelf_status = bas_datadictonary_detail_shelf.dataDictonary_detail_code");
			sql.append(" join bas_datadictonary_detail as bas_datadictonary_detail_stock");
			sql.append(
					" on pro_product_sku.product_sku_stock = bas_datadictonary_detail_stock.dataDictonary_detail_code");

			sql.append(" JOIN pro_size");
			sql.append(" on pro_product_sku.size_id = pro_size.size_id");
			sql.append(" JOIN pro_product");
			sql.append(" on pro_product_sku.product_id = pro_product.product_id");
			sql.append(" JOIN ord_evaluate");
			sql.append(" on pro_product_sku.evaluate_id = ord_evaluate.evaluate_id");
			sql.append(" JOIN pro_color");
			sql.append(" on pro_product_sku.color_id = pro_color.color_id");

			sql.append(" WHERE bas_datadictonary_detail_shelf.dataDictonary_code = 'product_shelf_status'");
			sql.append(" and bas_datadictonary_detail_stock.dataDictonary_code = 'product_sku_stock'");
			sql.append(" ORDER BY product_sku_id");
			sql.append(" LIMIT 0,5");
			
			System.out.println(sql.toString());
			if (!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code())) {
				sql.append(" and pro_product.product_code like ?");
			}

			if (!StringUtil.isEmpty(ProductSkuConditionView.getEvaluate_amount())) {
				sql.append(" and ord_evaluate.evaluate_amount like ?");
			}

			// if(!StringUtil.isEmpty(ProductSkuConditionView.getProduct_sku_price())){
			// sql.append(" and pro_product_sku.product_sku_price like ?") ;
			// }
			//

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code()))
				preparedStatement.setObject(parameterIndex++, "%" + ProductSkuConditionView.getProduct_code() + "%");

			if (!StringUtil.isEmpty(ProductSkuConditionView.getEvaluate_amount()))
				preparedStatement.setObject(parameterIndex++, "%" + ProductSkuConditionView.getEvaluate_amount() + "%");
			//
			// if(!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code()))
			// preparedStatement.setObject(parameterIndex++ ,
			// "%"+ProductSkuConditionView.getProduct_code()+ "%");
			resultSet = preparedStatement.executeQuery();
			// DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {
				ProductSkuQueryView ProductSkuQueryView1 = new ProductSkuQueryView();
				String product_sku_id = resultSet.getString("product_sku_id");
				String product_id = resultSet.getString("product_id");
				String product_code = resultSet.getString("product_code");
				String product_sku_code = resultSet.getString("product_sku_code");
				String color_id = resultSet.getString("color_id");
				String color_name = resultSet.getString("color_name");
				String size_id = resultSet.getString("size_id");
				String size_name = resultSet.getString("size_name");
				String product_sku_amount = resultSet.getString("product_sku_amount");
				String product_sku_price = resultSet.getString("product_sku_price");
				String product_sku_stock = resultSet.getString("product_sku_stock");
				String product_shelf_status = resultSet.getString("product_shelf_status");
				String product_sku_realPrice = resultSet.getString("product_sku_realPrice");
				String product_sku_img_big = resultSet.getString("product_sku_img_big");
				String product_sku_img_small = resultSet.getString("product_sku_img_small");
				String product_sku_img_mid = resultSet.getString("product_sku_img_mid");
				String product_stock_max = resultSet.getString("product_stock_max");
				String product_stock_min = resultSet.getString("product_stock_min");

				String evaluate_id = resultSet.getString("evaluate_id");
				String evaluate_amount = resultSet.getString("evaluate_amount");

				ProductSkuQueryView1.setProduct_sku_id(product_sku_id);
				ProductSkuQueryView1.setProduct_id(product_id);
				ProductSkuQueryView1.setProduct_code(product_code);
				ProductSkuQueryView1.setColor_name(color_name);
				ProductSkuQueryView1.setColor_id(color_id);
				ProductSkuQueryView1.setSize_id(size_id);
				ProductSkuQueryView1.setSize_name(size_name);
				ProductSkuQueryView1.setProduct_sku_amount(product_sku_amount);
				ProductSkuQueryView1.setProduct_shelf_status(product_shelf_status);
				ProductSkuQueryView1.setProduct_sku_price(StringUtil.stringToBigdecimal(product_sku_price));
				ProductSkuQueryView1.setProduct_sku_img(product_sku_img_mid);
				ProductSkuQueryView1.setProduct_sku_stock(product_sku_stock);
				ProductSkuQueryView1.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));

				ProductSkuQueryView1.setProduct_sku_img_big(product_sku_img_big);

				ProductSkuQueryView1.setProduct_sku_img_small(product_sku_img_small);

				ProductSkuQueryView1.setProduct_sku_img_mid(product_sku_img_mid);
				ProductSkuQueryView1.setProduct_stock_max(product_stock_max);
				ProductSkuQueryView1.setProduct_stock_min(product_stock_min);
				ProductSkuQueryView1.setEvaluate_id(evaluate_id);
				ProductSkuQueryView1.setEvaluate_amount(evaluate_amount);
				ProductSkuQueryView1.setProduct_sku_code(product_sku_code);


				listProductSkuQueryView1.add(ProductSkuQueryView1);
			}
			return listProductSkuQueryView1;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	
	}

	@Override
	public ArrayList<ProductSkuQueryView> listPro(ProductSkuConditionView ProductSkuConditionView, int pageIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		ArrayList<ProductSkuQueryView> listProductSkuQueryView1 = new ArrayList<ProductSkuQueryView>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select pro_product_sku.* , pro_size.size_name ,pro_product.product_code , ");
			sql.append(" ord_evaluate.evaluate_amount,pro_color.color_name ,");
			sql.append(" bas_datadictonary_detail_shelf.dataDictonary_detail_label as product_shelf_status_label,");
			sql.append(" bas_datadictonary_detail_stock.dataDictonary_detail_label as product_sku_stock_label");
			sql.append(" from pro_product_sku ");

			sql.append(" JOIN bas_datadictonary_detail as bas_datadictonary_detail_shelf");
			sql.append(
					" on pro_product_sku.product_shelf_status = bas_datadictonary_detail_shelf.dataDictonary_detail_code");
			sql.append(" join bas_datadictonary_detail as bas_datadictonary_detail_stock");
			sql.append(
					" on pro_product_sku.product_sku_stock = bas_datadictonary_detail_stock.dataDictonary_detail_code");

			sql.append(" JOIN pro_size");
			sql.append(" on pro_product_sku.size_id = pro_size.size_id");
			sql.append(" JOIN pro_product");
			sql.append(" on pro_product_sku.product_id = pro_product.product_id");
			sql.append(" JOIN ord_evaluate");
			sql.append(" on pro_product_sku.evaluate_id = ord_evaluate.evaluate_id");
			sql.append(" JOIN pro_color");
			sql.append(" on pro_product_sku.color_id = pro_color.color_id");

			sql.append(" WHERE bas_datadictonary_detail_shelf.dataDictonary_code = 'product_shelf_status'");
			sql.append(" and bas_datadictonary_detail_stock.dataDictonary_code = 'product_sku_stock'");
			sql.append(" ORDER BY product_sku_id");
//			sql.append(" LIMIT 0,5");
			
			System.out.println(sql.toString());
			if (!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code())) {
				sql.append(" and pro_product.product_code like ?");
			}

			if (!StringUtil.isEmpty(ProductSkuConditionView.getEvaluate_amount())) {
				sql.append(" and ord_evaluate.evaluate_amount like ?");
			}

			sql.append(" limit ").append(pageIndex * pageSize).append(",").append(pageSize);

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code()))
				preparedStatement.setObject(parameterIndex++, "%" + ProductSkuConditionView.getProduct_code() + "%");

			if (!StringUtil.isEmpty(ProductSkuConditionView.getEvaluate_amount()))
				preparedStatement.setObject(parameterIndex++, "%" + ProductSkuConditionView.getEvaluate_amount() + "%");
			
			
			resultSet = preparedStatement.executeQuery();
			// DbUtil.getSetresultSet().add(resultSet);
			while (resultSet.next()) {
				ProductSkuQueryView ProductSkuQueryView1 = new ProductSkuQueryView();
				String product_sku_id = resultSet.getString("product_sku_id");
				String product_id = resultSet.getString("product_id");
				String product_code = resultSet.getString("product_code");
				String product_sku_code = resultSet.getString("product_sku_code");
				String color_id = resultSet.getString("color_id");
				String color_name = resultSet.getString("color_name");
				String size_id = resultSet.getString("size_id");
				String size_name = resultSet.getString("size_name");
				String product_sku_amount = resultSet.getString("product_sku_amount");
				String product_sku_price = resultSet.getString("product_sku_price");
				String product_sku_stock = resultSet.getString("product_sku_stock");
				String product_shelf_status = resultSet.getString("product_shelf_status");
				String product_sku_realPrice = resultSet.getString("product_sku_realPrice");
				String product_sku_img_big = resultSet.getString("product_sku_img_big");
				String product_sku_img_small = resultSet.getString("product_sku_img_small");
				String product_sku_img_mid = resultSet.getString("product_sku_img_mid");
				String product_stock_max = resultSet.getString("product_stock_max");
				String product_stock_min = resultSet.getString("product_stock_min");

				String evaluate_id = resultSet.getString("evaluate_id");
				String evaluate_amount = resultSet.getString("evaluate_amount");

				ProductSkuQueryView1.setProduct_sku_id(product_sku_id);
				ProductSkuQueryView1.setProduct_id(product_id);
				ProductSkuQueryView1.setProduct_code(product_code);
				ProductSkuQueryView1.setColor_name(color_name);
				ProductSkuQueryView1.setColor_id(color_id);
				ProductSkuQueryView1.setSize_id(size_id);
				ProductSkuQueryView1.setSize_name(size_name);
				ProductSkuQueryView1.setProduct_sku_amount(product_sku_amount);
				ProductSkuQueryView1.setProduct_shelf_status(product_shelf_status);
				ProductSkuQueryView1.setProduct_sku_price(StringUtil.stringToBigdecimal(product_sku_price));
				ProductSkuQueryView1.setProduct_sku_img(product_sku_img_mid);
				ProductSkuQueryView1.setProduct_sku_stock(product_sku_stock);
				ProductSkuQueryView1.setProduct_sku_realPrice(StringUtil.stringToBigdecimal(product_sku_realPrice));

				ProductSkuQueryView1.setProduct_sku_img_big(product_sku_img_big);

				ProductSkuQueryView1.setProduct_sku_img_small(product_sku_img_small);

				ProductSkuQueryView1.setProduct_sku_img_mid(product_sku_img_mid);
				ProductSkuQueryView1.setProduct_stock_max(product_stock_max);
				ProductSkuQueryView1.setProduct_stock_min(product_stock_min);
				ProductSkuQueryView1.setEvaluate_id(evaluate_id);
				ProductSkuQueryView1.setEvaluate_amount(evaluate_amount);
				ProductSkuQueryView1.setProduct_sku_code(product_sku_code);


				listProductSkuQueryView1.add(ProductSkuQueryView1);
			}
			return listProductSkuQueryView1;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	
	}

	@Override
	public int recordCount(ProductSkuConditionView ProductSkuConditionView) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(*) from pro_product_sku where 1=1 ");
			
			System.out.println(sql.toString());
			if (!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code())) {
				sql.append(" and pro_product.product_code like ?");
			}

			if (!StringUtil.isEmpty(ProductSkuConditionView.getEvaluate_amount())) {
				sql.append(" and ord_evaluate.evaluate_amount like ?");
			}

			preparedStatement = super.prepareStatement(sql.toString());
			int parameterIndex = 1;

			if (!StringUtil.isEmpty(ProductSkuConditionView.getProduct_code()))
				preparedStatement.setObject(parameterIndex++, "%" + ProductSkuConditionView.getProduct_code() + "%");

			if (!StringUtil.isEmpty(ProductSkuConditionView.getEvaluate_amount()))
				preparedStatement.setObject(parameterIndex++, "%" + ProductSkuConditionView.getEvaluate_amount() + "%");

			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int recordCount = resultSet.getInt(1);
				return recordCount;
			}else {
				throw new RuntimeException("订单查询失败");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("订单查询失败", ex);
		}
	
	
	}

}
