package logic;

public class Helper
{
    /**
     * Method that generates a random integer from a specific max
     *
     * @param max
     * @return int
     */
    public static int generateRandomInt(int max)
    {
        return (int) (Math.random() * ((max - 0) + 1));
    }

    /**
     * Method that generates a random position
     *
     * @return int[]
     */
    public static int[] generateRandomPosition()
    {
        return new int[]{generateRandomInt(6), generateRandomInt(6)};
    }
}
