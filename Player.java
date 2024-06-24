package org.example;

public class Player {
    public int health;
    public int attack;
   public int strength;


   public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

   public boolean isAlive() {
        return this.health > 0;
    }
public int getHealth()
{
    return health;

}
public void setHealth(int health)
{
    this.health=health;
}
public int getStrength()
{
    return strength;
}
public void setStrength(int strength)
{
    this.strength=strength;
}
public int getAttack()
{
    return attack;
}
public void setAttack(int attack)
{
    this.attack=attack;
}
public void reduceHealth(int amount)
{
    this.health=Math.max(0, this.health-amount);
}
}
