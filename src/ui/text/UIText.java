package ui.text;

import logica.StateMachine;
import logica.dados.GameData;
import logica.estados.*;

import java.util.Scanner;

public class UIText {

        private StateMachine game;
        private boolean exit = false;

        public UIText(StateMachine game) { this.game = game; }


        public void execute(){
            while(!exit){
                Scanner scanner = new Scanner(System.in);
                if(game.getState() instanceof AwaitBeggining){
                    uiAwaitBeggining();
                }else if(game.getState() instanceof AwaitShipSelection){
                    System.out.println("Select Ship (1) or (2): ");
                    while (!scanner.hasNextInt()) ;
                    int num = scanner.nextInt();
                    uiAwaitShipSelection(num);
                }else if(game.getState() instanceof AwaitSpaceTravel){
                    uiAwaitSpaceTravel();
                }else if(game.getState() instanceof AwaitEvent){
                    uiAwaitEvent();
                }else if(game.getState() instanceof OrbitPlanet){
                    uiOrbitPlanet();
                }else if(game.getState() instanceof Landing){
                    uiLanding();
                }else if(game.getState() instanceof AwaitResourceConversion){
                    uiAwaitResourceConversion();
                }else if(game.getState() instanceof AwaitMove){
                    System.out.println("Add position x: ");
                    while (!scanner.hasNextInt());
                    int x = scanner.nextInt();
                    scanner.reset();

                    System.out.println("Add position y: ");
                    while (!scanner.hasNextInt());
                    int y = scanner.nextInt();
                    uiAwaitMove(x,y);
                }else if(game.getState() instanceof AwaitAlientAttack){
                    uiAlienAttack();
                }else if(game.getState() instanceof AwaitStationDocking){
                    System.out.println("Select Action (1) or (2): ");
                    uiAwaitDocking(scanner.nextInt());
                }else if(game.getState() instanceof AwaitGameOver){
                    uiAwaitGameOver();
                }
            }
        }

        private void uiAwaitBeggining()
        {
            System.out.println(game.toString());
            game.play();
        }

        private void uiAwaitShipSelection(int index)
        {
            System.out.println(game.toString());
            game.selectSpaceShip(index);
        }

        private void uiAwaitSpaceTravel()
        {
            System.out.println(game.toString());
            game.spaceTravel();
        }

        private void uiAwaitEvent()
        {
            System.out.println(game.toString());
            game.doEvent();
        }

        private void uiOrbitPlanet()
        {
            System.out.println(game.toString());
            game.selectPlanetAction();
        }

        private void uiLanding()
        {
            System.out.println(game.toString());
            game.move(0,0);
        }

        private void uiAwaitResourceConversion()
        {
            System.out.println(game.toString());
            game.convertResource();
        }

        private void uiAwaitMove(int x, int y)
        {
            System.out.println(game.toString());
            game.move(x,y);
        }

        private void uiAlienAttack()
        {
            System.out.println(game.toString());
            game.doAlienAttack();
        }

        private void uiAwaitGameOver(){
            System.out.println(game.toString());
            game.gameOver();
        }

        private void uiAwaitDocking(int action){
            System.out.println(game.toString());
            game.doAction(action);
        }
}
