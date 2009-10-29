package com.miriamlaurel.hollywood;

import com.miriamlaurel.hollywood.annotations.State;

/**
 * RootState is the ancestor of all state classes. Well, <em>actually</em> the ancestor is Actor class, but
 * it looks weird in state-related method signatures. So, this class is introduced for readability.
 *
 * @author Alexander Temerev, Alexander Kuklev
 * @version $Id$
 */
public class RootState {

    /**
     * Override this method to execute code right after entering the state.
     */
    public void onEnter() {}

    /**
     * Override this method to execute code right before exiting the state.
     */
    public void onExit() {}

    /**
     * Get state name. By default, it's a simple name (without a package path). This can be overriden with
     * <code>name</code> property in <code>@State</code> annotation.
     *
     * @return State name, for debugging purposes and display.
     */
    public String toString() {
        State stateAnnotation = this.getClass().getSuperclass().getAnnotation(State.class);
        String stateName = stateAnnotation.name();
        if (stateName.equals("")) {
            return this.getClass().getSuperclass().getSimpleName();
        } else {
            return stateName;
        }
    }
}
