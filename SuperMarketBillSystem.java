import java.util.Scanner;

public class SuperMarketBillSystem {   
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] products = { "Rice 1kg", "Wheat Flour 1kg", "Sugar 1kg", "Salt 1kg", "Tur Dal 1kg", "Moong Dal 1kg", "Chana Dal 1kg", "Oil 1L", "Ghee 500g", "Milk 1L", "Bread", "Butter 100g","Tea Powder 250g", "Coffee 200g", "Biscuits", "Noodles Pack", "Poha 1kg", "Rava 1kg", "Cornflakes 100 gm","Shampoo 180ml", "Soap 75 gm", "Toothpaste", "Toothbrush", "Detergent 1kg","Dishwash Liquid 155 ml", "Handwash 250ml", "Sanitizer 100ml", "Tissue Pack","Paneer 200g", "Curd 500g", "Chips Pack", "Cold Drink 1L", "Chocolate", "Ketchup 500g", "Pickle 200g", "Dry Fruits 250g", "Ice Cream Cup", "Batteries (2pc)", "Matchbox"};
        double[] prices = {115,61.50,44.50,27,101,179,111,185,39,56,50,55,137,123,10,40,70,78,53,90,75,61,45,64.97,20,110,50,69,81,24,10,70,20,105,37,120,25,66.8,8};

        int [] quantity = new int[products.length];

        System.out.println("Welcome to the Super Market!");
        System.out.println("\n Here is the list of products available:");
        System.out.println("=============== SUPERMARKET MENU ===============\n");
        for (int i=0; i<products.length; i++) 
        {
            System.out.println((i + 1) + ". " + products[i] + " - Rs. " + prices[i]);
        }
        System.out.print("\nHow many different items do you want to purchase? ");
        int n = sc.nextInt();

           for (int i = 0; i < n; i++) 
           {
              System.out.print("\nEnter product number (1-" + products.length + "): ");
              int p = sc.nextInt();
              int index = p - 1;
              System.out.print("Enter quantity of " + products[index] + ": ");
              quantity[index] += sc.nextInt();
            }

            // Generate Bill
            System.out.println("\n=============== BILL ===============");
            double total = 0;
            System.out.printf("%-25s %-10s %-10s %-10s\n", "Product", "Quantity", "Price", "Total");
            System.out.println("-------------------------------------");
            for (int i = 0; i < products.length; i++) 
            {
                if (quantity[i] > 0) 
                {
                    double itemTotal = prices[i] * quantity[i];
                    total += itemTotal;
                    System.out.printf("%-25s %-10d %-10.2f %-10.2f\n", products[i], quantity[i], prices[i], itemTotal);
                }
            }
            System.out.println("-------------------------------------");
            System.out.printf("Grand Total: Rs. %.2f\n", total);

             // Apply Discounts
            double discount = 0;
            if (total > 500) 
            {
              discount = total * 0.10;   // 10% discount
              System.out.println("Discount Applied: 10%");
            } 
               else if (total > 200) 
            {
               discount = total * 0.05;   // 5% discount
               System.out.println("Discount Applied: 5%");
            } 
           else 
           {
              System.out.println("Shop more than Rs.200 or Rs.500 to get exciting discounts!");
              discount = 0;
            }

           double finalAmount = total - discount;
           System.out.printf("Discount Amount: Rs. %.2f\n", discount);
           System.out.printf("Final Amount to Pay: Rs. %.2f\n", finalAmount);
           System.out.println ("Thank you for shopping with us!");
        sc.close();
    }
}