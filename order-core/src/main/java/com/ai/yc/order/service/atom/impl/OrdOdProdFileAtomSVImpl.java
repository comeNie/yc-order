package com.ai.yc.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdFile;
import com.ai.yc.order.dao.mapper.bo.OrdOdProdFileCriteria;
import com.ai.yc.order.dao.mapper.factory.MapperFactory;
import com.ai.yc.order.service.atom.interfaces.IOrdOdProdFileAtomSV;
@Component
public class OrdOdProdFileAtomSVImpl implements IOrdOdProdFileAtomSV {

	@Override
	public void insertSelective(OrdOdProdFile ordOdProdFile) {
		MapperFactory.getOrdOdProdFileMapper().insertSelective(ordOdProdFile);
	}

	@Override
	public List<OrdOdProdFile> findByProdDetalId(Long prodDetalId) {
		OrdOdProdFileCriteria example = new OrdOdProdFileCriteria();
		OrdOdProdFileCriteria.Criteria criteria = example.createCriteria();
		criteria.andProdDetalIdEqualTo(prodDetalId);
		return MapperFactory.getOrdOdProdFileMapper().selectByExample(example);
	}

	@Override
	public void deleteByProdDetalId(Long prodDetalId) {
		OrdOdProdFileCriteria example = new OrdOdProdFileCriteria();
		OrdOdProdFileCriteria.Criteria criteria = example.createCriteria();
		criteria.andProdDetalIdEqualTo(prodDetalId);
		MapperFactory.getOrdOdProdFileMapper().deleteByExample(example);
	}

}
