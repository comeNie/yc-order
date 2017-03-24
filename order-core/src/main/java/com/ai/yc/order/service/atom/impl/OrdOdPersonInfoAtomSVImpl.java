package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.paas.ipaas.util.StringUtil;
import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfo;
import com.ai.yc.order.dao.mapper.bo.OrdOdPersonInfoCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdPersonInfoAtomSV;
@Component
public class OrdOdPersonInfoAtomSVImpl implements IOrdOdPersonInfoAtomSV {

	@Override
	public void insertSelective(OrdOdPersonInfo ordOdPersonInfo) {
		MapperFactory.getOrdOdPersonInfoMapper().insertSelective(ordOdPersonInfo);
	}


	@Override
	public List<OrdOdPersonInfo> findPersonInfo(OrdOdPersonInfo ordOdPersonInfo) {
		OrdOdPersonInfoCriteria  example = new OrdOdPersonInfoCriteria();
		OrdOdPersonInfoCriteria.Criteria criteria = example.createCriteria();
		if(!StringUtil.isBlank(ordOdPersonInfo.getInterperId())){
			criteria.andInterperIdEqualTo(ordOdPersonInfo.getInterperId());
		}
		if(ordOdPersonInfo.getReceiveFollowId()!=null){
			criteria.andReceiveFollowIdEqualTo(ordOdPersonInfo.getReceiveFollowId());
		}
		if(ordOdPersonInfo.getPersonId()!=null){
			criteria.andPersonIdEqualTo(ordOdPersonInfo.getPersonId());
		}
		List<OrdOdPersonInfo> personInfos = MapperFactory.getOrdOdPersonInfoMapper().selectByExample(example);
		return personInfos;
	}

}
