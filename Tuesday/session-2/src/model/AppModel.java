package model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class AppModel {
    private final String id;
    private final LocalDate createdAt;

    public AppModel() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
