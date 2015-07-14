package com.base.engine.components;

import com.base.engine.core.Input;
import com.base.engine.core.Vector3f;

/**
 * File: FreeMove.java
 * Created by Atlas IND on 3/31/2015 at 6:25 PM.
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

public class FreeMove extends GameComponent {

    private float speed;
    private int forward, back, left, right;

    public FreeMove() {
        this(10);
    }

    public FreeMove(float speed) {
        this(speed, Input.KEY_W, Input.KEY_S, Input.KEY_A, Input.KEY_D);
    }

    public FreeMove(float speed, int forward, int back, int left, int right) {
        this.speed = speed;
        this.forward = forward;
        this.back = back;
        this.left = left;
        this.right = right;
    }

    @Override
    public void input(float delta) {
        float movAmt = speed * delta;
        if(Input.getKey(forward))
            move(getTransform().getRot().getForward(), movAmt);
        if(Input.getKey(back))
            move(getTransform().getRot().getForward(), -movAmt);
        if(Input.getKey(left))
            move(getTransform().getRot().getLeft(), movAmt);
        if(Input.getKey(right))
            move(getTransform().getRot().getRight(), movAmt);
    }

    public void move(Vector3f dir, float amt) {
        getTransform().setPos(getTransform().getPos().add(dir.mul(amt)));
    }
}
