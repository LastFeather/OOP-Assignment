
public class Barang {
	String noBarang, namaBarang;
	int hargaBarang;
	
	public Barang() {
		// TODO Auto-generated constructor stub
	}

	public Barang(String noBarang, String namaBarang, int hargaBarang) {
		super();
		this.noBarang = noBarang;
		this.namaBarang = namaBarang;
		this.hargaBarang = hargaBarang;
	}

	public String getNoBarang() {
		return noBarang;
	}

	public void setNoBarang(String noBarang) {
		this.noBarang = noBarang;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public int getHargaBarang() {
		return hargaBarang;
	}

	public void setHargaBarang(int hargaBarang) {
		this.hargaBarang = hargaBarang;
	}

}
