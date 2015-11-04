/*
 * Juick
 * Copyright (C) 2008-2011, Ugnich Anton
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.juick;

/**
 *
 * @author Ugnich Anton
 */
public class User {

    private int UID = 0;
    private String UName = null;
    public Object Avatar = null;
    private String FullName = null;
    private String JID = null;
    public int MessagesCount = 0;
    private String AuthHash = null;
    public boolean Banned = false;

    public User() {
    }

    public User(User u) {
        setUID(u.getUID());
        setUName(u.getUName());
        Avatar = u.Avatar;
        setFullName(u.getFullName());
        setJID(u.getJID());
        MessagesCount = u.MessagesCount;
        setAuthHash(u.getAuthHash());
        Banned = u.Banned;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof User && ((User) obj).getUID() == this.getUID());
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getJID() {
        return JID;
    }

    public void setJID(String JID) {
        this.JID = JID;
    }

    public String getAuthHash() {
        return AuthHash;
    }

    public void setAuthHash(String authHash) {
        AuthHash = authHash;
    }
}
