package com.ai.yc.order.service.atom.interfaces;

import java.util.List;

import com.ai.yc.order.dao.mapper.bo.OrdOdProdFile;

public interface IOrdOdProdFileAtomSV {
	public void insertSelective(OrdOdProdFile ordOdProdFile);
	
	List<OrdOdProdFile> findByProdDetalId(Long prodDetalId);
	
	void deleteByProdDetalId(Long prodDetalId);
}
