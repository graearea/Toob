package com.naughtyserver.toob.core;

import java.io.Serializable;
import java.awt.*;

/**
 * Created by jrae on 24/06/2014.
 */
public class TubeLine implements Serializable{
    public final String name;
    public final int id;
    public final Color color;

    public TubeLine(final int id, final String name, final Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final TubeLine tubeLine = (TubeLine) o;

        if (id != tubeLine.id) {
            return false;
        }
        if (color != null ? !color.equals(tubeLine.color) : tubeLine.color != null) {
            return false;
        }
        if (name != null ? !name.equals(tubeLine.name) : tubeLine.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

}
