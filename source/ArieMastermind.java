//Arie
import java.util.Random;
import java.awt.Color;
import java.lang.Thread;

public class ArieMastermind
{
   public static void main(String args[])
   {
      //Arrays and variables
      String colour[] = {"red", "green", "blue", "yellow", "cyan", "orange", "black", "white",};
      String colourSelect;
      String code[] = new String[4];
      String backColourMatrix[] = new String[4]; 
      colourSelect = "This will be the colour chosen";
      int row, col, x, y, workingColour;
      int colourPlaceholder[] = {0,0,0,0,0,0,0,0};
      workingColour = 0;
      x = 11;
      y = 6;
      row = 0;
      col = 0;
      boolean validColourChoice, validChoice, restart;
      restart = true;
      boolean spotOneCorrect = false, spotTwoCorrect = false ,spotThreeCorrect = false, spotFourCorrect = false;
      
      validColourChoice = false;
      validChoice = false;
      
      
      //Creating board and other
      int backMatrix[][] = new int[16][11];
      Board MainBoard = new Board(16, 11);
      Coordinate spot = new Coordinate(0, 0);
      
      //Creating Lines to Seperate Areas
      MainBoard.drawLine(1,0,1,10);
      MainBoard.drawLine(1,5,15,5);
      MainBoard.drawLine(12,0,12,10);
      MainBoard.drawLine(15,0,15,10);
      MainBoard.drawLine(15,0,1,0);
      MainBoard.drawLine(15,10,1,10);
      //Game Restart loop start
      while(restart)
      {
         //Placing Colours
         MainBoard.putPeg("red", 13, 1);
         MainBoard.putPeg("green", 13, 2);
         MainBoard.putPeg("blue", 13, 3);
         MainBoard.putPeg("yellow", 13, 4);
         MainBoard.putPeg("cyan", 14, 1);
         MainBoard.putPeg("orange", 14, 2);
         MainBoard.putPeg("black", 14, 3);
         MainBoard.putPeg("white", 14, 4);
      
      
         //Setting up amount of colour array
         //red = 0 green = 1 blue = 2 yellow = 3 cyan = 4 orange = 5 black = 6 white = 7
         code = ArieMastermind.createCode(colour, code);
         int amountOfColour[] = new int[8];
         
         //Placing code to see for debug
         //MainBoard.putPeg(code[0], 13, 6);
         //MainBoard.putPeg(code[1], 13, 7);
         //MainBoard.putPeg(code[2], 13, 8);
         //MainBoard.putPeg(code[3], 13, 9);
         
         //Checking for amount of each colour
         for(int p = 0;p<=3;p++)
         {
            if(code[p] == "red")
            {
               amountOfColour[0]++;
               colourPlaceholder[0]++;
            }    
            if(code[p] == "green")
            {
               amountOfColour[1]++;
               colourPlaceholder[1]++;
            } 
            if(code[p] == "blue")
            {
               amountOfColour[2]++;
               colourPlaceholder[2]++;
            } 
            if(code[p] == "yellow")
            {
               amountOfColour[3]++;
               colourPlaceholder[3]++;
            } 
            if(code[p] == "cyan")
            {
               amountOfColour[4]++;
               colourPlaceholder[4]++;
            } 
            if(code[p] == "orange")
            {
               amountOfColour[5]++;
               colourPlaceholder[5]++;
            } 
            if(code[p] == "black")
            {
               amountOfColour[6]++;
               colourPlaceholder[6]++;
            } 
            if(code[p] == "white")
            {
               amountOfColour[7]++;
               colourPlaceholder[7]++;
            } 
         
         }
         
         
         //Start
         while(true)
         {
            //To know if row is full
            if(backMatrix[x][1] == 1 && backMatrix[x][2] == 1 && backMatrix[x][3] == 1 && backMatrix[x][4] == 1)
            {
               //Printing red pegs
               if(backColourMatrix[0] == code[0])
               {
                  //To recognize what colour I am working with as a number
                  for(int q=0;q<=7;q++)
                  {
                     if(backColourMatrix[0] == colour[q])
                     {
                        workingColour = q;
                        break;
                     }
                  }
                  
                  if(amountOfColour[workingColour] > 0)
                  {
                     MainBoard.putPeg("red", x, y); // placing red peg
                     spotOneCorrect = true; //Self explanatory
                     y++; // advance col
                     --amountOfColour[workingColour]; //reduce amount of colour left
                  }
               }
               
               if(backColourMatrix[1] == code[1])
               {
                  for(int q=0;q<=7;q++)
                  {
                     if(backColourMatrix[1] == colour[q])
                     {
                        workingColour = q;
                        break;
                     }
                  }
                  
                  if(amountOfColour[workingColour] > 0)
                  {
                     MainBoard.putPeg("red", x, y);
                     spotTwoCorrect = true;
                     y++;
                     --amountOfColour[workingColour];
                  }
               }
               
               if(backColourMatrix[2] == code[2])
               {
                  for(int q=0;q<=7;q++)
                  {
                     if(backColourMatrix[2] == colour[q])
                     {
                        workingColour = q;
                        break;
                     }
                  }
                  
                  if(amountOfColour[workingColour] > 0)
                  {
                     MainBoard.putPeg("red", x, y);
                     spotThreeCorrect = true;
                     y++;
                     --amountOfColour[workingColour];
                  }
               
               }
               
               if(backColourMatrix[3] == code[3])
               {
                  for(int q=0;q<=7;q++)
                  {
                     if(backColourMatrix[3] == colour[q])
                     {
                        workingColour = q;
                        break;
                     }
                  }
                  
                  if(amountOfColour[workingColour] > 0)
                  {
                     MainBoard.putPeg("red", x, y);
                     spotFourCorrect = true;
                     y++;
                     --amountOfColour[workingColour];
                  }
               
               }
               //------------------------------------------------------------------------------------------
               //White pegs
              
               if(backColourMatrix[0] == code[1] && spotOneCorrect == false || backColourMatrix[0] == code[2] && spotOneCorrect == false || backColourMatrix[0] == code[3] && spotOneCorrect == false )
               {
                  //To recognize what colour I am working with as a number
                  for(int q=0;q<=7;q++)
                  {
                     if(backColourMatrix[0] == colour[q])
                     {
                        workingColour = q;
                        break;
                     }
                  }
                  
                  if(amountOfColour[workingColour] > 0)
                  {
                     MainBoard.putPeg("white", x, y);
                     y++;
                     --amountOfColour[workingColour];
                  }
               }
               
               if(backColourMatrix[1] == code[0] && spotTwoCorrect == false || backColourMatrix[1] == code[2] && spotTwoCorrect == false || backColourMatrix[1] == code[3] && spotTwoCorrect == false)
               {
                  for(int q=0;q<=7;q++)
                  {
                     if(backColourMatrix[1] == colour[q])
                     {
                        workingColour = q;
                        break;
                     }
                  }
                  
                  if(amountOfColour[workingColour] > 0)
                  {
                     MainBoard.putPeg("white", x, y);
                     y++;
                     --amountOfColour[workingColour];
                  }
               }
               
               if(backColourMatrix[2] == code[0] && spotThreeCorrect == false || backColourMatrix[2] == code[1] && spotThreeCorrect == false || backColourMatrix[2] == code[3] && spotThreeCorrect == false)
               {
                  for(int q=0;q<=7;q++)
                  {
                     if(backColourMatrix[2] == colour[q])
                     {
                        workingColour = q;
                        break;
                     }
                  }
                  
                  if(amountOfColour[workingColour] > 0)
                  {
                     MainBoard.putPeg("white", x, y);
                     y++;
                     --amountOfColour[workingColour];
                  }
               }
               
               if(backColourMatrix[3] == code[0] && spotFourCorrect == false || backColourMatrix[3] == code[1] && spotFourCorrect == false || backColourMatrix[3] == code[2] && spotFourCorrect == false)
               {
                  for(int q=0;q<=7;q++)
                  {
                     if(backColourMatrix[3] == colour[q])
                     {
                        workingColour = q;
                        break;
                     }
                  }
                  
                  if(amountOfColour[workingColour] > 0)
                  {
                     MainBoard.putPeg("white", x, y);
                     y++;
                     --amountOfColour[workingColour];
                  }             
               }
               //Reset amount of colours and other resets
               for(int q=0;q<=7;q++)
               {
                  amountOfColour[q] = colourPlaceholder[q];
               }
               spotOneCorrect = false;  
               spotTwoCorrect = false; 
               spotThreeCorrect = false;
               spotFourCorrect = false;         
                           
               //Win Condition
               if(backColourMatrix[0] == code[0] && backColourMatrix[1] == code[1] && backColourMatrix[2] == code[2] && backColourMatrix[3] == code[3])
               {
                  
                  MainBoard.displayMessage("You cracked the code!");
                  try
                  {
                     Thread.sleep(2000); //2 seconds  
                  }
                  catch(InterruptedException ex) 
                  {
                     Thread.currentThread().interrupt();
                  }      
               
                  break;
               }
               //To advance row
               x--;
               //To reset column
               y = 6;
            }
            
            //If last row is filled and player has lost
            if(x == 1)
            {
               MainBoard.displayMessage("You have failed, better luck next time.");
               try
               {
                  Thread.sleep(2000); //2 seconds
               }
               catch(InterruptedException ex) 
               {
                  Thread.currentThread().interrupt();
               }      
            
               break;
            }
            MainBoard.displayMessage("Choose a colour");
                     
            //Check to see if choice is valid
            while(validColourChoice == false)
            {
               spot = MainBoard.getClick();
               row = spot.getRow();
               col = spot.getCol();
               validColourChoice = ArieMastermind.CheckIfValidColour(MainBoard, row, col);
            }
            //to reset validChoice
            validColourChoice = false;
            
            //To register colour choice
            while(row >= 13 && row <= 14 && col >= 1 && col <= 4)
            {
               colourSelect = ArieMastermind.ColourChoice(MainBoard, row, col, colour, colourSelect);
               
               //Message to tell the user to choose a spot
               // try
               //             {
               //                Thread.sleep(1000); //1 second    
               //             }
               //             catch(InterruptedException ex) 
               //             {
               //                Thread.currentThread().interrupt();
               //             }      
               //          
               //             MainBoard.displayMessage("Please select a spot, or choose a different colour");
               
               //Check if valid choice
               while(validChoice == false)
               {  
                  spot = MainBoard.getClick();
                  row = spot.getRow();
                  col = spot.getCol(); 
                  validChoice = ArieMastermind.CheckIfValidSelectionOverall(MainBoard, row, col, x);
               }
               
               //Reset validChoice
               validChoice = false;
               
               //If they re-select a colour
               if(row >= 12 && row <= 14 && col >= 1 && col <= 4)
               {
                  colourSelect = ArieMastermind.ColourChoice(MainBoard, row, col, colour, colourSelect);
               }
               //If a spot is chosen
               if(row == x && col >= 1 && col <= 4)
               {
                  MainBoard.putPeg(colourSelect, row, col);//Placing colour
                  backMatrix[row][col] = 1;//Filling matrix
                  backColourMatrix[col-1] = colourSelect;//Filling colour matrix
               }
            }        
         }
         //Game is done and loop is broken
         //Print the code at the top and the red and green buttons
         MainBoard.putPeg(code[0], 0, 1);
         MainBoard.putPeg(code[1], 0, 2);
         MainBoard.putPeg(code[2], 0, 3);
         MainBoard.putPeg(code[3], 0, 4);
         MainBoard.putPeg("green", 0, 9);
         MainBoard.putPeg("red", 0, 10);
         MainBoard.displayMessage("Click the green button at the top right to restart, or click the red button to exit.");
         //If the user doesn't choose a valid option
         while(row > 0 || row == 0 && col < 9)
         {
            spot = MainBoard.getClick();
            row = spot.getRow();
            col = spot.getCol(); 
         }
         //If the user chooses to restart
         if(row == 0 && col == 9)
         {
            //clear pegs and reset variables
            workingColour = 0;
            x = 11;
            y = 6;
            row = 0;
            col = 0;
            backColourMatrix[0] = "placeholder";
            backColourMatrix[1] = "placeholder";
            backColourMatrix[2] = "placeholder";
            backColourMatrix[3] = "placeholder";
            for(int q=0;q<=7;q++)
            {
               colourPlaceholder[q] = 0;
            }
            for(int r=0;r<=15;r++)
            {
               for(int c=0;c<=10;c++)
               {
                  MainBoard.removePeg(r, c);
                  backMatrix[r][c] = 0;
               }
            }
         }
         //If the user chooses to exit
         if(row == 0 && col == 10)
         {
            System.exit(0);
         }
      }
   }
   
   
   
   
   //Method for checking for a valid choice of a colour, or a spot
   public static boolean CheckIfValidSelectionOverall(Board MainBoard, int row, int col, int x)
   {
      if(row == x && col >= 1 && col <= 4 || row <= 14 && row >= 13 && col >= 1 && col <= 4)
      {
         return true;
      }
      
      else
      {
         return false;
      }
   }
   //I don't use this method I think
   public static boolean CheckIfValidSelection(Board MainBoard, int row, int col)
   {
      if(row == 11 && col >= 1 && col <= 4)
      {
         return true;
      }
      
      else
      {
         return false;
      }
   }
   //Method for checking for a valid choice of a colour
   public static boolean CheckIfValidColour(Board MainBoard, int row, int col)
   {
      if(row >= 12 && row <= 14 && col >= 1 && col <= 4)
      {
         return true;
      }
      
      else
      {
         return false;
      }
         
   }
   //Method to recognize what colour is selected
   public static String ColourChoice(Board MainBoard, int row, int col, String colour[], String colourSelect)
   {
      //red
      if(row==13&&col==1)
      {
         colourSelect = colour[0]; //Making colour select equal red
         MainBoard.displayMessage(colourSelect+" colour selected");//Print what colour is selected
         return colourSelect;
      }
      //green
      else if(row==13&&col==2)
      {
         colourSelect = colour[1];
         MainBoard.displayMessage(colourSelect+" colour selected");
         return colourSelect;
      }
      //etc....
      else if(row==13&&col==3)
      {
         colourSelect = colour[2];
         MainBoard.displayMessage(colourSelect+" colour selected");
         return colourSelect;
      }
      
      else if(row==13&&col==4)
      {
         colourSelect = colour[3];
         MainBoard.displayMessage(colourSelect+" colour selected");
         return colourSelect;
      }
      
      else if(row==14&&col==1)
      {
         colourSelect = colour[4];
         MainBoard.displayMessage(colourSelect+" colour selected");
         return colourSelect;
      }
      
      else if(row==14&&col==2)
      {
         colourSelect = colour[5];
         MainBoard.displayMessage(colourSelect+" colour selected");
         return colourSelect;
      }
      
      else if(row==14&&col==3)
      {
         colourSelect = colour[6];
         MainBoard.displayMessage(colourSelect+" colour selected");
         return colourSelect;
      }
      
      else if(row==14&&col==4)
      {
         colourSelect = colour[7];
         MainBoard.displayMessage(colourSelect+" colour selected");
         return colourSelect;
      }
      
      else
      {    
         return colourSelect;
      }
      
   }
   //Method to generate a random code
   public static String[] createCode(String colour[], String code[])
   {
      Random ranvar = new Random();
      for(int x=0;x<4;x++)
      {
         code[x] = colour[ranvar.nextInt(8)];
      }
      return code;
   }
   
}