package ui.text;

import logic.StateMachine;
import logic.data.GameData;
import logic.states.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class UIText {

    private StateMachine game;
    private boolean exit = false;

    public UIText(StateMachine game) { this.game = game; }


    public void execute(){
        while(!exit){
            Scanner scanner = new Scanner(System.in);
            if(game.getState() instanceof AwaitBeginning){
                System.out.println("Iniciar (1) ou fechar (2): ");
                while (!scanner.hasNextInt()) ;
                int num = scanner.nextInt();
                uiAwaitBeggining(num);
            }else if(game.getState() instanceof AwaitShipSelection){
                System.out.println("Select Ship (Military) or (Mining): ");
                while (!scanner.hasNext()) ;
                String type = scanner.nextLine();
                uiAwaitShipSelection(type);
            }else if(game.getState() instanceof AwaitSpaceTravel){
                uiAwaitSpaceTravel();
            }else if(game.getState() instanceof AwaitPlanetOrbit){
                System.out.println("Docking (1) ou landing (2) ou conversion (3) ou exit (4): ");
                while (!scanner.hasNextInt()) ;
                int num = scanner.nextInt();
                uiOrbitPlanet(num);
            }else if(game.getState() instanceof AwaitLanding){
                System.out.println("Explorar (1) ou orbitar (2): ");
                while (!scanner.hasNextInt()) ;
                int num = scanner.nextInt();
                uiLanding(num);
            }else if(game.getState() instanceof AwaitResourceConversion){
                System.out.println("Conversor de recursos: ");
                System.out.println("Add position x: ");
                while (!scanner.hasNextInt());
                int x = scanner.nextInt();
                scanner.reset();

                System.out.println("Add position y: ");
                while (!scanner.hasNextInt());
                int y = scanner.nextInt();
                scanner.reset();

                System.out.println("Converter para: ");
                while (!scanner.hasNext()) ;
                String convert = scanner.nextLine();
                uiAwaitResourceConversion(new int[]{x,y}, convert);
            }else if(game.getState() instanceof AwaitMove){
                final KeyAdapter keyAdapter = new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_UP)
                            uiAwaitMove(e.getKeyCode());
                        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
                            uiAwaitMove(e.getKeyCode());
                        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
                            uiAwaitMove(e.getKeyCode());
                        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                            uiAwaitMove(e.getKeyCode());
                    }
                };
            }else if(game.getState() instanceof AwaitStationDocking){
                System.out.println("Select Action (1) or (2): ");
                while (!scanner.hasNextInt());
                int action = scanner.nextInt();
                scanner.reset();
                System.out.println("Select (1) or (2): ");
                while (!scanner.hasNextInt());
                int y = scanner.nextInt();
                uiAwaitDocking(action, y);
            }else if(game.getState() instanceof AwaitGameOver){
                System.out.println("Select (1) or (2): ");
                while (!scanner.hasNextInt());
                int y = scanner.nextInt();
                uiAwaitGameOver(y);
            }else if(game.getState() instanceof AwaitExitConfirmation){
                System.out.println("Select (1) or (2): ");
                while (!scanner.hasNextInt());
                int y = scanner.nextInt();
                uiAwaitExitConfirmation(y);
            }else if(game.getState() instanceof AwaitResourceCollection) {
                System.out.println("Select (1) or (2): ");
                while (!scanner.hasNextInt());
                int y = scanner.nextInt();
                uiAwaitResourceCollection(y);
            }else if(game.getState() instanceof AwaitTerrainExploration){
                System.out.println("Select (1) or (2): ");
                while (!scanner.hasNextInt());
                int y = scanner.nextInt();
                uiAwaitTerrainExploration(y);
            }
        }
    }

    private void uiAwaitBeggining(int choice)
    {
        System.out.println(game.toString());
        game.play(choice);
    }

    private void uiAwaitShipSelection(String type)
    {
        System.out.println(game.toString());
        game.chooseShip(type);
    }

    private void uiAwaitSpaceTravel()
    {
        System.out.println(game.toString());
        game.spaceTravel();
    }

    private void uiOrbitPlanet(int choice)
    {
        System.out.println(game.toString());
        game.enterPlanet(choice);
    }

    private void uiLanding(int choice)
    {
        System.out.println(game.toString());
        game.landing(choice);
    }

    private void uiAwaitResourceConversion(int[] location, String convertTo)
    {   
        System.out.println(game.toString());
        game.convertResource(location, convertTo);
    }

    private void uiAwaitMove(int key)
    {
        System.out.println(game.toString());
        game.move(key);
    }

    private void uiAwaitGameOver(int choice)
    {
        System.out.println(game.toString());
        game.gameOver(choice);
    }

    private void uiAwaitDocking(int action, Object... arguments)
    {
        System.out.println(game.toString());
        game.dockingAction(action, arguments);
    }

    private void uiAwaitExitConfirmation(int choice)
    {
        System.out.println(game.toString());
        game.exit(choice);
    }

    private void uiAwaitResourceCollection(int choice)
    {
        System.out.println(game.toString());
        game.collect(choice);
    }

    private void uiAwaitTerrainExploration(int choice)
    {
        System.out.println(game.toString());
        game.explore(choice);
    }
}
