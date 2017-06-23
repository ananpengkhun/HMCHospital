package com.example.ananpengkhun.hmchospital.httpmanager.request;

/**
 * Created by ananpengkhun on 6/23/17.
 */

public class FirebaseToRecepNotify {

    /**
     * to : /topics/doctor
     * priority : high
     * notification : {"body":"patient","title":"patient"}
     * data : {"picture_url":"http://www3i.adintrend.com/upload_img2/screenshot/movies_movies/2012-03/006/pic02-big.jpg"}
     */

    private String to;
    private String priority;
    private NotificationBean notification;
    private DataBean data;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public NotificationBean getNotification() {
        return notification;
    }

    public void setNotification(NotificationBean notification) {
        this.notification = notification;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class NotificationBean {
        /**
         * body : patient
         * title : patient
         */

        private String body;
        private String title;
        private String click_action;
        private String user_type;

        public String getUser_type() {
            return user_type;
        }

        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }

        public String getClick_action() {
            return click_action;
        }

        public void setClick_action(String click_action) {
            this.click_action = click_action;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class DataBean {
        /**
         * picture_url : http://www3i.adintrend.com/upload_img2/screenshot/movies_movies/2012-03/006/pic02-big.jpg
         */

        private String picture_url;

        public String getPicture_url() {
            return picture_url;
        }

        public void setPicture_url(String picture_url) {
            this.picture_url = picture_url;
        }
    }
}
