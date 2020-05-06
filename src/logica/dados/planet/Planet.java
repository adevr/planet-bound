package logica.dados.planet;

import logica.dados.Terrain;
import logica.dados.nave.SpaceShip;

public abstract class Planet {

    Terrain terrain;
    SpaceShip spaceShip;

    public Planet(SpaceShip spaceShip)
    {
        this.spaceShip = spaceShip;
        this.terrain = new Terrain(spaceShip);
    }




    // a ideia passa por ter uma comparação de instance of no estado
    // será muito por ai a abordagem
    // ver a melhor maneira de implementar isto

}
