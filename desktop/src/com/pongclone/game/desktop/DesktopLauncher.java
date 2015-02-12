package com.pongclone.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pongclone.game.PongCloneGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();

        cfg.resizable = true;
        cfg.width = 800;
        cfg.height = 600;
        cfg.fullscreen = false;
        cfg.samples = 4;
        cfg.vSyncEnabled = false;

		new LwjglApplication(new PongCloneGame(), cfg);
	}
}
