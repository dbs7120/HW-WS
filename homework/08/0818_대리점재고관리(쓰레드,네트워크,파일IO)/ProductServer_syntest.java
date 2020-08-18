package d0818.Product;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ProductServer_syntest {

	public ProductServer_syntest() {
		try (ServerSocket serverSocket = new ServerSocket(8080)) {
			System.out.println("ABC Product Server Start");
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread(() -> {

					try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

						@SuppressWarnings("unchecked")
						ArrayList<Product> products = (ArrayList<Product>) ois.readObject();

						System.out.println(">전송받음");

						synchronized (this) {
							for (Product e : products) {

								if (e instanceof Refrigerator) {
									try {
										wait();
										System.out.println(e);
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									}

								}
								if (e instanceof TV) {
									System.out.println(e);


								}

							}
							notifyAll();
						}

					} catch (IOException | ClassNotFoundException e) {
						e.printStackTrace();
					}

				}).start();
			}
		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new ProductServer_syntest();
	}
}