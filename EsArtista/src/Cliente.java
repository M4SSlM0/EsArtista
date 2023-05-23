import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
	
	Data d;
	int numeroCliente;
	boolean aspettatoTroppo=false;
	
	public Cliente(Data d,int n) {
		this.d=d;
		numeroCliente=n;
	}
	
	
	public void run() {
		
		Thread t = new Thread(()->{
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("il cliente "+numeroCliente+" ha aspettato troppo in coda e se ne e' andato");
			
			aspettatoTroppo=true;
			
		});
		t.start();
		while(d.sedieLibere==0) {try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
		if(!aspettatoTroppo) {
			try {
				d.sedie.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.stop();
			d.sedieLibere--;
				
				
			try {
				d.artista.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			d.sedie.release();
			d.sedieLibere++;
			
			try {
				Thread.sleep((long) (Math.random()*500+1000));
			} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			System.out.println("Cliente "+numeroCliente+" servito");
				
			d.artista.release();
		}
		
	}
}
