/**
 * @Title AllotOrderDetailEntity.java
 * @Package com.shein.fabric.allot.model
 * @Description 调拨单明细表
 * @author mochengqi
 * @date 2018-08-01 16:56:16
 * @version : V1.0
 */
package com.example.domain;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName AllotOrderDetailEntity
 * @Description 调拨单明细表Service
 * @author mochengqi
 * @date 2018-08-01 16:56:16
 */
public class AllotOrderDetailEntity {
	private Integer id;
	private Date addTime;
	private Date updateTime;
	private Integer mark;
	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 调拨单ID
	 */
	private Integer allotOrderId;

	/**
	 * 调拨单号
	 */
	private String allotOrderNo;

	/**
	 * 物料SKU
	 */
	private String materialSku;

	/**
	 * 物料名称
	 */
	private String materialName;

	/**
	 * 布的ID
	 */
	private Integer clothGuid;

	/**
	 * 入库ID
	 */
	private Integer inStorageId;

	/**
	 * 供应商
	 */
	private String supplier;

	/**
	 * 单位
	 */
	private String unit;

	/**
	 * 库存数量
	 */
	private BigDecimal inventoryNum;

	/**
	 * 库存状态
	 */
	private Integer inventoryStatus;

	/**
	 * 调出区域
	 */
	private String allotArea;

	/**
	 * 调出货位
	 */
	private String allotGoodsAllocation;

	/**
	 * 创建人
	 */
	private String addUser;

	/**
	 * 是否下架（0：否，1：是）
	 */
	private Integer isUnder;

	/**
	 * 容器号(车号)
	 */
	private String containerNo;

	/**
	 * 容器ID（车辆ID）
	 */
	private Integer turnoverCarId;

	/**
	 * 是否上架（0：否，1：是）
	 */
	private Integer isShelf;

	/**
	 * 分配人
	 */
	private String allocateUser;
	/**
	 * 是否删除
	 */
	private Integer isDelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getAllotOrderId() {
		return allotOrderId;
	}

	public void setAllotOrderId(Integer allotOrderId) {
		this.allotOrderId = allotOrderId;
	}

	public String getAllotOrderNo() {
		return allotOrderNo;
	}

	public void setAllotOrderNo(String allotOrderNo) {
		this.allotOrderNo = allotOrderNo;
	}

	public String getMaterialSku() {
		return materialSku;
	}

	public void setMaterialSku(String materialSku) {
		this.materialSku = materialSku;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public Integer getClothGuid() {
		return clothGuid;
	}

	public void setClothGuid(Integer clothGuid) {
		this.clothGuid = clothGuid;
	}

	public Integer getInStorageId() {
		return inStorageId;
	}

	public void setInStorageId(Integer inStorageId) {
		this.inStorageId = inStorageId;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getInventoryNum() {
		return inventoryNum;
	}

	public void setInventoryNum(BigDecimal inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	public Integer getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(Integer inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public String getAllotArea() {
		return allotArea;
	}

	public void setAllotArea(String allotArea) {
		this.allotArea = allotArea;
	}

	public String getAllotGoodsAllocation() {
		return allotGoodsAllocation;
	}

	public void setAllotGoodsAllocation(String allotGoodsAllocation) {
		this.allotGoodsAllocation = allotGoodsAllocation;
	}

	public String getAddUser() {
		return addUser;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	public Integer getIsUnder() {
		return isUnder;
	}

	public void setIsUnder(Integer isUnder) {
		this.isUnder = isUnder;
	}

	public String getContainerNo() {
		return containerNo;
	}

	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}

	public Integer getTurnoverCarId() {
		return turnoverCarId;
	}

	public void setTurnoverCarId(Integer turnoverCarId) {
		this.turnoverCarId = turnoverCarId;
	}

	public Integer getIsShelf() {
		return isShelf;
	}

	public void setIsShelf(Integer isShelf) {
		this.isShelf = isShelf;
	}

	public String getAllocateUser() {
		return allocateUser;
	}

	public void setAllocateUser(String allocateUser) {
		this.allocateUser = allocateUser;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}