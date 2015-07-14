package com.base.game;

import com.base.engine.components.*;
import com.base.engine.core.*;
import com.base.engine.rendering.*;

public class TestGame extends Game {

	public void init() {
		GameObject plane = new GameObject();
		GameObject pointLight = new GameObject();
		GameObject spotLight = new GameObject();
		GameObject directionalLight = new GameObject();
		GameObject mesh1 = new GameObject();
		GameObject mesh2 = new GameObject();
		Material bricks1 = new Material();
		Material bricks2 = new Material();
		bricks1.addTexture("diffuse", new Texture("bricks2.jpg"));
		bricks1.addFloat("specularIntensity", 1);
		bricks1.addFloat("specularPower", 8);
		bricks2.addTexture("diffuse", new Texture("bricks.jpg"));
		bricks2.addFloat("specularIntensity", 1);
		bricks2.addFloat("specularPower", 8);
		plane.addComponent(new MeshRenderer(new Mesh("plane3.obj"), bricks1)).addChild(new GameObject().addComponent(new Camera((float) Math.toRadians(70), Window.getWidth() / Window.getHeight(), 0.1f, 1000)).addComponent(new FreeLook()).addComponent(new FreeMove()));
		plane.getTransform().setPos(new Vector3f(0, -1, 5));
		plane.getTransform().setScale(new Vector3f(4, 4, 4));
		pointLight.addComponent(new PointLight(new Vector3f(0, 1, 0), 0.4f, new Attenuation(0, 0, 1)));
		pointLight.getTransform().setPos(new Vector3f(7, 0, 7));
		spotLight.addComponent(new SpotLight(new Vector3f(0, 1, 1), 0.8f, new Attenuation(0, 0, 0.1f), 0.7f));
		spotLight.getTransform().setRot(new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(90)));
		directionalLight.addComponent(new DirectionalLight(new Vector3f(1, 1, 1), 0.4f));
		directionalLight.getTransform().setRot(new Quaternion(new Vector3f(1, 0, 0), (float) Math.toRadians(-45)));
		mesh1.addComponent(new MeshRenderer(new Mesh("monkey3.obj"), bricks2)).addComponent(new LookAtComponent());
		mesh1.getTransform().setPos(new Vector3f(-5, 2, 0));
		mesh1.getTransform().setScale(new Vector3f(1, 1, 1));
		mesh2.addComponent(new MeshRenderer(new Mesh("monkey3.obj"), bricks2)).addComponent(new LookAtComponent());
		mesh2.getTransform().setPos(new Vector3f(5, 2, 0));
		mesh2.getTransform().setScale(new Vector3f(1, 1, 1));
		addObject(plane);
		addObject(pointLight);
		addObject(spotLight);
		addObject(directionalLight);
		addObject(mesh1);
		addObject(mesh2);
	}
}