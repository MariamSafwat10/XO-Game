
package com.mycompany.xo.game;

import java.util.Scanner;

public class Game {
    Player p1 = new Player();
    Player p2 = new Player();
    Board myBoard = new Board();
    int count = 0;
    
    public void readPlayerData(){
        Scanner cin = new Scanner (System.in);
        System.out.println("Enter Player1 name : ");
        String name = cin.next();
        p1.setName(name);
        System.out.println("Choose Player1 operator (x or o ) : ");
        char op = cin.next().charAt(0);
        p1.setOp(op);
        
        
        System.out.println("Enter Player2 name : ");
        String name2 = cin.next();
        p2.setName(name2);
        if(p1.getOp() == 'x')
            p2.setOp('o');
        
        else
            p2.setOp('x');
       
    }
    
    public void play (){ 
        readPlayerData();
        myBoard.draw();
        Scanner cin = new Scanner (System.in);
        while (!myBoard.isFull()){
            Player currentPlayer = p1;
            if(count % 2 == 1)
                currentPlayer = p2;
            while (true){
                int pos;
                System.out.println("Enter pos to play at : ");
                pos = cin.nextInt();
            
                myBoard.replaceChar(pos , currentPlayer);
                
                break;
            }
            
            myBoard.draw();
            if (myBoard.isWin(currentPlayer)){
                System.out.println("The Winner : "+currentPlayer.getName());
                break;
            }
            count++;
        }
        
        if(myBoard.isFull()){
            System.out.println("Game is Draw ..");            
        }
        
    }
            

}
