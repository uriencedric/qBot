package com.uriencedric.qbot.system;

import com.uriencedric.qbot.modes.Live;
import com.uriencedric.qbot.modes.Simulation;


public enum Mode {
    LIVE,
    SIMULATION,
    BACKTESTING,
    COLLECTION;

    private static Mode state;

    public static Mode get() {
        return state;
    }

    public static void reset() {
        if (state.equals(Mode.BACKTESTING) || state.equals(Mode.COLLECTION)) return;
        if (state.equals(Mode.SIMULATION)) {
            Simulation.close();
        } else {
            Live.close();
        }
    }

    static void set(Mode state) {
        Mode.state = state;
    }
}
