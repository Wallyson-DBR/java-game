import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Player extends Actor {

    //Atributos
    public int vida;
    public int velocidade;
    public int estamina;
    public int pontos;
    boolean isDano = false;
    int tempoDano = 100;

    private int contadorFrames = 0;
    private int frameAtual = 1;

    private String ultimaDirecao = "baixo";

    //Construtor
    public Player() {
    }

    public Player(int vida, int velocidade, int estamina) {
        this.vida = vida;
        this.velocidade = velocidade;
        this.estamina = estamina;
        this.pontos = 0;
        setImage("imagens/jogadores/Jogador4/Jogador_baixo_1.png" );
    }

    //Metodos
    public void act() {
        movimentar();
        coletarMoedas();

        if (isDano == true){
            tempoDano --;
            if (tempoDano ==0)
        }
    }

    public void movimentar() {
        boolean isAndando = false;
        String direcao = "";


        if (Greenfoot.isKeyDown("w" )) {
            setLocation(getX(), getY() - velocidade);
            isAndando = true;
            direcao = "cima";
        }
        if (Greenfoot.isKeyDown("a" )) {
            setLocation(getX() - velocidade, getY());
            isAndando = true;
            direcao = "esquerda";
        }
        if (Greenfoot.isKeyDown("s" )) {
            setLocation(getX(), getY() + velocidade);
            isAndando = true;
            direcao = "baixo";
        }
        if (Greenfoot.isKeyDown("d" )) {
            setLocation(getX() + velocidade, getY());
            isAndando = true;
            direcao = "direita";
        }
        if (isAndando) {
            ultimaDirecao = direcao; // Salva a direção atual
            animar(direcao);
        } else {
            setImage("imagens/jogadores/Jogador4/Jogador_" + ultimaDirecao + "_1.png" );
        }
    }

    public void animar(String direcao) {
        contadorFrames++;

        int dalayAnimacao = 5;
        if (contadorFrames >= dalayAnimacao) {
            contadorFrames = 0;

            frameAtual = (frameAtual % 4) + 1;

            String nomeImagem = "imagens/jogadores/Jogador4/Jogador_" + direcao + "_" + frameAtual + ".png";

            setImage(nomeImagem);
        }

    }

    public void coletarMoedas() {

        if (isTouching(Coin.class)) {

            Coin coinFind = (Coin) getOneIntersectingObject(Coin.class);
            this.pontos = pontos + coinFind.valor;
        getWorld().removeObject(coinFind);

        System.out.println(this.pontos);
        }
    }

    public void sofreDano(int dano) {

        if (this.vida >= dano && !isDano) {
            this.vida = this.vida - dano; // ou: this.vida -= dano;
        } else {
            this.vida = 0;
        }
        isDano = true;
        System.out.println("Vidas: " + this.vida);
    }

}
