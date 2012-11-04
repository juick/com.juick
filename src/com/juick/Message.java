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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Ugnich Anton
 */
public class Message {

    public int MID = 0;
    public int RID = 0;
    public int ReplyTo = 0;
    public String Text = null;
    public User User = null;
    public ArrayList<String> Tags = new ArrayList<String>();
    public Date Timestamp = null;
    public String TimestampString = null;
    public int TimeAgo = 0;
    public int Privacy = 1;
    public boolean ReadOnly = false;
    public boolean VisitorCanComment = true;
    public int Replies = 0;
    public String RepliesBy = null;
    public String AttachmentType = null;
    public String Photo = null;
    public String Video = null;
    public Place Place = null;
    public ArrayList<Message> childs = new ArrayList<Message>();

    public Message() {
    }

    public Message(Message msg) {
        MID = msg.MID;
        RID = msg.RID;
        ReplyTo = msg.ReplyTo;
        Text = msg.Text;
        User = msg.User;
        Tags = msg.Tags;
        Timestamp = msg.Timestamp;
        TimestampString = msg.TimestampString;
        TimeAgo = msg.TimeAgo;
        Privacy = msg.Privacy;
        ReadOnly = msg.ReadOnly;
        Replies = msg.Replies;
        AttachmentType = msg.AttachmentType;
        Photo = msg.Photo;
        Video = msg.Video;
        Place = msg.Place;
        childs = msg.childs;
    }

    public void parseTags(String strTags) {
        Tags.addAll(Arrays.asList(strTags.split(" ")));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Message)) {
            return false;
        }
        Message jmsg = (Message) obj;
        return (this.MID == jmsg.MID && this.RID == jmsg.RID);
    }

    public int compareTo(Object obj) throws ClassCastException {
        if (!(obj instanceof Message)) {
            throw new ClassCastException();
        }
        Message jmsg = (Message) obj;

        if (this.MID != jmsg.MID) {
            if (this.MID > jmsg.MID) {
                return -1;
            } else {
                return 1;
            }
        }

        if (this.RID != jmsg.RID) {
            if (this.RID < jmsg.RID) {
                return -1;
            } else {
                return 1;
            }
        }

        return 0;
    }

    public int getChildsCount() {
        int cnt = childs.size();
        for (int i = 0; i < childs.size(); i++) {
            cnt += childs.get(i).getChildsCount();
        }
        return cnt;
    }

    public void cleanupChilds() {
        if (!childs.isEmpty()) {
            for (int i = 0; i < childs.size(); i++) {
                childs.get(i).cleanupChilds();
            }
            childs.clear();
        }
    }

    public String getAttachmentURL() {
        if (AttachmentType != null) {
            String url = "http://i.juick.com/";
            url += AttachmentType.equals("mp4") ? "video" : "photos-1024";
            url += "/" + MID;
            if (RID > 0) {
                url += "-" + RID;
            }
            url += "." + AttachmentType;
            return url;
        } else {
            return null;
        }
    }

    public String getTagsString() {
        String ret = "";
        for (int i = 0; i < Tags.size(); i++) {
            ret += " *" + Tags.get(i);
        }
        if (Privacy == -2) {
            ret += " *private";
        }
        if (Privacy == -1) {
            ret += " *friends";
        }
        if (Privacy == 2) {
            ret += " *public";
        }
        if (ReadOnly) {
            ret += " *readonly";
        }
        return ret;
    }
}
