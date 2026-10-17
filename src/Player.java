import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Player extends Actor {

    //Atributos
    private int vida;
    private int velocidade;
    private int estamina;
    private int pontos;

    private boolean sofrendoDano = false;
    private int tempoDano = 50;

    private int contadorFrames = 0;
    private int frameAtual = 1;

    private String ultimaDirecao = "baixo";

    //Construtor
    public Player() {}

    public Player(int vida, int velocidade, int estamina) {
        this.vida = vida;
        this.velocidade = velocidade;
        this.estamina = estamina;
        this.pontos = 0;
        setImage("imagens/jogadores/Jogador4/Jogador_baixo_1.png" );
    }

    //Getters && Setters
    public int getVida() {
        return vida;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getEstamina() {
        return estamina;
    }

    public int getPontos() {
        return pontos;
    }

    //Metodos
    public void act() {
        movimentar();
        coletarMoedas();

        if (sofrendoDano) {
            tempoDano--;
            if (tempoDano <= 0) {
                sofrendoDano = false;
                tempoDano = 50;
            }
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

    public void sofrerDano(int dano) {

        if (!sofrendoDano){
            if (vida >= dano){
                vida -= dano;
                sofrendoDano = true;
            }
            if (vida == 0)
                Greenfoot.stop();
        }
    }

}
