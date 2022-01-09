package entity;

public class HomePhone extends Phone {
	private int warranty;
	private int range;

	public HomePhone(String id, String name, double screenSize,
			String chipset, int ram, int storage, double price,
			String manufacturer, int warranty, int range) {
		super(id, name, screenSize, chipset, ram, storage, price, manufacturer);
		this.warranty = warranty;
		this.range = range;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public String toString() {
		return "HomePhone [warranty=" + warranty + ", range=" + range + ", id=" + id + ", name=" + name
				+ ", screenSize=" + screenSize + ", chipset=" + chipset + ", ram=" + ram + ", storage=" + storage
				+ ", price=" + price + ", manufacturer=" + manufacturer + "]";
	}

	@Override
	public void showInfo() {
		System.out.println(toString());
	}

}
