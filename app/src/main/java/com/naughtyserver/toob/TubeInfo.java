package com.naughtyserver.toob;

import com.naughtyserver.toob.core.TubeLine;
import com.naughtyserver.toob.core.TubeLineManager;

import java.util.Set;

/**
 * Created by jrae on 22/06/2014.
 */
public class TubeInfo {

    private final Set<TubeLine> tubeLines;

    public TubeInfo() {
        tubeLines = new TubeLineManager().getTubeLines();
        for (TubeLine tubeLine : tubeLines) {
            System.out.println(tubeLine);
        }
    }

    public String getLines() {
        StringBuilder builder = new StringBuilder();
        for (TubeLine tubeLine : tubeLines) {
            builder.append(tubeLine.name);
        }
        return builder.toString();
    }
}
