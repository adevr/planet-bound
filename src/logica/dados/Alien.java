package logica.dados;

import logica.dados.nave.SpaceShip;

public class Alien {

    private int lives = 6;

    public Alien()
    {
    }


    public void decrementLife()
    {
        this.lives--;
    }

    public boolean attack(SpaceShip ship)
    {
        if(this.lives > 0 ){
            ship.decrementLives();
        }else return false;
        return true;
    }

    public int getLives() {
        return lives;
    }
}
