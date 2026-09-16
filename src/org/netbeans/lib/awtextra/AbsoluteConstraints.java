package org.netbeans.lib.awtextra;

import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;

public class AbsoluteConstraints implements Serializable {

    private static final long serialVersionUID = 1L;

    public int x;
    public int y;
    public int width = -1;
    public int height = -1;

    public AbsoluteConstraints() {
    }

    public AbsoluteConstraints(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public AbsoluteConstraints(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public AbsoluteConstraints(int x, int y, Dimension size) {
        this.x = x;
        this.y = y;
        if (size != null) {
            this.width = size.width;
            this.height = size.height;
        }
    }

    public AbsoluteConstraints(Point pos) {
        this(pos.x, pos.y);
    }

    public AbsoluteConstraints(Point pos, Dimension size) {
        this(pos.x, pos.y, size);
    }

    public AbsoluteConstraints(Dimension size) {
        if (size != null) {
            this.width = size.width;
            this.height = size.height;
        }
    }
}
