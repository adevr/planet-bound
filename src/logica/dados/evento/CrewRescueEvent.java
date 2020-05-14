package logica.dados.evento;

import logica.dados.nave.SpaceShip;

public class CrewRescueEvent extends Event
{
    public CrewRescueEvent(SpaceShip ship) {
        super(ship);
    }

    @Override
    public void handle() {
        if(this.ship.getCrew().size()<6){
            for (int i = 1; i <= 6 ; i++) {
                if(!this.ship.getCrew().containsKey(i)){
                    this.ship.addCrewMember(i,this.ship.getOFFICERS()[i-1]);
                }
            }
        }
    }
}
