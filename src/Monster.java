public class Monster extends Enemy{

    public Monster(){}
    public Monster(int dano, int velocidade) {
        super(dano, velocidade);
        setImage("imagens/inimigos/Monstro/Monstro_baixo_0.png");
    }

    @Override
    public void movimentar() {
        setLocation(getX() + (velocidade * direcao), getY());

        // Inverte a direção ao encostar nos limites da tela
        if (getX() <= 10 || getX() >= 1190) {
            direcao = direcao * -1;
        }
    }
}
