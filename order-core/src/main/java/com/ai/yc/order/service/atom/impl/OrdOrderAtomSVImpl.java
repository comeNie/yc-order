package com.ai.yc.order.service.atom.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.yc.order.api.orderquery.param.RecordOrderRequest;
import com.ai.yc.order.constants.OrdersConstants;
import com.ai.yc.order.dao.mapper.bo.OrdOrder;
import com.ai.yc.order.dao.mapper.bo.OrdOrderCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.dao.mapper.interfaces.OrdOrderMapper;
import com.ai.yc.order.service.atom.interfaces.IOrdOrderAtomSV;

@Component
public class OrdOrderAtomSVImpl implements IOrdOrderAtomSV {

	@Override
	public OrdOrder findByPrimaryKey(OrdOrder ordOrder) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();

		return ordOrderMapper.selectByPrimaryKey(ordOrder.getOrderId());
	}

	@Override
	public int findOrderCount(OrdOrder ordOrder) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example = new OrdOrderCriteria();
		OrdOrderCriteria.Criteria param = example.createCriteria();
		if (!StringUtil.isBlank(ordOrder.getFlag())) {
			param.andFlagEqualTo(ordOrder.getFlag());
		}
		if (!StringUtil.isBlank(ordOrder.getUserType())) {
			param.andUserTypeEqualTo(ordOrder.getUserType());
		}
		if (!StringUtil.isBlank(ordOrder.getUserId())) {
			param.andUserIdEqualTo(ordOrder.getUserId());
		}
		if (!StringUtil.isBlank(ordOrder.getSubFlag())) {
			param.andSubFlagEqualTo(ordOrder.getSubFlag());
		}

		if (!StringUtil.isBlank(ordOrder.getChlId())) {
			param.andChlIdEqualTo(ordOrder.getChlId());
		}

		if (!StringUtil.isBlank(ordOrder.getOrderType())) {
			param.andOrderTypeEqualTo(ordOrder.getOrderType());
		}
		if (!StringUtil.isBlank(ordOrder.getOrderLevel())) {
			param.andOrderLevelEqualTo(ordOrder.getOrderLevel());
		}

		if (!StringUtil.isBlank(ordOrder.getTranslateType())) {
			param.andTranslateTypeEqualTo(ordOrder.getTranslateType());
		}
		if (!StringUtil.isBlank(ordOrder.getCorporaId())) {
			param.andCorporaIdEqualTo(ordOrder.getCorporaId());
		}

		if (!StringUtil.isBlank(ordOrder.getState())) {
			param.andStateEqualTo(ordOrder.getState());
		}

		if (!StringUtil.isBlank(ordOrder.getDisplayFlag())) {
			param.andDisplayFlagEqualTo(ordOrder.getDisplayFlag());
		}
		if (!StringUtil.isBlank(ordOrder.getInterperId())) {
			param.andInterperIdEqualTo(ordOrder.getInterperId());
		}
		if (!StringUtil.isBlank(ordOrder.getInterperType())) {
			param.andInterperTypeEqualTo(ordOrder.getInterperType());
		}

		if (ordOrder.getLspId() != null) {
			param.andLspIdEqualTo(ordOrder.getLspId());
		}
		return ordOrderMapper.countByExample(example);
	}
	
	
	@Override
	public void insertSelective(OrdOrder OrdOrder) {
		//
		MapperFactory.getOrdOrderMapper().insertSelective(OrdOrder);
		
	}

	@Override
	public OrdOrder findByPrimaryKey(Long orderId) {
		return MapperFactory.getOrdOrderMapper().selectByPrimaryKey(orderId);
	}

	@Override
	public int updateByPrimaryKeySelective(OrdOrder record) {
		return MapperFactory.getOrdOrderMapper().updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateById(OrdOrder ordOrder) {
		 return MapperFactory.getOrdOrderMapper().updateByPrimaryKeySelective(ordOrder);
	}

	@Override
	public List<OrdOrder> findOrdList(Integer limitStart, Integer limitEnd) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example = new OrdOrderCriteria();
		example.setLimitStart(limitStart);
        example.setLimitEnd(limitEnd);
		return ordOrderMapper.selectByExample(example);
	}

	@Override
	public List<OrdOrder> findNoPayOrdList(long orderId) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example=new OrdOrderCriteria();
    	OrdOrderCriteria.Criteria criteria = example.createCriteria();
    	criteria.andStateEqualTo(OrdersConstants.OrderState.STATE_WAIT_PAY);
    	criteria.andOrderIdEqualTo(orderId);
    	return ordOrderMapper.selectByExample(example);
	}

	@Override
	public List<OrdOrder> findNoReviewList(long orderId) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example=new OrdOrderCriteria();
    	OrdOrderCriteria.Criteria criteria = example.createCriteria();
    	criteria.andStateEqualTo(OrdersConstants.OrderState.WAIT_REVIEW_STATE);
    	criteria.andOrderIdEqualTo(orderId);
    	return ordOrderMapper.selectByExample(example);
	}

	@Override
	public List<OrdOrder> findByState(String state) {
		OrdOrderCriteria example=new OrdOrderCriteria();
    	OrdOrderCriteria.Criteria criteria = example.createCriteria();
    	criteria.andStateEqualTo(state);
		return MapperFactory.getOrdOrderMapper().selectByExample(example);
	}

	@Override
	public List<OrdOrder> findNoPriceOrdList(long orderId) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example=new OrdOrderCriteria();
    	OrdOrderCriteria.Criteria criteria = example.createCriteria();
    	criteria.andStateEqualTo(OrdersConstants.OrderState.STATE_WAIT_OFFER);
    	criteria.andOrderIdEqualTo(orderId);
    	return ordOrderMapper.selectByExample(example);
	}

	@Override
	public List<OrdOrder> findByStateAndStateChgTime(String state,Timestamp stateChgTime) {
		// TODO Auto-generated method stub
		OrdOrderCriteria example = new OrdOrderCriteria();
		//
		OrdOrderCriteria.Criteria criteria = example.createCriteria();
		//
		criteria.andStateEqualTo(state);
		criteria.andStateChgTimeLessThanOrEqualTo(stateChgTime);
		//
		return MapperFactory.getOrdOrderMapper().selectByExample(example);
	}
	@Override
	public List<OrdOrder> findByStateAndTranslateType(String state, String translateType) {
		// TODO Auto-generated method stub
		OrdOrderCriteria example = new OrdOrderCriteria();
		//
		OrdOrderCriteria.Criteria criteria = example.createCriteria();
		//
		criteria.andStateEqualTo(state);
		criteria.andTranslateTypeEqualTo(translateType);
		//
		return MapperFactory.getOrdOrderMapper().selectByExample(example);
	}

	@Override
	public List<OrdOrder> findByStateAndStateChgTimeAndBusiType(String state, String busiType, Timestamp stateChgTime) {
		// TODO Auto-generated method stub
				OrdOrderCriteria example = new OrdOrderCriteria();
				//
				OrdOrderCriteria.Criteria criteria = example.createCriteria();
				//
				criteria.andStateEqualTo(state);
				criteria.andBusiTypeEqualTo(busiType);
				criteria.andStateChgTimeLessThanOrEqualTo(stateChgTime);
				//
				return MapperFactory.getOrdOrderMapper().selectByExample(example);
	}

	@Override
	public OrdOrder findOrdByStateOrId(long orderId, String state) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example=new OrdOrderCriteria();
    	OrdOrderCriteria.Criteria criteria = example.createCriteria();
    	criteria.andOrderIdEqualTo(orderId);
    	if(!StringUtil.isBlank(state)){
    		criteria.andStateEqualTo(state);
    	}
    	List<OrdOrder> list = ordOrderMapper.selectByExample(example);
    	if(!CollectionUtil.isEmpty(list)){
    		return list.get(0);
    	}
    	return null;
	}

	@Override
	public List<OrdOrder> getRecordOrder(RecordOrderRequest req,String state) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example=new OrdOrderCriteria();
    	OrdOrderCriteria.Criteria criteria = example.createCriteria();
    	example.setLimitStart((req.getPageNo() - 1) * req.getPageSize());
		example.setLimitEnd(req.getPageSize());
    	if(null!=req.getOrderId()){
    		criteria.andOrderIdEqualTo(req.getOrderId());
    	}
    	if(!StringUtil.isBlank(req.getInterperId())){
    		criteria.andInterperIdEqualTo(req.getInterperId());
    	}
    	if(null!=req.getStateChgTimeStart() && null==req.getStateChgTimeEnd()){
    		criteria.andStateChgTimeGreaterThanOrEqualTo(req.getStateChgTimeStart());
    	}
    	if(null==req.getStateChgTimeStart() && null!=req.getStateChgTimeEnd()){
    		criteria.andStateChgTimeLessThanOrEqualTo(req.getStateChgTimeEnd());
    	}
    	if(null!=req.getStateChgTimeStart() && null!=req.getStateChgTimeEnd()){
    		criteria.andStateChgTimeBetween(req.getStateChgTimeStart(), req.getStateChgTimeEnd());
    	}
    	if(!StringUtil.isBlank(state)){
    		criteria.andStateEqualTo(state);
    	}
    	return ordOrderMapper.selectByExample(example);
	}

	@Override
	public int getRecordOrderCount(RecordOrderRequest req, String state) {
		OrdOrderMapper ordOrderMapper = MapperFactory.getOrdOrderMapper();
		OrdOrderCriteria example=new OrdOrderCriteria();
    	OrdOrderCriteria.Criteria criteria = example.createCriteria();
    	if(null!=req.getOrderId()){
    		criteria.andOrderIdEqualTo(req.getOrderId());
    	}
    	if(null!=req.getStateChgTimeStart() && null==req.getStateChgTimeEnd()){
    		criteria.andStateChgTimeGreaterThanOrEqualTo(req.getStateChgTimeStart());
    	}
    	if(null==req.getStateChgTimeStart() && null!=req.getStateChgTimeEnd()){
    		criteria.andStateChgTimeLessThanOrEqualTo(req.getStateChgTimeEnd());
    	}
    	if(null!=req.getStateChgTimeStart() && null!=req.getStateChgTimeEnd()){
    		criteria.andStateChgTimeBetween(req.getStateChgTimeStart(), req.getStateChgTimeEnd());
    	}
    	if(!StringUtil.isBlank(state)){
    		criteria.andStateEqualTo(state);
    	}
    	return ordOrderMapper.countByExample(example);
	}
}
