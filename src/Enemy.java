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

    public Enemy(int dano, int velocidade, String imagem) {
        this.dano = dano;
        this.velocidade = velocidade;
        definirDirecaoInicial();
        setImage(imagem);
    }

    public void act() {
        movimentar();
        atacar();
    }

    public void movimentar() {
        setLocation(getX() + (velocidade * direcao), getY());

        // Inverte a direção ao encostar nos limites da tela
        if (getX() <= 10 || getX() >= 1190) {
            direcao = direcao * -1;
        }
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
            playerFind.sofreDano(this.dano);
        }
    }
}