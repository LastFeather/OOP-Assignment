import java.util.ArrayList;

public class HeaderTransaksi {
	String noTransaksi, IDKasir, Tanggal;
	ArrayList<DetailTransaksi> arrDetail = new ArrayList<>();
	
	public HeaderTransaksi() {
		// TODO Auto-generated constructor stub
	}

	public HeaderTransaksi(String noTransaksi, String iDKasir, String tanggal) {
		super();
		this.noTransaksi = noTransaksi;
		IDKasir = iDKasir;
		Tanggal = tanggal;
	}
	
	public void inputBarang() {
		
	}

	public String getNoTransaksi() {
		return noTransaksi;
	}

	public void setNoTransaksi(String noTransaksi) {
		this.noTransaksi = noTransaksi;
	}

	public String getIDKasir() {
		return IDKasir;
	}

	public void setIDKasir(String iDKasir) {
		IDKasir = iDKasir;
	}

	public String getTanggal() {
		return Tanggal;
	}

	public void setTanggal(String tanggal) {
		Tanggal = tanggal;
	}

}
