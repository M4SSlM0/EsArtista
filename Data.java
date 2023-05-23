import java.util.concurrent.Semaphore;

public class Data {
	Semaphore sedie;
	Semaphore artista;
	int sedieLibere;
	public Data(Semaphore a,Semaphore s,int l) {
		artista=a;
		sedie=s;
		sedieLibere=l;
	}
}
