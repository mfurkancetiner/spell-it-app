package com.furkan.spell_it_app.model;

import java.util.Arrays;
import java.util.List;

public enum Role {

    ADMIN(Arrays.asList(Permission.ADD_CLIP, Permission.REMOVE_CLIP, Permission.WATCH_CLIP)),
    USER(List.of(Permission.WATCH_CLIP));


    List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
