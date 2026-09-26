import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Enemy extends Actor {

    //Atributos
    public int dano;
    public int velocidade ;
    public int direcao;
    public String imagem;

    //Construtor
    public Enemy(){}
    public Enemy(int dano, int velocidade, String imagem) {

        int numero = Greenfoot.getRandomNumber(10);
        if (numero < 5)
            this.direcao = +1;
        else
            this.direcao = -1;

        this.dano = dano;
        this.velocidade = velocidade;
        setImage(imagem);
    }

    public void act() {
        movimentar();
    }

    public void  movimentar(){
        setLocation(getX() + (velocidade * direcao), getY());
        if (getX() < 10 || getX() > 1190)
            direcao = direcao * -1;
        }
    }


