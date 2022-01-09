package entity;

public class ForeignPhone extends Phone {
	private String country;
	private double priceWarranty;

	public ForeignPhone(String id, String name, double screenSize, String chipset, int ram, int storage, double price,
			String manufacturer, String country, double priceWarranty) {
		super(id, name, screenSize, chipset, ram, storage, price, manufacturer);
		this.country = country;
		this.priceWarranty = priceWarranty;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getPriceWarranty() {
		return priceWarranty;
	}

	public void setPriceWarranty(double priceWarranty) {
		this.priceWarranty = priceWarranty;
	}

	@Override
	public String toString() {
		return "ForeignPhone [country=" + country + ", priceWarranty=" + priceWarranty + ", id=" + id + ", name=" + name
				+ ", screenSize=" + screenSize + ", chipset=" + chipset + ", ram=" + ram + ", storage=" + storage
				+ ", price=" + price + ", manufacturer=" + manufacturer + "]" +"Bao Hanh 7 ngay";
	}

	@Override
	public void showInfo() {
		System.out.println(toString());
	}

}
