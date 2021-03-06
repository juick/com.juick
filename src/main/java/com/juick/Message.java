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

    private int MID = 0;
    
    private int RID = 0;
    
    public int ReplyTo = 0;
    private String Text = null;
    private User User = null;
    public ArrayList<String> Tags = new ArrayList<String>();
    private Date date = null;
    public int TimeAgo = 0;
    public int Privacy = 1;
    public boolean FriendsOnly = false;
    public boolean ReadOnly = false;
    public boolean Hidden = false;
    public boolean VisitorCanComment = true;
    public int Replies = 0;
    public String RepliesBy = null;
    public String AttachmentType = null;
    public String Photo = null;
    public String Video = null;
    public Place Place = null;
    public int Likes = 0;
    public boolean UserLike = false;
    public ArrayList<Message> childs = new ArrayList<Message>();

    public Message() {
    }

    public Message(Message msg) {
        setMID(msg.getMID());
        setRID(msg.getRID());
        ReplyTo = msg.ReplyTo;
        setText(msg.getText());
        setUser(msg.getUser());
        Tags = msg.Tags;
        setDate(msg.getDate());
        TimeAgo = msg.TimeAgo;
        Privacy = msg.Privacy;
        FriendsOnly = msg.FriendsOnly;
        ReadOnly = msg.ReadOnly;
        Hidden = msg.Hidden;
        Replies = msg.Replies;
        AttachmentType = msg.AttachmentType;
        Photo = msg.Photo;
        Video = msg.Video;
        Place = msg.Place;
        Likes = msg.Likes;
        UserLike = msg.UserLike;
        childs = msg.childs;
    }

    public void parseTags(String strTags) {
        if (strTags != null) {
            Tags.addAll(Arrays.asList(strTags.split(" ")));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Message)) {
            return false;
        }
        Message jmsg = (Message) obj;
        return (this.getMID() == jmsg.getMID() && this.getRID() == jmsg.getRID());
    }

    public int compareTo(Object obj) throws ClassCastException {
        if (!(obj instanceof Message)) {
            throw new ClassCastException();
        }
        Message jmsg = (Message) obj;

        if (this.getMID() != jmsg.getMID()) {
            if (this.getMID() > jmsg.getMID()) {
                return -1;
            } else {
                return 1;
            }
        }

        if (this.getRID() != jmsg.getRID()) {
            if (this.getRID() < jmsg.getRID()) {
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
            url += "/" + getMID();
            if (getRID() > 0) {
                url += "-" + getRID();
            }
            url += "." + AttachmentType;
            return url;
        } else {
            return null;
        }
    }

    public String getTagsString() {
        String ret = "";
        if (!Tags.isEmpty()) {
            for (int i = 0; i < Tags.size(); i++) {
                ret += " *" + Tags.get(i);
            }
            if (FriendsOnly) {
                ret += " *friends";
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
        }
        return ret;
    }

    public int getMID() {
        return MID;
    }

    public void setMID(int MID) {
        this.MID = MID;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public com.juick.User getUser() {
        return User;
    }

    public void setUser(com.juick.User user) {
        User = user;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }
}
