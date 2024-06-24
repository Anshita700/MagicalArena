package org.example;
import java.util.Random;
public class MagicalArena {

  public   static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println(rollDice());
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        while (playerA.isAlive() && playerB.isAlive()) {
            if (playerA.getHealth() <= playerB.getHealth()) {
                attack(playerA, playerB);
            } else {
                attack(playerB, playerA);
            }

            // Print health status
            System.out.println("Player A Health: " + playerA.getHealth());
            System.out.println("Player B Health: " + playerB.getHealth());
            System.out.println("------------------------");
        }

        // Determine winner
        if (playerA.isAlive()) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }

    public static void attack(Player attacker, Player defender) {
        int attackRoll = rollDice();
        int defenseRoll = rollDice();

        int attackDamage = attacker.attack * attackRoll;
        int defenseStrength = defender.strength * defenseRoll;

        int damageInflicted = attackDamage - defenseStrength;
        if (damageInflicted > 0) {
            defender.reduceHealth(damageInflicted);
            //defender.health -= damageInflicted;
            System.out.println("Damage inflicted: " + damageInflicted);
        } else {
           System.out.println("No damage inflicted.");
        }

        // Ensure health does not go below zero
        if (defender.getHealth() < 0) {
            defender.setHealth(0);
        }

        // Output roll details

        System.out.println("Attacker rolled: " + attackRoll + " (Attack damage: " + attackDamage + ")");
        System.out.println("Defender rolled: " + defenseRoll + " (Defense strength: " + defenseStrength + ")");
    }

   public static int rollDice() {
        return rand.nextInt(6) + 1;

    }


}