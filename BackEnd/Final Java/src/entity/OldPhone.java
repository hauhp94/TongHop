package entity;

public class OldPhone extends Phone {
	private int status;
	private int bodyStatus;
	private double priceWarranty;

	public OldPhone(String id, String name, double screenSize, String chipset, int ram, int storage, double price,
			String manufacturer, int status, int bodyStatus, double priceWarranty) {
		super(id, name, screenSize, chipset, ram, storage, price, manufacturer);
		this.status = status;
		this.bodyStatus = bodyStatus;
		this.priceWarranty = priceWarranty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBodyStatus() {
		return bodyStatus;
	}

	public void setBodyStatus(int bodyStatus) {
		this.bodyStatus = bodyStatus;
	}

	public double getPriceWarranty() {
		return priceWarranty;
	}

	public void setPriceWarranty(double priceWarranty) {
		this.priceWarranty = priceWarranty;
	}

	@Override
	public String toString() {
		return "OldPhone [status=" + status + ", bodyStatus=" + bodyStatus + ", priceWarranty=" + priceWarranty
				+ ", id=" + id + ", name=" + name + ", screenSize=" + screenSize + ", chipset=" + chipset + ", ram="
				+ ram + ", storage=" + storage + ", price=" + price + ", manufacturer=" + manufacturer + "]" + "Bao hanh 7 ngay";
	}

	@Override
	public void showInfo() {
		System.out.println(toString());
	}

}
