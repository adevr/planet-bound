package logic.factories;

import logic.Helper;
import logic.data.spaceships.MilitaryShip;
import logic.data.spaceships.MiningShip;
import logic.data.spaceships.SpaceShip;

public class SpaceShipFactory
{
    /**
     * Method that builds new spaceship based on type
     *
     * @param type
     * @param specifiedOptions
     * @return SpaceShip
     */
    public static SpaceShip buildSpaceShip(String type, Object... specifiedOptions)
    {
        Object[] options;
        if(specifiedOptions.length > 0) {
            options = specifiedOptions;
        } else {
            options = setRandomShipOptions();
        }

        if(type == "Military")
            return new MilitaryShip(type, (int)options[0], (int)options[1], (int)options[2], (int[])options[3]);

        return new MiningShip(type, (int)options[0], (int)options[1], (int)options[2], (int[])options[3]);
    }


    private static Object[] setRandomShipOptions()
    {
        return new Object[]{
                Helper.generateRandomInt(10),
                Helper.generateRandomInt(10),
                Helper.generateRandomInt(10),
                new int[]{Helper.generateRandomInt(2), Helper.generateRandomInt(10)}
        };
    }

}
