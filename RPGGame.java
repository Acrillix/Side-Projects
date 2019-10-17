import java.util.*;

public class RPGGame {

   Scanner myScanner = new Scanner(System.in);
   Scanner enterScanner = new Scanner(System.in);
   
   int playerHP;
   String playerName;
   String playerWeapon;
   int choice;
   int enemyHP;
   int speech;
   int physical;
   int silverRing;
   
   public static void main(String [] args) {
      
     RPGGame dublin;
		dublin = new RPGGame();	
		
		dublin.playerSetup(); 	
		dublin.townGate();
  }
  
  public void playerSetup() {
   
   playerHP = 10;
   enemyHP = 15;
   
   playerWeapon = "Broadsword";
   
   System.out.println("Your HP: " + playerHP);
   System.out.println("Your weapon: " + playerWeapon);
   
   System.out.println("Please enter a character name: ");
   playerName = myScanner.nextLine();
   
   System.out.println("Hello " + playerName + ", let's start the game!");
   
   }
   
   public void townGate() {
   
      System.out.println("----------------------------------------------------------");
      System.out.println("You are at the gate of a town.");
      System.out.println("There is a guard posted at the gate.");
      System.out.println("");
      System.out.println("What would you like to do?");
      System.out.println("1: Talk to the guard");
      System.out.println("2: Attack the guard");
      System.out.println("3: Leave");
      System.out.println("---------------------------------------------------------");
      
      choice = myScanner.nextInt();
      
      if(choice == 1) {
         if(speech == 1) { 
            ending();
         } else {
            System.out.println("Guard: Hello there stranger. So your name is " + playerName + "? Sorry, but we are on strict orders not to let anyone in today.");
            enterScanner.nextLine();
            townGate();
         }   
       } else if(choice == 2) {
           playerHP = playerHP-1;
           System.out.println("Guard: Ow! What the hell you do that for?? The guard hits you back. (You take 1 damage)");
           System.out.println("Your HP: " + playerHP);
           enterScanner.nextLine();
           townGate();
      } else if(choice == 3) {
         crossRoad();
      } else {
         townGate();
      }
 }     
     
      public void crossRoad() {
         System.out.println("---------------------------------------------------");
         System.out.println("You are at a crossroad. If you go South, you will return to the town. Where will you go?");
         System.out.println("1: Go north");
         System.out.println("2: Go east");
         System.out.println("3: Go south");
         System.out.println("4: Go west");
         System.out.println("---------------------------------------------------");
         
         choice = myScanner.nextInt();
         
         if(choice == 1) {
            north();
         }else if(choice == 2) {
            east();
         }else if(choice == 3) {
            townGate();
         }else if(choice == 4) {
            west();
         }else {
            crossRoad();
         }
         
     }
     
     public void north() {
      System.out.println("-----------------------------------------------------------");
      System.out.println("There is a river. You drink the water and rest for awhile."); 
      System.out.println("Your HP is recovered");
      playerHP = playerHP + 1;
      System.out.println("Your HP: " + playerHP);
      System.out.println("1: Go back to the crossroad.");
      
      choice = myScanner.nextInt();
      
      if(choice == 1) {
         crossRoad();
       } else {
         north();
       }
  }     
    public void east() {
      System.out.println("-----------------------------------------------------------");
      System.out.println("You walked into a forest and found a Bow!");
      playerWeapon = "Bow";
      System.out.println("Your weapon: " + playerWeapon);
      System.out.println("1: Go back to crossroads");
      System.out.println("-----------------------------------------------------------");
      
      choice = myScanner.nextInt();
      
      if(choice == 1) {
         crossRoad();
      } else { 
         east();
      }
   }   
  public void west() {
   System.out.println("------------------------------------------------------------");
   System.out.println("You encounter a goblin!");
   System.out.println("1: Fight!");
   System.out.println("2: Run!");
   System.out.println("------------------------------------------------------------");
   
   choice = myScanner.nextInt();
   
   if(choice == 1) {
      fight();
   }else if(choice == 2) {
      crossRoad();
   }else {
      west();
   }
   }
   
 public void fight() {
   System.out.println("---------------------------------------------------------");
   System.out.println("Your HP: " + playerHP);
   System.out.println("Enemy HP: " + enemyHP);
   System.out.println("1: Attack");
   System.out.println("2: Run");
   System.out.println("---------------------------------------------------------");
   
   choice = myScanner.nextInt();
   
   if(choice == 1) {
      attack();
   }else if(choice == 2) {
      crossRoad();
   } else {
      fight();
   }
         
}              
             
 public void attack() {       
   int playerDamage = 0;
   
   if(playerWeapon. equals("Broadsword")) {
      playerDamage = new java.util.Random().nextInt(8);
      } else if(playerWeapon. equals("Bow")) {
         playerDamage = new java.util.Random().nextInt(5);
      }
      
      System.out.println("You attacked the enemy and gave " + playerDamage + " damage!");
      
      enemyHP = enemyHP - playerDamage;
      
      System.out.println("Enemy HP: " + enemyHP);
      
      if(enemyHP < 1) { win(); } else if(enemyHP > 0) {
         int enemyDamage = 0;
         
         enemyDamage = new java.util.Random().nextInt(4);
         
         System.out.println("The enemy attacked you and gave " + enemyDamage + " damage!");
         
         playerHP = playerHP - enemyDamage;
         
         System.out.println("Player HP: " + playerHP);
         
         if(playerHP < 1) { 
            dead(); 
         } else if (playerHP > 0) {
            fight();
         }   
    }        
      
}                      
                          
 public void dead () {
   System.out.println("------------------------------");
   System.out.println("You are dead!");
   System.out.println("GAME OVER");
   System.out.println("------------------------------");
   
}
   public void win(){
      System.out.println("------------------------------");
      System.out.println("You killed the goblin!");
      System.out.println("The goblin dropped a silver ring!");
      System.out.println("You obtained a silver ring!");
      System.out.println("1: Go east");
      System.out.println("2: Return to the Guard");
      System.out.println("------------------------------");
      
      silverRing = 1;
      
      choice = myScanner.nextInt();
      if(choice == 1) {
         crossRoad();
      } else if(choice == 2) {
         ending();
      }
 }
 
   public void ending() {
      System.out.println("---------------------------------");
      System.out.println("Guard: Oh you killed that goblin?? Great!");
      System.out.println("Guard: Well, you seem like you can handle yourself. Welcome to our town!");
      System.out.println("\t\t THE END \t\t");
      System.out.println("----------------------------------");     
         
                  
        
   
   }
} 
