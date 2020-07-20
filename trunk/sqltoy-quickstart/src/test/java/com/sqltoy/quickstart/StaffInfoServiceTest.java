package com.sqltoy.quickstart;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sagacity.sqltoy.model.PaginationModel;
import org.sagacity.sqltoy.service.SqlToyCRUDService;
import org.sagacity.sqltoy.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alibaba.fastjson.JSON;
import com.sqltoy.quickstart.service.StaffInfoService;
import com.sqltoy.quickstart.vo.StaffInfoVO;

/**
 * 
 * @project sqltoy-quickstart
 * @description 通过员工信息表来演示常规的crud
 * @author zhongxuchen
 * @version v1.0, Date:2020年7月17日
 * @modify 2020年7月17日,修改说明
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SqlToyApplication.class)
public class StaffInfoServiceTest {

	@Autowired
	StaffInfoService staffInfoService;
	
	@Autowired
	SqlToyCRUDService sqlToyCRUDService;

	/**
	 * 
	 */
	@Test
	public void testSave() {
		StaffInfoVO staffInfo = new StaffInfoVO();
		staffInfo.setStaffId("S2007");
		staffInfo.setStaffCode("S2007");
		staffInfo.setStaffName("测试员工9");
		staffInfo.setSexType("M");
		staffInfo.setEmail("test3@aliyun.com");
		staffInfo.setEntryDate(LocalDate.now());
		staffInfo.setStatus(1);
		staffInfo.setOrganId("100007");
		staffInfo.setPhoto(FileUtil.readAsBytes("classpath:/mock/staff_photo.jpg"));
		staffInfo.setCountry("86");
		sqlToyCRUDService.save(staffInfo);
	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testDelete() {

	}
	
	@Test
	public void testSaveOrUpdate() {

	}

	@Test
	public void testQueryStaff() {
		PaginationModel pageModel = new PaginationModel();
		//正常需设置pageNo和pageSize,默认值分别为1和10 
		//pageModel.setPageNo(1);
		//pageModel.setPageSize(10);
		StaffInfoVO staffInfo = new StaffInfoVO();
		staffInfo.setBeginDate(LocalDate.parse("2019-01-01"));
		staffInfo.setEndDate(LocalDate.now());
		staffInfo.setStaffName("陈");
		PaginationModel<StaffInfoVO> result = staffInfoService.queryStaff(pageModel, staffInfo);
		for (StaffInfoVO row : result.getRows()) {
			System.err.println(JSON.toJSONString(row));
		}
	}
}