package com.ckwl.likemoney.user.service.imp;

import java.util.ArrayList;

import com.ckwl.likemoney.frame.annotation.MyTransaction;
import com.ckwl.likemoney.user.dao.IUserAttentionDao;
import com.ckwl.likemoney.user.dao.imp.UserAttentionDaoImp;
import com.ckwl.likemoney.user.entity.UserAttention;
import com.ckwl.likemoney.user.service.IUserAttentionService;
import com.ckwl.likemoney.user.view.UserAttentionConditionView;
import com.ckwl.likemoney.user.view.UserAttentionQueryView;

public class UserAttentionServiceImp implements IUserAttentionService {
private IUserAttentionDao userAttentionDao=new UserAttentionDaoImp();

	@MyTransaction(readOnly=false)
	@Override
	public void insert(UserAttention userAttention) {
		// TODO Auto-generated method stub
		userAttentionDao.insert(userAttention);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void delete(String attentionId) {
		// TODO Auto-generated method stub
		userAttentionDao.delete(attentionId);
	}

	@MyTransaction(readOnly=false)
	@Override
	public void update(UserAttention userAttention) {
		// TODO Auto-generated method stub
		userAttentionDao.update(userAttention);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<UserAttention> list() {
		// TODO Auto-generated method stub
		return userAttentionDao.list();
	}

	@MyTransaction(readOnly=true)
	@Override
	public UserAttention load(String attentionId) {
		// TODO Auto-generated method stub
		return userAttentionDao.load(attentionId);
	}

	@MyTransaction(readOnly=true)
	@Override
	public ArrayList<UserAttentionQueryView> list(UserAttentionConditionView conditionView) {
		// TODO Auto-generated method stub
		return userAttentionDao.list(conditionView);
	}

	

}
