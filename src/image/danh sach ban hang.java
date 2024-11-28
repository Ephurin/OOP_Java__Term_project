/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Client
{
    private String id, name, sex, dob, addr;

    public Client(String id, String name, String sex, String dob, String addr) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dob = dob;
        this.addr = addr;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }
}

class Product
{
    private String id, name, dvi;
    private int price_in, price_out;

    public Product(String id, String name, String dvi, int price_in, int price_out) {
        this.id = id;
        this.name = name;
        this.dvi = dvi;
        this.price_in = price_in;
        this.price_out = price_out;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice_out()
    {
        return price_out;
    }

    public int getInterest()
    {
        return price_out - price_in;
    }
}

class Bill implements Comparable<Bill>
{
    private String id, c_id, p_id, c_addr, c_name, p_name;
    private int amount;
    private long interest, price_out;

    public Bill(String id, String c_id, String p_id, int amount) {
        this.id = id;
        this.c_id = c_id;
        this.p_id = p_id;
        this.amount = amount;
    }

    public String getC_id() {
        return c_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setC_addr(String c_addr) {
        this.c_addr = c_addr;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setInterest(long interest) {
        this.interest = interest;
    }

    public long getTotalInterest() {
        return interest * amount;
    }

    public void setPrice_out(long price_out) {
        this.price_out = price_out;
    }

    public long getTotalPrice() {
        return price_out * amount;
    }

    @Override
    public int compareTo(Bill o)
    {
        return Long.compare(o.getTotalInterest(), getTotalInterest());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %d %d", id, c_name, c_addr, p_name, amount, getTotalPrice(), getTotalInterest());
    }
}

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Bill> bills = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            String id = String.format("KH%03d", i + 1);
            String name = sc.nextLine();
            String sex = sc.nextLine();
            String dob = sc.nextLine();
            String addr = sc.nextLine();
            clients.add(new Client(id, name, sex, dob, addr));
        }
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++)
        {
            String id = String.format("MH%03d", i + 1);
            String name = sc.nextLine();
            String dvi = sc.nextLine();
            int price_in = Integer.parseInt(sc.nextLine());
            int price_out = Integer.parseInt(sc.nextLine());
            products.add(new Product(id, name, dvi, price_in, price_out));
        }
        int p = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < p; i++)
        {
            String id = String.format("HD%03d", i + 1);
            String[] in = sc.nextLine().trim().split("\\s+");
            String c_id = in[0];
            String p_id = in[1];
            int amount = Integer.parseInt(in[2]);
            bills.add(new Bill(id, c_id, p_id, amount));
        }
        for (Bill b : bills)
        {
            for (Client c : clients)
            {
                if (Objects.equals(b.getC_id(), c.getId()))
                {
                    b.setC_name(c.getName());
                    b.setC_addr(c.getAddr());
                }
            }
            for (Product product : products)
            {
                if (Objects.equals(b.getP_id(), product.getId()))
                {
                    b.setP_name(product.getName());
                    b.setInterest(product.getInterest());
                    b.setPrice_out(product.getPrice_out());
                }
            }
        }
        Collections.sort(bills);
        for (Bill b : bills)
        {
            System.out.println(b);
        }
    }
}*/