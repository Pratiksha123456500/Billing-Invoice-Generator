import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public  class BillingInvoice{

   public static class  product{
              String name;
              double price;
              int quantity;
              double total;
              double discount;
    
   public product(String name, double price, int quantity ,double discount){ //constructor
        
              this.name=name;
              this.price=price;
              this.quantity=quantity;
              this.discount=(price*discount)/100;
              this.total=price*quantity;
            
            }
   
        }


// public static void saveProduct(product p){
    
// }


    public static void main(String args[]){


         Scanner sc=new Scanner(System.in);

        ArrayList<product> products = new ArrayList<>();

         
        char choice='y';
        while(choice == 'y' || choice == 'Y'){

           

        System.out.print("Enter item name: ");
        String name=sc.nextLine();
       

        System.out.print("Enter  price: ");
        double price=sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity=sc.nextInt();

        System.out.print("Enter discount: ");
        int discount=sc.nextInt();
        sc.nextLine();



       products.add(new product(name, price, quantity, discount));

       System.out.println("Are you want add the product(y/n)");

       choice=sc.next().charAt(0);
       sc.nextLine();

       System.out.println("-----------------------------------");
    
        }


        System.out.println("==========APNA GROCERY MART==========");

        System.out.println(" 123,Main Market, Sector 4, Orai\n Phone: +91765447xxxx | GSTIN: 09AAAA1111A1Z1");

        System.out.println("-------------------------------------");
      
        System.out.println("INVOICE NO: INV-2026-1042");


        LocalDate date=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String invoiceDate=date.format(formatter);

        System.out.println("DATE: "+invoiceDate);

        System.out.println("-------------------------------------");
  
        System.out.println("\n\n===========FINAL BILL===========");
        System.out.printf("%-15s %-5s %-8s %-8s\n", "Item name", "Qty", "Price","Dis");
        System.out.println("-------------------------------------------------------");

        double totalAmount=0;
        double dis=0;
        double taxRate=12.0;
        double totalTaxt=0;
        double grandTotal=0;


        for(product p: products){
            System.out.printf("%-15s %-5d %-8.2f %-8.2f\n", p.name, p.quantity, p.price, p.discount);
            totalAmount +=p.total;
            dis +=p.discount;   

            }
            double taxableAmount=totalAmount-dis;
            totalTaxt=taxableAmount*(taxRate/100);

            grandTotal=taxableAmount+totalTaxt;


           System.out.println("-----------------------------------------------");
           System.out.printf("TOTAL AMOUNT  : %.2f\n", totalAmount);
           
           System.out.printf("TOTAL DISCOUNT: %.2f\n", dis);

           System.out.printf("TAXABLE AMOUNT  : %.2f\n",taxableAmount);

           System.out.printf("TAX (12%% GST): %.2f\n",totalTaxt );

           System.out.printf("GRAND TOTAL: %.2f\n", grandTotal);

            //System.out.println("Your money saved!: "+dis);



            System.out.print("------Thank You For Shopping With Us------");


   Connection con = DBConnection.getConnection();

           if(con !=null){

              String sql = "INSERT INTO product(name, quantity,price, discount, total) VALUES (?,?,?,?,?)";


              try(PreparedStatement ps= con.prepareStatement(sql)){

                    for(product p: products){
                        ps.setString(1, p.name);
                          ps.setInt(2, p.quantity);
                            ps.setDouble(3, p.price);
                              ps.setDouble(4, p.discount);
                                ps.setDouble(5, p.total);

                                ps.executeUpdate();

                    }
                 
                 
                    
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
             sc.close(); 
        }
    
      }
    }
    
    
  
    
  
  






    
         
       
         

            

           
              
            

            

            



            

            

            


           
           

            
            




        
      
        
        

      

    
