package com.example.egguncle.ganhuo.entries;

import java.util.List;

/**
 * Created by egguncle on 16-12-5.
 */

public class GanHuoInfo {

    /**
     * error : false
     * results : [{"_id":"584186c7421aa939b58d31cd","createdAt":"2016-12-02T22:35:51.517Z","desc":"美团：常见性能优化策略的总结","publishedAt":"2016-12-05T11:40:51.351Z","source":"web","type":"Android","url":"http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651745738&idx=1&sn=413a287d6919daed31a5b3192edab3af&chksm=bd12b4878a653d91916ee74556c1eab20423ce1ee060fe4eab8ce1c46c80cc2d59afe85bd601&scene=0#rd","used":true,"who":null},{"_id":"584415e4421aa939bb4637f0","createdAt":"2016-12-04T21:11:00.62Z","desc":"干货IO 3.0，GankIO的第三方客户端，含有搜索，最新的闲读，及收藏功能。 ","images":["http://img.gank.io/918d1f3d-a553-4856-974c-5bd5abfd5b97"],"publishedAt":"2016-12-05T11:40:51.351Z","source":"web","type":"Android","url":"https://github.com/burgessjp/GanHuoIO/blob/master/README.md","used":true,"who":"solid"},{"_id":"5844d3b0421aa939b58d31d9","createdAt":"2016-12-05T10:40:48.204Z","desc":"Android 智能 Scheduler，根据用户手机场景，决定任务执行方式。","publishedAt":"2016-12-05T11:40:51.351Z","source":"chrome","type":"Android","url":"https://github.com/hypertrack/smart-scheduler-android","used":true,"who":"代码家"},{"_id":"58259f06421aa91369f95a31","createdAt":"2016-11-11T18:35:50.62Z","desc":"史上最强，易用可扩展的 Android log 库","publishedAt":"2016-12-02T12:13:34.224Z","source":"web","type":"Android","url":"https://github.com/elvishew/XLog","used":true,"who":"Elvis Hew"},{"_id":"5840c577421aa939befafaf6","createdAt":"2016-12-02T08:51:03.787Z","desc":"深入Android消息机制","publishedAt":"2016-12-02T12:13:34.224Z","source":"web","type":"Android","url":"http://blog.csdn.net/ccj659/article/details/53422746","used":true,"who":"Chauncey"},{"_id":"583ba766421aa9710ec9340b","createdAt":"2016-11-28T11:41:26.668Z","desc":"滚动时图片产生视差效果的ImageView","images":["http://img.gank.io/5ff18d45-6bd9-4858-9a99-e8ed00a82ec7"],"publishedAt":"2016-12-01T11:36:13.685Z","source":"web","type":"Android","url":"https://github.com/gjiazhe/ScrollParallaxImageView","used":true,"who":"郭佳哲"},{"_id":"583c4e52421aa971108b6598","createdAt":"2016-11-28T23:33:38.6Z","desc":"在Android图形处理-Canvas已经有了基本的使用，但是这节介绍几个好玩的属性","images":["http://img.gank.io/4ad4a5a7-7c57-4a31-bf10-eaab88ba6391"],"publishedAt":"2016-12-01T11:36:13.685Z","source":"web","type":"Android","url":"http://www.haotianyi.win/2016/11/android%E5%9B%BE%E5%BD%A2%E5%A4%84%E7%90%86-%E7%99%BE%E5%8F%98paint.html","used":true,"who":"HaoTianYi"},{"_id":"583f700f421aa939befafae7","createdAt":"2016-12-01T08:34:23.85Z","desc":"简单实用的页面多状态布局(content,loading,empty,error)","images":["http://img.gank.io/2074ca5d-578d-455d-8a96-9ec92869421d","http://img.gank.io/229ccb07-603c-4451-9807-d2672b2f1671"],"publishedAt":"2016-12-01T11:36:13.685Z","source":"web","type":"Android","url":"https://github.com/czy1121/loadinglayout","used":true,"who":"ezy"},{"_id":"583f7f75421aa939b58d31be","createdAt":"2016-12-01T09:40:05.296Z","desc":"一开始，我只是想用它来显示Github贡献图，所以才给它起名字叫TContributionsView，后来，我发现它似乎还有很多更有意思的玩法\u2026\u2026","images":["http://img.gank.io/4267408e-82c7-4b5e-a8c6-dc0c3cc787a0","http://img.gank.io/0bab9df3-ae49-4029-be63-ebdb2d9e6d65"],"publishedAt":"2016-12-01T11:36:13.685Z","source":"web","type":"Android","url":"https://github.com/barryhappy/TContributionsView","used":true,"who":"Barry"},{"_id":"583f8ff8421aa939b835360c","createdAt":"2016-12-01T10:50:32.704Z","desc":"360黑科技，未经用户同意自动开启辅助功能","publishedAt":"2016-12-01T11:36:13.685Z","source":"chrome","type":"Android","url":"http://www.freebuf.com/articles/terminal/121253.html","used":true,"who":"Dear宅学长"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 584186c7421aa939b58d31cd
         * createdAt : 2016-12-02T22:35:51.517Z
         * desc : 美团：常见性能优化策略的总结
         * publishedAt : 2016-12-05T11:40:51.351Z
         * source : web
         * type : Android
         * url : http://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651745738&idx=1&sn=413a287d6919daed31a5b3192edab3af&chksm=bd12b4878a653d91916ee74556c1eab20423ce1ee060fe4eab8ce1c46c80cc2d59afe85bd601&scene=0#rd
         * used : true
         * who : null
         * images : ["http://img.gank.io/918d1f3d-a553-4856-974c-5bd5abfd5b97"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
