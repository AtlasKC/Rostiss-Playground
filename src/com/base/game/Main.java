package com.base.game;

import com.base.engine.core.CoreEngine;

public class Main {

	public static void main(String[] args) {
		CoreEngine engine = new CoreEngine(1280, 720, 120, new TestGame());
		engine.createWindow("Rostiss Engine - AtlasIND");
		engine.start();
	}
}