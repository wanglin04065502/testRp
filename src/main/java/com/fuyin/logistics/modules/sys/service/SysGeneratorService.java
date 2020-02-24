package com.fuyin.logistics.modules.sys.service;

import com.fuyin.logistics.common.entity.Page;
import com.fuyin.logistics.modules.sys.entity.GeneratorParamEntity;
import com.fuyin.logistics.modules.sys.entity.TableEntity;

import java.util.Map;

/**
 * 代码生成器
 */
public interface SysGeneratorService {

	/**
	 * 分页查询表格
	 * @param params
	 * @return
	 */
	Page<TableEntity> listTable(Map<String, Object> params);

	/**
	 * 生成代码
	 * @param params
	 * @return
	 */
	byte[] generator(GeneratorParamEntity params);
	
}
