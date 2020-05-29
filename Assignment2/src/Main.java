//nama	: mikhaya josheba rumondang hutagalung
//nim	: 2201742343
//kelas	: LJ01

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<HeaderTransaksi> arrHeader = new ArrayList<>();
	ArrayList<Barang> arrBarang = new ArrayList<>();
	ArrayList<Kasir> arrKasir = new ArrayList<>();
	Random rand = new Random();
	
	public Main() {
		/* Pre-compute data */
		preComputeKasir();
		preComputeBarang();
		
		/* Masukkan ID kasir */
		viewListKasir(); System.out.println();
		
		String IDKasir = null, namaKasir = null;
		int idxKasir = 0;
		
		do {
			System.out.print("Masukkan ID kasir: ");
			IDKasir = scan.nextLine();
			idxKasir = checkIDKasir(IDKasir); 
		} while (idxKasir < 0);
		
		namaKasir = arrKasir.get(idxKasir).getNamaKasir();
		
		/* Masuk ke menu */
		int menu = 0;
		do {
			System.out.println();
			System.out.println("Kasir: " + namaKasir + ", ID: " + IDKasir);
			System.out.println("Menu:");
			System.out.println("1. List Barang");
			System.out.println("2. Transaksi Barang");
			System.out.println("3. Lihat Transaksi");
			System.out.println("4. Tambah Barang");
			System.out.println("5. Kasir");
			System.out.println("6. Keluar");
			
			do {
				System.out.print(">> ");
				try {
					menu = scan.nextInt();
				} catch (Exception e) {
					menu = -1;
					
				}
				scan.nextLine();
			} while (menu < 1 || menu > 6);
			
			switch (menu) {
			case 1 :
				viewListBarang();
				scan.nextLine();
				break;
			case 2 :
				transaksiBarang(IDKasir);
				break;
			case 3 :
				if(arrHeader.size() == 0) System.out.println("Belum ada transaksi!");
				else lihatTransaksi();
				break;
			case 4 :
				tambahBarang();
				break;
			case 5 :
				idxKasir = aboutKasir(idxKasir);
				IDKasir = arrKasir.get(idxKasir).getIDKasir();
				namaKasir = arrKasir.get(idxKasir).getNamaKasir();
				break;
			}
		} while (menu != 6);
	}

	private int aboutKasir(int idxKasir) {
		int menu = 0;
		
		System.out.println();
		System.out.println("Kasir:");
		System.out.println("1. Tambah kasir");
		System.out.println("2. Ganti kasir");
		System.out.println("3. Kembali");
		
		do {
			System.out.print(">> ");
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				menu = -1;
			}
			scan.nextLine();
		} while (menu < 1 || menu > 3);
		
		switch(menu){
		case 1 :
			tambahKasir();
			break;
		case 2 :
			idxKasir = gantiKasir(idxKasir);
			break;
		}
		return idxKasir;
	}

	private int gantiKasir(int idxKasir) {
		String IDKasir = null;
		
		System.out.println();
		viewListKasir();
		System.out.println();
		
		do {
			System.out.print("Masukkan ID kasir: ");
			IDKasir = scan.nextLine();
			idxKasir = checkIDKasir(IDKasir); 
		} while (idxKasir < 0);
		
		return idxKasir;
	}

	private void tambahKasir() {
		System.out.println();
		
		String namaKasir = null, IDKasir = "";
		
		System.out.print("Masukkan nama kasir: ");
		namaKasir = scan.nextLine();
		
		IDKasir += "K-";
		IDKasir += Integer.toString(rand.nextInt(10));
		IDKasir += Integer.toString(rand.nextInt(10));
		
		arrKasir.add(new Kasir(IDKasir, namaKasir));
		
		scan.nextLine();
	}

	private void tambahBarang() {
		System.out.println();
		String noBarang = null, namaBarang;
		int harga;
		
		noBarang = getNoBarang();
		
		System.out.print("Masukkan nama barang: ");
		namaBarang = scan.nextLine();
		
		do {
			System.out.println("Masukkan harga barang: ");
			try {
				harga = scan.nextInt();
			} catch (Exception e) {
				harga = -1;
			}
		} while (harga < 1);
		
		arrBarang.add(new Barang(noBarang, namaBarang, harga));
		
		System.out.println("Barang berhasil dimasukkan!");
		scan.nextLine();
	}

	private void lihatTransaksi() {
		int menu = 0;
		
		System.out.println();
		System.out.println("Transaksi:");
		System.out.println("1. Header Transaksi");
		System.out.println("2. Detail Transaksi");
		
		do {
			System.out.print(">> ");
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
				menu = -1;
			}
			scan.nextLine();
		} while (menu < 1 || menu > 2);
			
		switch(menu){
		case 1 :
			viewHeaderTransaksi();
			break;
		case 2 :
			viewDetail();
			break;
		}
	}

	private void viewDetail() {
		int sizeHeader = arrHeader.size();
		
		System.out.println();
		System.out.println("+---------------+--------------+-----+-----------+");
		System.out.println("| No. Transaksi | No. Barang   | Qty | Total     |");
		System.out.println("+---------------+--------------+-----+-----------+");
		for(int i = 0 ; i < sizeHeader ; i++)
			viewDetailTransaksi(i);
		System.out.println("+---------------+--------------+-----+-----------+");
		scan.nextLine();
	}

	private void viewHeaderTransaksi() {
		int size = arrHeader.size();
		
		System.out.println();
		System.out.println("+---------------+----------+-------------------+");
		System.out.println("| No. Transaksi | ID Kasir | Tanggal           |");
		System.out.println("+---------------+----------+-------------------+");
		for(int i = 0 ; i < size ; i++)
			System.out.printf("| %-13s | %-8s | %-17s |\n",
					arrHeader.get(i).getNoTransaksi(),
					arrHeader.get(i).getIDKasir(),
					arrHeader.get(i).getTanggal());
		System.out.println("+---------------+----------+-------------------+");
		scan.nextLine();
	}

	private int checkIDKasir(String iDKasir) {
		int size = arrKasir.size();
		
		for(int i = 0 ; i < size ; i++)
			if(iDKasir.contentEquals(arrKasir.get(i).getIDKasir()))
				return i;
		
		return -1;
	}

	private void viewListKasir() {
		int size = arrKasir.size();
		
		System.out.println("+----------+---------------+");
		System.out.println("| ID Kasir | Nama Kasir    |");
		System.out.println("+----------+---------------+");
		for(int i = 0 ; i < size ; i++){
			System.out.printf("| %-8s | %-13s |\n",
				arrKasir.get(i).getIDKasir(),
				arrKasir.get(i).getNamaKasir());
		}
		System.out.println("+--	--------+---------------+");
	}

	private void preComputeKasir() {
		String IDKasir = "";
		
		/* Kasir 1 */
		IDKasir += "K-";
		IDKasir += Integer.toString(rand.nextInt(10));
		IDKasir += Integer.toString(rand.nextInt(10));
		arrKasir.add(new Kasir(IDKasir, "Tegar"));
		
		/* Kasir 2 */
		IDKasir = "";
		IDKasir += "K-";
		IDKasir += Integer.toString(rand.nextInt(10));
		IDKasir += Integer.toString(rand.nextInt(10));
		arrKasir.add(new Kasir(IDKasir, "Hendry"));
	}
	

	private void transaksiBarang(String iDKasir) {
		String tanggal = null, noTransaksi = null;
		int menu = 0;
		
		System.out.println();
		System.out.print("Masukkan tanggal [co: 7 Juli 2017]: ");
		tanggal = scan.nextLine();
		
		int jmlh = arrHeader.size() + 1;
		if(jmlh < 10) noTransaksi = Integer.toString(0) + Integer.toString(0)
			+ Integer.toString(jmlh) + "/2019";
		else if(jmlh < 100) noTransaksi = Integer.toString(0) +
			Integer.toString(jmlh) + "/2019";
		else noTransaksi = Integer.toString(jmlh) + "/2019";
		
		arrHeader.add(new HeaderTransaksi(noTransaksi, iDKasir, tanggal));
		
		do {
			System.out.println();
			System.out.println("Transaksi Barang:");
			System.out.println("1. Input Barang");
			System.out.println("2. Bayar");
			
			do {
				System.out.print(">> ");
				try {
					menu = scan.nextInt();
				} catch (Exception e) {
					menu = -1;
				} 
				scan.nextLine();
			} while (menu < 1 || menu > 2);
			
			switch(menu){
			case 1 :
				inputBarang(noTransaksi);
				break;
			case 2 :
				if(arrHeader.get(jmlh-1).arrDetail.size() == 0){
					System.out.println("Belum ada barang yang dibeli!");
					menu = -1;
				}
				else bayar(jmlh-1);
				break;
			}
		} while (menu != 2);
	}
	

	private void bayar(int idxBayar) {
		System.out.println();
		/* view list transaksi itu */
		System.out.println("+---------------+--------------+-----+-----------+");
		System.out.println("| No. Transaksi | No. Barang   | Qty | Total     |");
		System.out.println("+---------------+--------------+-----+-----------+");
		viewDetailTransaksi(idxBayar);
		System.out.println("+---------------+--------------+-----+-----------+");
		System.out.println();
		
		int grandTotal = getGrandTotal(idxBayar);
		System.out.println("Grand Total: Rp" + grandTotal);
		
		int uangBayar = 0;
		do {
			System.out.print("Uang Bayar: ");
			try {
				uangBayar = scan.nextInt();
			} catch (Exception e) {
				uangBayar = -1;
			}
			scan.nextLine();
		} while (uangBayar < grandTotal);
		
		int kembalian = uangBayar - grandTotal;
		if(kembalian == 0) System.out.println("Tidak ada kembalian!");
		else System.out.println("Uang Kembali: Rp" + kembalian);
		scan.nextLine();
	}
	

	private int getGrandTotal(int idxBayar) {
		int jmlhDetail = arrHeader.get(idxBayar).arrDetail.size();
		int grandTotal = 0;
		
		for(int i = 0 ; i < jmlhDetail ; i++)
			grandTotal += arrHeader.get(idxBayar).arrDetail.get(i).total;
		
		return grandTotal;
	}

	
	private void viewDetailTransaksi(int idxBayar) {
		int jmlhDetail = arrHeader.get(idxBayar).arrDetail.size();
		
		for(int i = 0 ; i < jmlhDetail ; i++){
			System.out.printf("| %-13s | %-12s | %3d | Rp%7d |\n", 
				arrHeader.get(idxBayar).arrDetail.get(i).noTransaksi,
				arrHeader.get(idxBayar).arrDetail.get(i).noBarang,
				arrHeader.get(idxBayar).arrDetail.get(i).qty,
				arrHeader.get(idxBayar).arrDetail.get(i).total);
		}
	}

	
	private void inputBarang(String noTransaksi) {
		int qty = 0, idx = 0;
		String noBarang = null;
		
		viewListBarang();
		System.out.println();
		
		do {
			System.out.print("Masukkan no barang: ");
			noBarang = scan.nextLine();
			idx = checkBarang(noBarang);
		} while (idx < 0);
		
		do {
			System.out.print("Input jumlah barang: ");
			try {
				qty = scan.nextInt();
			} catch (Exception e) {
				qty = -1;
			}
		} while (qty < 1);
		
		arrHeader.get(arrHeader.size() - 1).arrDetail.add(
				new DetailTransaksi(noTransaksi, noBarang, qty,
				qty*arrBarang.get(idx).getHargaBarang()));
		
		System.out.println("Detail transaksi berhasil dimasukkan!");
		scan.nextLine();
	}
	

	private int checkBarang(String noBarang) {
		int size = arrBarang.size();
		
		for(int i = 0 ; i < size ; i++){
			if(noBarang.contentEquals(arrBarang.get(i).getNoBarang()))
				return i;
		}
		
		return -1;
	}

	
	private void viewListBarang() {
		int size = arrBarang.size();
		
		System.out.println();
		System.out.println("+--------------+-----------------+-----------+");
		System.out.println("| No. Barang   | Nama Barang     | Harga     |");
		System.out.println("+--------------+-----------------+-----------+");
		for(int i = 0 ; i < size ; i++){
			System.out.printf("| %-12s | %-15s | Rp%7d |\n",
					arrBarang.get(i).getNoBarang(),
					arrBarang.get(i).getNamaBarang(),
					arrBarang.get(i).getHargaBarang());
		}
		System.out.println("+--------------+-----------------+-----------+");
	}

	
	private void preComputeBarang() {
		String noBarang = null;
		
		/* Barang 1 */
		noBarang = getNoBarang();
		arrBarang.add(new Barang(noBarang, "Teh Pucuk", 4000));
		
		/* Barang 2 */
		noBarang = getNoBarang();
		arrBarang.add(new Barang(noBarang, "Sabun Rinso", 10000));
		
		/* Barang 3 */
		noBarang = getNoBarang();
		arrBarang.add(new Barang(noBarang, "Baygon", 5000));
		
		/* Barang 4 */
		noBarang = getNoBarang();
		arrBarang.add(new Barang(noBarang, "Indomie", 2500));
	}

	
	private String getNoBarang() {
		String noBarang = "";
		
		noBarang += Integer.toString(rand.nextInt(10));
		noBarang += Integer.toString(rand.nextInt(10));
		noBarang += Integer.toString(rand.nextInt(10));
		noBarang += "/BRG/2019";
		
		return noBarang;
	}

	
	public static void main(String[] args) {
		new Main();
	}
}