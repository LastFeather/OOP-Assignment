
public class DetailTransaksi {
	String noTransaksi, noBarang;
	int qty, total;
	
	public DetailTransaksi() {
		// TODO Auto-generated constructor stub
	}

	public DetailTransaksi(String noTransaksi, String noBarang, int qty, int total) {
		super();
		this.noTransaksi = noTransaksi;
		this.noBarang = noBarang;
		this.qty = qty;
		this.total = total;
	}

	public String getNoTransaksi() {
		return noTransaksi;
	}

	public void setNoTransaksi(String noTransaksi) {
		this.noTransaksi = noTransaksi;
	}

	public String getNoBarang() {
		return noBarang;
	}

	public void setNoBarang(String noBarang) {
		this.noBarang = noBarang;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
