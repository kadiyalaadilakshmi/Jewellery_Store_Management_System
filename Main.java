import java.util.Scanner;

/* ================= JewelleryItem ================= */
class JewelleryItem {
    private int id;
    private String name;
    private String type;
    private double weight;
    private double pricePerGram;

    public JewelleryItem(int id, String name, String type, double weight, double pricePerGram) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.pricePerGram = pricePerGram;
    }

    public double calculatePrice() {
        return weight * pricePerGram;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}

/* ================= GoldItem ================= */
class GoldItem extends JewelleryItem {
    public GoldItem(int id, String name, double weight) {
        super(id, name, "Gold", weight, 10000); // ✅ default gold price
    }
}

/* ================= SilverItem ================= */
class SilverItem extends JewelleryItem {
    public SilverItem(int id, String name, double weight) {
        super(id, name, "Silver", weight, 1000); // ✅ default silver price
    }
}

/* ================= Customer ================= */
class Customer {
    private int customerId;
    private String name;
    private String phoneNumber;

    public Customer(int customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
}

/* ================= Bill ================= */
class Bill {
    private Customer customer;
    private JewelleryItem item;
    private double total;

    public Bill(Customer customer, JewelleryItem item) {
        this.customer = customer;
        this.item = item;
    }

    public void generateBill() {
        double basePrice = item.calculatePrice();
        double gst = basePrice * 0.03;
        total = basePrice + gst;

        if (total > 100000) {
            total -= total * 0.10;
            System.out.println("🎉 Discount Applied: 10%");
        }

        System.out.println("\n----- BILL -----");
        System.out.println("Customer Name : " + customer.getName());
        System.out.println("Item Name     : " + item.getName());
        System.out.println("Item Type     : " + item.getType());
        System.out.println("Base Price    : ₹" + basePrice);
        System.out.println("GST (3%)      : ₹" + gst);
        System.out.println("Final Amount  : ₹" + total);
    }

    public double getTotalAmount() {
        return total;
    }
}

/* ================= CashManager ================= */
class CashManager {

    int n2000 = 10;
    int n500  = 20;
    int n200  = 30;
    int n100  = 10;
    int n50   = 10;
    int n20   = 200;
    int n10   = 200;

    public void deductAmount(double amount) {

        int remaining = (int) amount;

        int used2000 = Math.min(n2000, remaining / 2000);
        remaining -= used2000 * 2000;

        int used500 = Math.min(n500, remaining / 500);
        remaining -= used500 * 500;

        int used200 = Math.min(n200, remaining / 200);
        remaining -= used200 * 200;

        int used100 = Math.min(n100, remaining / 100);
        remaining -= used100 * 100;

        int used50 = Math.min(n50, remaining / 50);
        remaining -= used50 * 50;

        int used20 = Math.min(n20, remaining / 20);
        remaining -= used20 * 20;

        int used10 = Math.min(n10, remaining / 10);
        remaining -= used10 * 10;

        if (remaining > 0) {
            System.out.println("❌ Insufficient change available");
            return;
        }

        n2000 -= used2000;
        n500  -= used500;
        n200  -= used200;
        n100  -= used100;
        n50   -= used50;
        n20   -= used20;
        n10   -= used10;

        System.out.println("\n--- Remaining Notes ---");
        System.out.println("₹2000 : " + n2000);
        System.out.println("₹500  : " + n500);
        System.out.println("₹200  : " + n200);
        System.out.println("₹100  : " + n100);
        System.out.println("₹50   : " + n50);
        System.out.println("₹20   : " + n20);
        System.out.println("₹10   : " + n10);
    }
}

/* ================= MAIN ================= */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Jewellery Store Management System ===");

        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String cname = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(cid, cname, phone);

        System.out.println("\nSelect Jewellery Type");
        System.out.println("1. Gold (₹10000/g)");
        System.out.println("2. Silver (₹1000/g)");
        int choice = sc.nextInt();

        System.out.print("Enter Item ID: ");
        int itemId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item Name: ");
        String itemName = sc.nextLine();

        System.out.print("Enter Weight (grams): ");
        double weight = sc.nextDouble();

        JewelleryItem item;
        if (choice == 1) {
            item = new GoldItem(itemId, itemName, weight);
        } else {
            item = new SilverItem(itemId, itemName, weight);
        }

        Bill bill = new Bill(customer, item);
        bill.generateBill();

        double billAmount = bill.getTotalAmount();

        System.out.print("\nEnter amount paid by customer: ");
        double paidAmount = sc.nextDouble();

        if (paidAmount < billAmount) {
            System.out.println("❌ Insufficient amount paid");
        } else {
            System.out.println("✅ Payment successful");

            double change = paidAmount - billAmount;
            System.out.println("Change to return: ₹" + change);

            CashManager cash = new CashManager();
            cash.deductAmount(change);
        }

        sc.close();
    }
}
