import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Enemy extends Actor {

    // Atributos
    public int dano;
    public int velocidade;
    public int direcao;

    // Construtores
    public Enemy() {
        definirDirecaoInicial();
    }

    public Enemy(int dano, int velocidade) {
        this.dano = dano;
        this.velocidade = velocidade;
        definirDirecaoInicial();
    }

    //Getters && Setters


    public void act() {
        movimentar();
        atacar();
    }

    public void movimentar() {
        //Esse método é implementado nas classes filhas
    }

    public void definirDirecaoInicial() {
        // Retorna 0 para esquerda (-1) e 1 para direita (+1)
        if (Greenfoot.getRandomNumber(2) == 0) {
            this.direcao = 1;
        } else {
            this.direcao = -1;
        }
    }

    public void atacar(){

        if(isTouching(Player.class)){
            Player playerFind = (Player) getOneIntersectingObject(Player.class);
            playerFind.sofrerDano(this.dano);
        }
    }
}