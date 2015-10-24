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
public class Tag implements Comparable<Tag> {

    public String Name = null;
    public int TID = 0;
    public int SynonymID = 0;
    public int UsageCnt = 0;

    @Override
    public int compareTo(Tag o) {
        return this.Name.compareTo(o.Name);
    }
}
