package com.xosmig.seleniumhw;

import java.util.Objects;

public class Issue {
    private final String summary;
    private final String description;

    public Issue(String summary, String description) {
        this.summary = summary;
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Issue)) return false;
        final Issue issue = (Issue) o;
        return Objects.equals(summary, issue.summary) &&
                Objects.equals(description, issue.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, description);
    }
}
