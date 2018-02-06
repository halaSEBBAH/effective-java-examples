// Singleton with static factory - Page 17
package org.effectivejava.examples.chapter02.item03.method;

import java.util.function.Supplier;

public class Elvis {
	private static final Elvis INSTANCE = new Elvis();

	private Elvis() {
	}

	public static Elvis getInstance() {
		return INSTANCE;
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	// This code would normally appear outside the class!
	public static void main(String[] args) {
		Supplier<Elvis> elvis = Elvis::getInstance;
		elvis.get().leaveTheBuilding();
	}
}
