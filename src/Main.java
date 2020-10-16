import java.awt.EventQueue;

import br.com.unip.frames.TelaAluno;
import br.com.unip.frames.TelaInicial;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
