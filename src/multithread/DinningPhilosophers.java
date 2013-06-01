package multithread;

import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.Question;

public class DinningPhilosophers extends Question {

	@Override
	public String getQuestion() {
		return "Dinning Professor";
	}

	@Test(dataProvider = "dataProvider")
	public void eat(final Philosopher[] philosophers, boolean deadlock) throws InterruptedException {

		Runnable runable = new Runnable() {

			public void run() {

				int count = philosophers.length;

				Thread[] ts = new Thread[count];
				for (int i = 0; i < count; i++) {
					ts[i] = new Thread(philosophers[i]);
					ts[i].start();
				}

				for (int i = 0; i < count; i++) {
					try {
						ts[i].join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t = new Thread(runable);
		t.start();

		int sleep = 0;
		while (sleep < 30000 && t.isAlive()) {
			sleep += 1000;
			System.out.println("waiting " + sleep);
			Thread.sleep(1000);
		}

		assertEquals("No expected deadlock (" + deadlock + ") result", deadlock, t.isAlive());
	}

	@DataProvider
	public static Object[][] dataProvider() {

		int count = 5;
		Philosopher[] stupids = new Philosopher[count];
		Philosopher[] smarts = new Philosopher[count];

		Chopstick[] chopSticks = new Chopstick[count];
		Chopstick[] chopSticks2 = new Chopstick[count];

		for (int i = 0; i < count; i++) {
			chopSticks[i] = new Chopstick();
			chopSticks2[i] = new Chopstick();
		}

		for (int i = 0; i < count; i++) {
			stupids[i] = new Stupid(i, 10, chopSticks[i], chopSticks[(i + 1) % count]);
			smarts[i] = new Smart(i, 10, chopSticks2[i], chopSticks2[(i + 1) % count]);
		}

		return new Object[][] { { stupids, true }, { smarts, false } };
	}

	public static class Smart extends Philosopher {

		public Smart(int no, int actionCount, Chopstick left, Chopstick right) {
			super(no, actionCount, left, right);
		}

		@Override
		public void pick() {
			System.out.println("Philosopher No." + no + " pick.");

			while (true) {

				if (this.left.lock.tryLock()) {
					if (this.right.lock.tryLock()) {
						break;
					}

					this.left.lock.unlock();
				}

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void put() {
			System.out.println("Philosopher No." + no + " put.");
			this.left.lock.unlock();
			this.right.lock.unlock();
		}
	}

	public static class Stupid extends Philosopher {

		public Stupid(int no, int actionCount, Chopstick left, Chopstick right) {
			super(no, actionCount, left, right);
		}

		@Override
		public void pick() {
			System.out.println("Philosopher No." + no + " pick.");
			this.left.lock.lock();
			this.right.lock.lock();
		}

		@Override
		public void put() {
			System.out.println("Philosopher No." + no + " put.");
			this.left.lock.unlock();
			this.right.lock.unlock();
		}
	}

	public static abstract class Philosopher implements Runnable {

		int actionCount;
		Chopstick left;
		Chopstick right;
		int no;

		public Philosopher(int no, int actionCount, Chopstick left, Chopstick right) {
			this.actionCount = actionCount;
			this.left = left;
			this.right = right;
			this.no = no;
		}

		public void eat(int i) {

			try {
				System.out.println("Philosopher No." + no + " now eating (" + i + ").");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public abstract void pick();

		public abstract void put();

		public void run() {

			for (int i = 0; i < actionCount; i++) {
				pick();
				eat(i);
				put();
			}
			System.out.println("Philosopher No." + no + " leaves.");
		}
	}

	public static class Chopstick {
		public Lock lock = new ReentrantLock();
	}
}
