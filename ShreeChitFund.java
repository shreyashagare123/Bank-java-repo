  import java.util.*;
 class ShreeChitFund
 {
     static Scanner sc = new Scanner(System.in);
     static String user;
     static long phone;
     static String add;
     static double bal;
     static int pin;
     static String type;
     static ArrayList<String>tran = new ArrayList<>();
     
     public static void main (String [] args)
     {
         for(; ;)
         {
             System.out.println();
             System.out.println(" *** WELCOME ***");
             System.out.println(" SHREE Bank OF  INDIA ");
             System.out.println();
             System.out.println("1 . New Account");
             System.out.println("2 . Log in ");
             System.out.println(" Enter option");
             int option = sc.nextInt();
             switch(option)
             {
                 case 1 : newAccount(); 
                       break;
                 case 2 :loginUser();
                         break;
                 default : System.out.println("Wrong option Entered");
                 
             }
             
         }
     }
     public static void newAccount()
     {
         if (user!=null)
         {
             System.out.println(" Account is already created");
             return;
         }
         System.out.println(" Account Creation");
         System.out.println(" USername :");
         sc.nextLine();
         user = sc.nextLine();
         System.out.println(" Enter phone Number :");
         phone = sc.nextLong();
         System.out.println(" Enter Address");
         sc.nextLine();
         add = sc.nextLine();
         System.out.println(" Amount to be deposited");
         bal = sc.nextDouble();
         System.out.println("enter your pin:");
         pin = sc.nextInt();
         System.out.println(" Account type ");
         type = sc.nextLine();
         
         tran.add("Credited :"+ bal);
         System.out.println();
         System.out.println("Account to be created");
         
     }
     public static void loginUser()
     {
         if(user != null)
         {
             System.out.println();
             System.out.println("Login");
             System.out.print("Enter UserName:");
             sc.nextLine();
             String user1 = sc.nextLine();
             System.out.println("Enter your pin");
             int pin1 = sc.nextInt();
             if(user1.equals(user) && pin1 == pin)
             {
                 features();
             }
             else 
             {
                 System.out.println();
                 System.out.println(" Wrong Details Entered");
                 System.out.println();
             }
         }
         else{
             System.out.println("Create your Account ");
         }
     }
     public static void features()
     {
         for(; ; )
         {
         System.out.println();
         System.out.println(" Features :");
         System.out.println(" 1 . Deposit Amount");
         System.out.println(" 2. Debit Amount ");
         System.out.println(" 3 . Check Balance ");
         System.out.println(" 4 . Transfer Amount ");
         System.out.println(" 5 . Statement"); 
         System.out.println(" 6 . Edit Account "); 
          System.out.println(" 7 . Loan and More ");
          System.out.println(" 8 . Logout");
          System.out.println();
          int option = sc.nextInt();
          switch (option)
          {
              case 1 : depositAmount(); break;
              case 2 : debitAmount(); break;
              case 3 : checkBalance(); break;
           //   case 4 : transferAmount(); break;
              case 5 : statement(); break;
          //    case 6 : editAccount();break;
                case 7 : loan();break;
              case 8 :System.exit(0);
         default : System.out.println(" Wrong pin entered");
          }
          System.out.println();
          
         }
         
     }
     
     public static void statement()
     {
         System.out.println();
         System.out.println("Statement");
         System.out.println();
         for(String i : tran)
         {
              System.out.println(i);
         }
          System.out.println();
     }
     
     public static void checkBalance()
     {
         System.out.println(" Check Balance");
          System.out.println();
           System.out.println(" Enter your pin");
          int pin1 = sc.nextInt();
          if(pin == pin1)
          {
               System.out.println();
      System.out.println("Your Account Balance is :" + bal+ "rs");
          }
          else
          {
               System.out.println();
                System.out.println(" Wrong pin entered");
          }
     } 
     
     public static void depositAmount()
     {
          System.out.println();
           System.out.println(" deposit Amount");
            System.out.println();
             System.out.println(" Enter Amount ");
             double deposit = sc.nextDouble();
             bal+=deposit;
             tran.add("Credited" + deposit);
              System.out.println();
               System.out.println(" Amount Deposited");
              
     }
     public static void debitAmount()
     {
          System.out.println();
           System.out.println(" Debit Amount ");
            System.out.println();
             System.out.println("Enter an amount");
             double debit = sc.nextDouble();
              System.out.println(" Enter Your Pin");
              int pin1 = sc.nextInt();
              
              if(pin == pin1)
              {
                  if(debit<=bal)
                  {
                      bal = bal- debit;
                      tran.add("debited:" + debit);
                       System.out.println("Amount Debited");
                  }
                  else
                  {
                       System.out.println();
                System.out.println("Wrong pin enetred");
                  }
              }
     }
	 
	 
	 // Apply for Loan
	public static void loan(){
		System.out.println();
		System.out.println("--------- Apply For Loan ----------");
		System.out.println();
		System.out.println("1. Gold Loan");
		System.out.println("2. Home Loan");
		System.out.println("3. Car Loan");
		System.out.println("4. Personal Loan");
		System.out.println("5. Business Loan");
		System.out.println();
		
		System.out.print("Choose Type of Loan: ");
		int option = sc.nextInt();
		System.out.println();
		if (option == 1)
		{
			System.out.println("GOLD LOAN");
			System.out.print("Enter loan Amount: ");
			double loanAmount = sc.nextDouble();
			
			System.out.print("Enter annual interest rate (in %): ");
            double annualInterestRate = sc.nextDouble();
			
			System.out.print("Enter loan tenure (in months): ");
            int loanTenureInMonths = sc.nextInt();
			
			// Convert annual interest rate to monthly interest rate
            double monthlyInterestRate = (annualInterestRate / 100) / 12;

            // Formula for monthly EMI: (P * r * (1 + r)^n) / ((1 + r)^n - 1)
            double monthlyEMI = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTenureInMonths))
                / (Math.pow(1 + monthlyInterestRate, loanTenureInMonths) - 1);

            // Output result
            System.out.printf("Monthly EMI: %.2f%n", monthlyEMI);
			
			// Optional: Calculate total payment and interest
            double totalPayment = monthlyEMI * loanTenureInMonths;
            double totalInterest = totalPayment - loanAmount;

            System.out.printf("Total payment: %.2f%n", totalPayment);
            System.out.printf("Total interest: %.2f%n", totalInterest);
			
		}
		else if (option == 2)
		{
			System.out.println("HOME LOAN");
			System.out.print("Enter loan Amount: ");
			double loanAmount = sc.nextDouble();
			
			System.out.print("Enter annual interest rate (in %): ");
            double annualInterestRate = sc.nextDouble();
			
			System.out.print("Enter loan term (in years): ");
            int loanTermInYears = sc.nextInt();
			
			// Convert annual interest rate to monthly and term to months
           double monthlyInterestRate = (annualInterestRate / 100) / 12;
           int loanTermInMonths = loanTermInYears * 12;
		   
		   // Formula for monthly payment (P * r * (1 + r)^n) / ((1 + r)^n - 1)
           double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermInMonths))
                / (Math.pow(1 + monthlyInterestRate, loanTermInMonths) - 1);

           // Output result
           System.out.printf("Monthly EMI: %.2f%n", monthlyPayment);
		   
		   // Optional: Calculate total payment and interest
            double totalPayment = monthlyPayment * loanTermInMonths;
            double totalInterest = totalPayment - loanAmount;

            System.out.printf("Total payment: %.2f%n", totalPayment);
            System.out.printf("Total interest: %.2f%n", totalInterest);
			
		}
		else if (option == 3)
		{
			System.out.println("CAR LOAN");
			System.out.print("Enter loan Amount: ");
			double loanAmount = sc.nextDouble();
			
			System.out.print("Enter annual interest rate (in %): ");
            double annualInterestRate = sc.nextDouble();
			
			System.out.print("Enter loan term (in years): ");
            int loanTermInYears = sc.nextInt();
			
			// Convert annual interest rate to monthly interest rate and tenure to months
            double monthlyInterestRate = (annualInterestRate / 100) / 12;
            int loanTenureInMonths = loanTermInYears * 12;

            // Formula for monthly EMI: (P * r * (1 + r)^n) / ((1 + r)^n - 1)
            double monthlyEMI = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTenureInMonths))
                / (Math.pow(1 + monthlyInterestRate, loanTenureInMonths) - 1);

            // Output result
             System.out.printf("Monthly EMI: %.2f%n", monthlyEMI);
			
			// Optional: Calculate total payment and interest
            double totalPayment = monthlyEMI * loanTenureInMonths;
            double totalInterest = totalPayment - loanAmount;

            System.out.printf("Total payment: %.2f%n", totalPayment);
            System.out.printf("Total interest: %.2f%n", totalInterest);
		   
		}
		else if (option == 4)
		{
			System.out.println("PERSONAL LOAN");
			System.out.print("Enter loan Amount: ");
			double loanAmount = sc.nextDouble();
			
			System.out.print("Enter annual interest rate (in %): ");
            double annualInterestRate = sc.nextDouble();
			
			System.out.print("Enter loan term (in years): ");
            int loanTermInYears = sc.nextInt();
			
			// Convert annual interest rate to monthly interest rate and tenure to months
            double monthlyInterestRate = (annualInterestRate / 100) / 12;
            int loanTenureInMonths = loanTermInYears * 12;

            // Formula for monthly EMI: (P * r * (1 + r)^n) / ((1 + r)^n - 1)
            double monthlyEMI = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTenureInMonths))
                / (Math.pow(1 + monthlyInterestRate, loanTenureInMonths) - 1);

            // Output result
            System.out.printf("Monthly EMI: %.2f%n", monthlyEMI);

            // Optional: Calculate total payment and total interest
            double totalPayment = monthlyEMI * loanTenureInMonths;
            double totalInterest = totalPayment - loanAmount;

            System.out.printf("Total payment: %.2f%n", totalPayment);
            System.out.printf("Total interest: %.2f%n", totalInterest);
				
		}
		else if (option == 5)
		{
			System.out.println("BUSINESS LOAN");
			System.out.print("Enter loan Amount: ");
			double loanAmount = sc.nextDouble();
			
			System.out.print("Enter annual interest rate (in %): ");
            double annualInterestRate = sc.nextDouble();
			
			System.out.print("Enter loan term (in years): ");
            int loanTermInYears = sc.nextInt();
			
			// Convert annual interest rate to monthly interest rate and tenure to months
            double monthlyInterestRate = (annualInterestRate / 100) / 12;
            int loanTenureInMonths = loanTermInYears * 12;

            // Formula for monthly EMI: (P * r * (1 + r)^n) / ((1 + r)^n - 1)
            double monthlyEMI = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTenureInMonths))
                / (Math.pow(1 + monthlyInterestRate, loanTenureInMonths) - 1);

            // Output result
            System.out.printf("Monthly EMI: %.2f%n", monthlyEMI);

            // Optional: Calculate total payment and total interest
            double totalPayment = monthlyEMI * loanTenureInMonths;
            double totalInterest = totalPayment - loanAmount;
 
            System.out.printf("Total payment: %.2f%n", totalPayment);
            System.out.printf("Total interest: %.2f%n", totalInterest);
		}
		else{
			System.out.println("INVALID OPTION");
		}
	}
     
 }