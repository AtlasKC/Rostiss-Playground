package com.base.engine.components;

import com.base.engine.core.Input;
import com.base.engine.core.Vector2f;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Window;

/**
 * File: FreeLook.java
 * Created by Atlas IND on 3/31/2015 at 6:18 PM.
 * [2014] - [2015] Rostiss Development
 * All rights reserved.
 * <p/>
 * NOTICE:  All information contained herein is, and remains
 * the property of Rostiss Development and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Rostiss Development
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Rostiss Development.
 */

public class FreeLook extends GameComponent {

    private Vector2f centerPosition = new Vector2f(Window.getWidth() / 2, Window.getHeight() / 2);
    private int unlock;
    private float sensitivity;
    private boolean mouseLocked = false;

    public FreeLook() {
        this(0.75f);
    }

    public FreeLook(float sensitivity) {
        this(sensitivity, Input.KEY_ESCAPE);
    }

    public FreeLook(float sensitivity, int unlock) {
        this.sensitivity = sensitivity;
        this.unlock = unlock;
    }

    @Override
    public void input(float delta) {
        if(Input.getKey(unlock)) {
            Input.setMousePosition(centerPosition);
            Input.setCursor(true);
            mouseLocked = false;
        }
        if(Input.getMouseDown(0)) {
            Input.setMousePosition(centerPosition);
            Input.setCursor(false);
            mouseLocked = true;
        }
        if(mouseLocked) {
            Vector2f deltaPos = Input.getMousePosition().sub(centerPosition);
            boolean rotY = deltaPos.getX() != 0;
            boolean rotX = deltaPos.getY() != 0;
            if(rotY)
                getTransform().rotate(new Vector3f(0, 1, 0), (float) Math.toRadians(deltaPos.getX() * sensitivity));
            if(rotX)
                getTransform().rotate(getTransform().getRot().getRight(), (float) Math.toRadians(-deltaPos.getY() * sensitivity));
            if(rotY || rotX)
                Input.setMousePosition(centerPosition);
        }
    }
}
