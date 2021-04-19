package com.dlq.pojogroup;

import com.dlq.pojo.QioModel;
import com.dlq.pojo.QioModelOption;

import java.io.Serializable;
import java.util.List;


/**
 * 规格组合实体类
 * @author Qiqoo dai lian qi
 *     2019年4月9日
 *  @version v1.5
 */
public class QiModelGroup implements Serializable{
	
	private QioModel oModel;
	
	private List<QioModelOption> oModelOptionList;

	
	
	public QioModel getoModel() {
		return oModel;
	}

	public void setoModel(QioModel oModel) {
		this.oModel = oModel;
	}

	public List<QioModelOption> getoModelOptionList() {
		return oModelOptionList;
	}

	public void setoModelOptionList(List<QioModelOption> oModelOptionList) {
		this.oModelOptionList = oModelOptionList;
	}

}
