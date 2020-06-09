package logic.factories;

import logic.Helper;
import logic.data.Constants;
import logic.data.resources.*;

public class ResourceFactory
{
    /**
     * Method that builds a specific resource randomly
     *
     * @return Resource
     */
    public Resource buildResource()
    {
        int choice = Helper.generateRandomInt(4);
        if(choice == Constants.AMMO_RESOURCE)
            return new AmmoResource();
        else if (choice == Constants.ARTIFACT_RESOURCE)
            return new ArtifactResource();
        else if(choice == Constants.FUEL_RESOURCE)
            return new FuelResource();

        return new ShieldResource();
    }
}
