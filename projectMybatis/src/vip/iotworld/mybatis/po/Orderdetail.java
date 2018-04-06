package vip.iotworld.mybatis.po;

public class Orderdetail {
	
	private String id;
	
	private String ordersId;
	
	private String itemsId;
	
	private String itemsNum;
	
	private Items items;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
	}

	public String getItemsId() {
		return itemsId;
	}

	public void setItemsId(String itemsId) {
		this.itemsId = itemsId;
	}

	public String getitemsNum() {
		return itemsNum;
	}

	public void setitemsNum(String itemsNum) {
		this.itemsNum = itemsNum;
	}
	
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

}
