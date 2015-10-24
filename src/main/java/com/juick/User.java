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

    public int UID = 0;
    public String UName = null;
    public Object Avatar = null;
    public String FullName = null;
    public String JID = null;
    public int MessagesCount = 0;
    public String AuthHash = null;
    public boolean Banned = false;

    public User() {
    }

    public User(User u) {
        UID = u.UID;
        UName = u.UName;
        Avatar = u.Avatar;
        FullName = u.FullName;
        JID = u.JID;
        MessagesCount = u.MessagesCount;
        AuthHash = u.AuthHash;
        Banned = u.Banned;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof User && ((User) obj).UID == this.UID);
    }
}
