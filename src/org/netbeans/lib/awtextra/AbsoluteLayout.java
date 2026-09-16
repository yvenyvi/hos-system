package org.netbeans.lib.awtextra;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class AbsoluteLayout implements LayoutManager2, Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<Component, AbsoluteConstraints> constraints = new LinkedHashMap<>();

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraint) {
        if (constraint == null) {
            constraints.put(comp, new AbsoluteConstraints());
        } else if (constraint instanceof AbsoluteConstraints) {
            constraints.put(comp, (AbsoluteConstraints) constraint);
        } else if (constraint instanceof Point) {
            constraints.put(comp, new AbsoluteConstraints((Point) constraint));
        } else if (constraint instanceof Dimension) {
            constraints.put(comp, new AbsoluteConstraints((Dimension) constraint));
        } else if (constraint instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) constraint;
            constraints.put(comp, new AbsoluteConstraints(rectangle.x, rectangle.y, rectangle.width, rectangle.height));
        } else {
            throw new IllegalArgumentException("Unsupported constraint: " + constraint.getClass());
        }
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        constraints.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            return calculateLayoutSize(parent, true);
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            return calculateLayoutSize(parent, false);
        }
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            for (Component component : parent.getComponents()) {
                AbsoluteConstraints absoluteConstraints = constraints.get(component);
                if (absoluteConstraints == null) {
                    continue;
                }

                Dimension preferredSize = component.getPreferredSize();
                int width = absoluteConstraints.width >= 0 ? absoluteConstraints.width : preferredSize.width;
                int height = absoluteConstraints.height >= 0 ? absoluteConstraints.height : preferredSize.height;
                component.setBounds(absoluteConstraints.x, absoluteConstraints.y, width, height);
            }
        }
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0.5f;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0.5f;
    }

    @Override
    public void invalidateLayout(Container target) {
    }

    private Dimension calculateLayoutSize(Container parent, boolean preferred) {
        int width = 0;
        int height = 0;

        for (Component component : parent.getComponents()) {
            AbsoluteConstraints absoluteConstraints = constraints.get(component);
            if (absoluteConstraints == null) {
                continue;
            }

            Dimension size = preferred ? component.getPreferredSize() : component.getMinimumSize();
            int componentWidth = absoluteConstraints.width >= 0 ? absoluteConstraints.width : size.width;
            int componentHeight = absoluteConstraints.height >= 0 ? absoluteConstraints.height : size.height;
            width = Math.max(width, absoluteConstraints.x + componentWidth);
            height = Math.max(height, absoluteConstraints.y + componentHeight);
        }

        InsetsSafeInsets insets = new InsetsSafeInsets(parent);
        return new Dimension(width + insets.left + insets.right, height + insets.top + insets.bottom);
    }

    private static final class InsetsSafeInsets {
        final int left;
        final int right;
        final int top;
        final int bottom;

        InsetsSafeInsets(Container container) {
            java.awt.Insets insets = container.getInsets();
            if (insets == null) {
                this.left = 0;
                this.right = 0;
                this.top = 0;
                this.bottom = 0;
            } else {
                this.left = insets.left;
                this.right = insets.right;
                this.top = insets.top;
                this.bottom = insets.bottom;
            }
        }
    }
}
