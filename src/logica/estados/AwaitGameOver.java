package logica.estados;

import logica.dados.GameData;

public class AwaitGameOver extends EstadoAdapter {
    public AwaitGameOver(GameData data) {
        super(data);
    }

    @Override
    public IEstado gameOver() {
        return this;
    }
}
