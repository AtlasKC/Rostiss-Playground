package com.base.engine.rendering;

import com.base.engine.core.Vector3f;

/**
 * File: Attenuation.java
 * Created by Atlas IND on 3/30/2015 at 10:31 PM.
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

public class Attenuation extends Vector3f {

    public Attenuation(float constant, float linear, float exponent) {
        super(constant, linear, exponent);
    }

    public float getConstant() {
        return getX();
    }

    public float getLinear() {
        return getY();
    }

    public float getExponent() {
        return getZ();
    }
}