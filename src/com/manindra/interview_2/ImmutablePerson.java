package com.manindra.interview_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ImmutablePerson {

    private final String name;
    private final List<String> dept;

    public ImmutablePerson(String name, List<String> dept) {
        this.name = name;
        this.dept = new ArrayList<>(dept); // Defensive copy to prevent external modification
    }

    public String getName() {
        return name;
    }

    public List<String> getDept() {
        return Collections.unmodifiableList(dept); // Return an unmodifiable view of the list
    }
}

