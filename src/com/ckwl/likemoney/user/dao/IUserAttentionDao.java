package com.ckwl.likemoney.user.dao;

import java.util.ArrayList;

import com.ckwl.likemoney.user.entity.UserAttention;
import com.ckwl.likemoney.user.view.ReceivingAddressQueryView;
import com.ckwl.likemoney.user.view.UserAttentionConditionView;
import com.ckwl.likemoney.user.view.UserAttentionQueryView;




public interface IUserAttentionDao {
	public void insert(UserAttention userAttention);
	public void delete(String attentionId);
	public void update(UserAttention userAttention);
	public ArrayList<UserAttention > list();
	public UserAttention load(String attentionId);
	public ArrayList<UserAttentionQueryView > list(UserAttentionConditionView conditionView);
}
