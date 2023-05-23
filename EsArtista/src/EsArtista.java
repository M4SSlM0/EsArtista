import java.util.concurrent.Semaphore;

public class EsArtista {

	public static void main(String[] args) {
		
		Semaphore artista = new Semaphore(1);
		Semaphore sedie = new Semaphore (4);
		Data d=new Data(artista,sedie,4);
		
		for(int i=0;i<25;i++) {
			Cliente c = new Cliente(d,i);
			c.start();
			System.out.println("cliente "+c.numeroCliente+" si e' aggiunto alla coda");
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
